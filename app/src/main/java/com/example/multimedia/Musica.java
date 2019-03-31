package com.example.multimedia;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Musica extends AppCompatActivity {

    ProgressBar progressBarHorizontal;
    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;

    MediaPlayer vectormp [] = new MediaPlayer [3];
    int posision=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        play_pause = (Button)findViewById(R.id.btn_play);
        btn_repetir = (Button)findViewById(R.id.btn_repetir);
        iv = (ImageView)findViewById(R.id.imageView);


        vectormp[0] = MediaPlayer.create(this, R.raw.race);
        vectormp[1] = MediaPlayer.create(this, R.raw.sound);
        vectormp[2] = MediaPlayer.create(this, R.raw.tea);




    }

    //Método para el botón PlayPause
    public void PlayPause(View view){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        } else {
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para el botón Stop
    public void Stop(View view){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();

            vectormp[0] = MediaPlayer.create(this, R.raw.race);
            vectormp[1] = MediaPlayer.create(this, R.raw.sound);
            vectormp[2] = MediaPlayer.create(this, R.raw.tea);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    //Método repetir una pista
    public void Repetir(View view){
        if(repetir == 1){
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        } else {
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    //Método para saltar a la siguiente canción.
    public void Siguiente(View view){
        TextView num= (TextView) findViewById(R.id.nom);
        TextView num2= (TextView) findViewById(R.id.nom2);
        TextView num3= (TextView) findViewById(R.id.nom3);
        TextView num4= (TextView) findViewById(R.id.nom4);
        if(posicion==1){
            num.setText("Cancion 1");
            num2.setText("Mansionair");
            num3.setText("Easier");
            num4.setText("Shadowboxer");
        }
        else if (posicion==2){
            num.setText("Cancion 3");
            num2.setText("Flume/Chet Faker");
            num3.setText("Drop the Game");
            num4.setText("TheSoundYouNeed");

        }
        else{
            num.setText("Cancion 2");
            num2.setText("Dennis Lloyd");
            num3.setText("Loftovers");
            num4.setText("Loftovers");
        }
        if(posicion >= 1){

            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.race);
                vectormp[1] = MediaPlayer.create(this, R.raw.sound);
                vectormp[2] = MediaPlayer.create(this, R.raw.tea);
                posicion--;

                if(posicion == 0){

                    iv.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }
                vectormp[posicion].start();

            } else {
                posicion--;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);

                } else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }
            }

        } else {
            iv.setImageResource(R.drawable.portada3);
            vectormp[posicion].stop();
            posicion=2;
            vectormp[posicion].start();
        }
    }

    public void muestra(View view){
        if(posicion==1) {

        }
    }

    //Método para regresar a la canción anterior
    public void Anterior(View view){
        if(posicion >= 1){

            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.race);
                vectormp[1] = MediaPlayer.create(this, R.raw.sound);
                vectormp[2] = MediaPlayer.create(this, R.raw.tea);
                posicion--;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                    //num.setText("1");
                } else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                    //num.setText("2");
                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                    //num.setText("3");
                }

                vectormp[posicion].start();

            } else {
                posicion--;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    iv.setImageResource(R.drawable.portada2);
                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.portada3);
                }
            }

        } else {
            iv.setImageResource(R.drawable.portada3);
            vectormp[posicion].stop();
            posicion=2;
            vectormp[posicion].start();
        }

    }

}


    /*@Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_play:
                    break;
                case R.id.btn_stop:
                    break;
                case R.id.btn_repetir:
                    break;

            }
    }*/

