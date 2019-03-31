package com.example.multimedia;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SwipeImageActivity extends Activity {
    public static Integer[] Images = {
            R.drawable.astronauta,
            R.drawable.dragonball,
            R.drawable.giphy,
            R.drawable.homero,
            R.drawable.mercedes,
            R.drawable.mustang
    };

    private boolean hideSwipeText;
    private String[] imagesDescription;

    public void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);

        setContentView(R.layout.swipe_images);

        String i = getIntent().getStringExtra("position");

        int index = Integer.parseInt(i);

        imagesDescription = getResources().getStringArray(R.array.images_description);

        SwipeImagePagerAdapter swipeNewAdapter = new SwipeImagePagerAdapter();
        ViewPager newsPager = (ViewPager) findViewById(R.id.swipe_pager);
        newsPager.setAdapter(swipeNewAdapter);
        newsPager.setCurrentItem(index);

        newsPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ShowGalleryActivity.mSelected = position;

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private  class SwipeImagePagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return ShowGalleryActivity.ImagesThumbnail.length;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position){
            LayoutInflater inflater = (LayoutInflater) collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.show_images, null);
            LinearLayout swipeDescription = (LinearLayout) view.findViewById(R.id.swipe_description);

            if (hideSwipeText){
                swipeDescription.setVisibility(View.GONE);
            }
            hideSwipeText = true;

            ImageView imageView =  (ImageView) view.findViewById(R.id.gallery_image);

            imageView.setImageResource(Images[position]);

            TextView imageDescription = (TextView) view.findViewById(R.id.image_description);

            imageDescription.setText(imagesDescription[position].toString());

            collection.addView(view, 0);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view){
            collection.removeView((View) view);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }
    }

}
