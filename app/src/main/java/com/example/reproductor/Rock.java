package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Rock extends AppCompatActivity {
     ImageButton playPause, btnRepetir;
     MediaPlayer mp;
     ImageView iv;
     int repetir=2, posicion=0;

     MediaPlayer vectormp[]=new MediaPlayer[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock);

        playPause=(ImageButton) findViewById(R.id.btnPlay);
        btnRepetir=(ImageButton) findViewById(R.id.btnRepetir);
        iv=(ImageView) findViewById(R.id.imageView);

        vectormp[0]=MediaPlayer.create(this, R.raw.r1gnr);
        vectormp[1]=MediaPlayer.create(this, R.raw.r2rhcp);
        vectormp[2]=MediaPlayer.create(this, R.raw.r3k);
        vectormp[3]=MediaPlayer.create(this, R.raw.r4d);
        vectormp[4]=MediaPlayer.create(this, R.raw.r5u2);
    }
    public void PlayPause(View view){
        if (vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            playPause.setBackgroundResource(R.drawable.playc);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }else{
            vectormp[posicion].start();
            playPause.setBackgroundResource(R.drawable.playc);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
        if(posicion==0){
            Toast.makeText(this, "Cancion: Yesterdays\nArtista: Guns N' Roses\nAlbum: Use Your Illusion II", Toast.LENGTH_LONG).show();
        }
    }
    public void Stop(View view){
        if (vectormp[posicion]!=null){
            vectormp[posicion].stop();

            vectormp[0]=MediaPlayer.create(this, R.raw.r1gnr);
            vectormp[1]=MediaPlayer.create(this, R.raw.r2rhcp);
            vectormp[2]=MediaPlayer.create(this, R.raw.r3k);
            vectormp[3]=MediaPlayer.create(this, R.raw.r4d);
            vectormp[4]=MediaPlayer.create(this, R.raw.r5u2);
            posicion=0;
            playPause.setBackgroundResource(R.drawable.play);
            iv.setImageResource(R.drawable.ir1gnr);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }
    public void Repetir(View view){
        if (repetir==1){
            btnRepetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "No Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir=2;
        }else {
            btnRepetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir=1;
        }
    }
    public void Siguiente(View view){
        if (posicion< vectormp.length -1){
            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();
                if(posicion==0){
                    iv.setImageResource(R.drawable.ir1gnr);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.ir2rhcp);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.ir3k);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.ir4d);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.ir5u2);
                }
            }else {
                posicion++;
                if(posicion==0){
                    iv.setImageResource(R.drawable.ir1gnr);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.ir2rhcp);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.ir3k);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.ir4d);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.ir5u2);
                }
            }
            if(posicion==0){
                Toast.makeText(this, "Cancion: Yesterdays\nArtista: Guns N' Roses\nAlbum: Use Your Illusion II", Toast.LENGTH_LONG).show();
            }else if(posicion==1){
                Toast.makeText(this, "Cancion: Dark Necessities\nArtista: Red Hot Chili Peppers\nAlbum: The Getaway", Toast.LENGTH_LONG).show();
            }else if(posicion==2){
                Toast.makeText(this, "Cancion: Somewhere Only We Know\nArtista: Keane\nAlbum: Hopes And Fears", Toast.LENGTH_LONG).show();
            }else if(posicion==3){
                Toast.makeText(this, "Cancion: Entombed\nArtista: Deftones\nAlbum: Koi No Yokan", Toast.LENGTH_LONG).show();
            }else if(posicion==4){
                Toast.makeText(this, "Cancion: Pride (In The Name Of Love)\nArtista: U2\nAlbum: The Unforgettable Fire", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
    public void Anterior(View view){
        if(posicion>=1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0]=MediaPlayer.create(this, R.raw.r1gnr);
                vectormp[1]=MediaPlayer.create(this, R.raw.r2rhcp);
                vectormp[2]=MediaPlayer.create(this, R.raw.r3k);
                vectormp[3]=MediaPlayer.create(this, R.raw.r4d);
                vectormp[4]=MediaPlayer.create(this, R.raw.r5u2);

                posicion--;

                if(posicion==0){
                    iv.setImageResource(R.drawable.ir1gnr);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.ir2rhcp);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.ir3k);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.ir4d);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.ir5u2);
                }

                vectormp[posicion].start();
            }else{
                posicion--;
                if(posicion==0){
                    iv.setImageResource(R.drawable.ir1gnr);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.ir2rhcp);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.ir3k);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.ir4d);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.ir5u2);
                }
            }
            if(posicion==0){
                Toast.makeText(this, "Cancion: Yesterdays\nArtista: Guns N' Roses\nAlbum: Use Your Illusion II", Toast.LENGTH_LONG).show();
            }else if(posicion==1){
                Toast.makeText(this, "Cancion: Dark Necessities\nArtista: Red Hot Chili Peppers\nAlbum: The Getaway", Toast.LENGTH_LONG).show();
            }else if(posicion==2){
                Toast.makeText(this, "Cancion: Somewhere Only We Know\nArtista: Keane\nAlbum: Hopes And Fears", Toast.LENGTH_LONG).show();
            }else if(posicion==3){
                Toast.makeText(this, "Cancion: Entombed\nArtista: Deftones\nAlbum: Koi No Yokan", Toast.LENGTH_LONG).show();
            }else if(posicion==4){
                Toast.makeText(this, "Cancion: Pride (In The Name Of Love)\nArtista: U2\nAlbum: The Unforgettable Fire", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
}