package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Metal extends AppCompatActivity {
    ImageButton playPause, btnRepetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir=2, posicion=0;

    MediaPlayer vectormp[]=new MediaPlayer[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metal);

        playPause=(ImageButton) findViewById(R.id.btnPlayM);
        btnRepetir=(ImageButton) findViewById(R.id.btnRepetirM);
        iv=(ImageView) findViewById(R.id.imageViewM);

        vectormp[0]=MediaPlayer.create(this, R.raw.m1mh);
        vectormp[1]=MediaPlayer.create(this, R.raw.m2k);
        vectormp[2]=MediaPlayer.create(this, R.raw.m3s);
        vectormp[3]=MediaPlayer.create(this, R.raw.m4kse);
        vectormp[4]=MediaPlayer.create(this, R.raw.m5if);
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
            Toast.makeText(this, "Cancion: Aesthetics Of Hate\nArtista: Machine Head\nAlbum: The Blackening", Toast.LENGTH_LONG).show();
        }
    }
    public void Stop(View view){
        if (vectormp[posicion]!=null){
            vectormp[posicion].stop();

            vectormp[0]=MediaPlayer.create(this, R.raw.m1mh);
            vectormp[1]=MediaPlayer.create(this, R.raw.m2k);
            vectormp[2]=MediaPlayer.create(this, R.raw.m3s);
            vectormp[3]=MediaPlayer.create(this, R.raw.m4kse);
            vectormp[4]=MediaPlayer.create(this, R.raw.m5if);
            posicion=0;
            playPause.setBackgroundResource(R.drawable.play);
            iv.setImageResource(R.drawable.im1mh);
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
                    iv.setImageResource(R.drawable.im1mh);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.im2k);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.im3s);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.im4kse);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.im5if);
                }
            }else {
                posicion++;
                if(posicion==0){
                    iv.setImageResource(R.drawable.im1mh);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.im2k);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.im3s);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.im4kse);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.im5if);
                }
            }
            if(posicion==0){
                Toast.makeText(this, "Cancion: Aesthetics Of Hate\nArtista: Machine Head\nAlbum: The Blackening", Toast.LENGTH_LONG).show();
            }else if(posicion==1){
                Toast.makeText(this, "Cancion: Satan Is Real\nArtista: Kreator\nAlbum: Gods Of Violence", Toast.LENGTH_LONG).show();
            }else if(posicion==2){
                Toast.makeText(this, "Cancion: Sulfur\nArtista: Slipknot\nAlbum: All Hope Is Gone", Toast.LENGTH_LONG).show();
            }else if(posicion==3){
                Toast.makeText(this, "Cancion: This Fire\nArtista: Killswitch Engage\nAlbum: As Daylight Dies", Toast.LENGTH_LONG).show();
            }else if(posicion==4){
                Toast.makeText(this, "Cancion: I Am Above\nArtista: In Flames\nAlbum: I, The Mask", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
    public void Anterior(View view){
        if(posicion>=1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0]=MediaPlayer.create(this, R.raw.m1mh);
                vectormp[1]=MediaPlayer.create(this, R.raw.m2k);
                vectormp[2]=MediaPlayer.create(this, R.raw.m3s);
                vectormp[3]=MediaPlayer.create(this, R.raw.m4kse);
                vectormp[4]=MediaPlayer.create(this, R.raw.m5if);

                posicion--;

                if(posicion==0){
                    iv.setImageResource(R.drawable.im1mh);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.im2k);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.im3s);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.im4kse);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.im5if);
                }

                vectormp[posicion].start();
            }else{
                posicion--;
                if(posicion==0){
                    iv.setImageResource(R.drawable.im1mh);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.im2k);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.im3s);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.im4kse);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.im5if);
                }
            }
            if(posicion==0){
                Toast.makeText(this, "Cancion: Aesthetics Of Hate\nArtista: Machine Head\nAlbum: The Blackening", Toast.LENGTH_LONG).show();
            }else if(posicion==1){
                Toast.makeText(this, "Cancion: Satan Is Real\nArtista: Kreator\nAlbum: Gods Of Violence", Toast.LENGTH_LONG).show();
            }else if(posicion==2){
                Toast.makeText(this, "Cancion: Sulfur\nArtista: Slipknot\nAlbum: All Hope Is Gone", Toast.LENGTH_LONG).show();
            }else if(posicion==3){
                Toast.makeText(this, "Cancion: This Fire\nArtista: Killswitch Engage\nAlbum: As Daylight Dies", Toast.LENGTH_LONG).show();
            }else if(posicion==4){
                Toast.makeText(this, "Cancion: I Am Above\nArtista: In Flames\nAlbum: I, The Mask", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
}