package com.example.multimedia;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ShowGalleryActivity extends Activity{

    public static int mSelected=0;
    private GridView gridview;

    public static Integer[] ImagesThumbnail = {
            R.drawable.astronauta,
            R.drawable.dragonball,
            R.drawable.giphy,
            R.drawable.homero,
            R.drawable.mercedes,
            R.drawable.mustang
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.images_gallery);

        gridview = findViewById(R.id.girdView_Gallery);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setSelection(mSelected);
    }

    @SuppressLint("ResourceType")
    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.mipmap.ic_launcher_round, menu);
        return true;
    }

    public class ImageAdapter extends BaseAdapter {

        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return ImagesThumbnail.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, final View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 130));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView.setCropToPadding(true);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                }

                imageView.setPadding(2, 2, 2, 2);

            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(ImagesThumbnail[position]);


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSelected = (Integer) convertView.getTag();
                    notifyDataSetChanged();

                    String index = String.valueOf(position);
                    Bundle extras = new Bundle();

                    extras.putString("position", index);
                    startActivity(new Intent(ShowGalleryActivity.this, SwipeImageActivity.class).putExtras(extras).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            });

            try {
                imageView.setTag(position);

                if (position == mSelected) {
                    imageView.setBackgroundColor(Color.parseColor("#ff6203"));
                } else {
                    imageView.setBackgroundColor(Color.TRANSPARENT);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return imageView;
        }
    }
}
