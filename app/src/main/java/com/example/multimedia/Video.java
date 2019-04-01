package com.example.multimedia;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.VideoView;

public class Video extends AppCompatActivity implements View.OnClickListener {
           VideoView video;
    VideoView vectormp [] = new VideoView [3];


    int con=-1;
    private Button buttonpause;
    private Button btn_play;
    private Button btnPause;
    private Button btnStop;
    private Button next;
    private Button btnSig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        vectormp[0]=(VideoView) findViewById(R.id.videoView);

//        video.setVideoURI(Uri.parse(path));
//        video.start();
        btn_play=(Button) findViewById(R.id.buttonplay);
        btnSig=(Button) findViewById(R.id.Buttonsig);
        buttonpause=(Button) findViewById(R.id.buttonpause);
        btn_play.setOnClickListener(this);
        btnSig.setOnClickListener(this);
        buttonpause.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        int num=0;
        switch(v.getId()){
            case R.id.Buttonsig:
                con++ ;
                if(con==0) {
                    num=0;

                    play(num);

                }else if(con==1){
                    num=1;

                    play(num);
                }else if(con==2){
                num=2;

                play(num);
                }else if(con>2){
                    con=-1;
                }

                break;
            case R.id.buttonplay:
                if(con==-1){
                    con=0;
                }
                if(con==0) {
                    num=0;

                    play(num);

                }else if(con==1){
                    num=1;

                    play(num);
                }else if(con==2){
                    num=2;

                    play(num);
                }else if(con>2){
                    con=-1;
                }
                break;
            case R.id.buttonpause:
                if(con==0) {
                    num=0;

                    pause(num);

                }else if(con==1){
                    num=1;

                    pause(num);
                }else if(con==2){
                    num=2;

                    pause(num);
                }else if(con>2){
                    con=-1;
                }
                break;
        }
    }
    public void play(int con){
        String path = "android.resource://" + getPackageName() + "/" + R.raw.forn3;
        String path2 = "android.resource://" + getPackageName() + "/" + R.raw.fort;
        String path3 = "android.resource://" + getPackageName() + "/" + R.raw.fort2;
        if(con==0) {
            vectormp[0].setVideoURI(Uri.parse(path));
            vectormp[0].start();
        }else if(con==1){
            vectormp[0].setVideoURI(Uri.parse(path2));
            vectormp[0].start();
        }else if (con==2){
            vectormp[0].setVideoURI(Uri.parse(path3));
            vectormp[0].start();
        }
    }
    public void pause(int con){
        String path = "android.resource://" + getPackageName() + "/" + R.raw.forn3;
        String path2 = "android.resource://" + getPackageName() + "/" + R.raw.fort;
        String path3 = "android.resource://" + getPackageName() + "/" + R.raw.fort2;
        if(con==0) {
            vectormp[0].setVideoURI(Uri.parse(path));
            vectormp[0].pause();
        }else if(con==1){
            vectormp[0].setVideoURI(Uri.parse(path2));
            vectormp[0].pause();
        }else if (con==2){
            vectormp[0].setVideoURI(Uri.parse(path3));
            vectormp[0].pause();
        }
    }
}
