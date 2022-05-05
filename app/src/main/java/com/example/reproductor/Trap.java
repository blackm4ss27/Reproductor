package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Trap extends AppCompatActivity {
    ImageButton playPausa,btnRepetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir=2, posicion=0;

    MediaPlayer vectormp[]=new MediaPlayer[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trap);

        iv=(ImageView) findViewById(R.id.imageViewT);
        playPausa=(ImageButton)findViewById(R.id.imageButton3);
        btnRepetir=(ImageButton)findViewById(R.id.imageButton6);

        vectormp[0]=MediaPlayer.create(this, R.raw.t1gm);
        vectormp[1]=MediaPlayer.create(this, R.raw.t2lp);
        vectormp[2]=MediaPlayer.create(this, R.raw.t3sb);
        vectormp[3]=MediaPlayer.create(this, R.raw.t4xt);
        vectormp[4]=MediaPlayer.create(this, R.raw.t5p);
    }
    public void PlayPause(View view){
        if (vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            playPausa.setBackgroundResource(R.drawable.playc);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }else{
            vectormp[posicion].start();
            playPausa.setBackgroundResource(R.drawable.playc);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
            if(posicion==0) {
                Toast.makeText(this, "Cancion: Squeeze\nArtista: Ghostemane\nAlbum: Hexada", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void Stop(View view){
        if (vectormp[posicion]!=null){
            vectormp[posicion].stop();

            vectormp[0]=MediaPlayer.create(this, R.raw.t1gm);
            vectormp[1]=MediaPlayer.create(this, R.raw.t2lp);
            vectormp[2]=MediaPlayer.create(this, R.raw.t3sb);
            vectormp[3]=MediaPlayer.create(this, R.raw.t4xt);
            vectormp[4]=MediaPlayer.create(this, R.raw.t5p);
            posicion=0;
            playPausa.setBackgroundResource(R.drawable.playc);
            iv.setImageResource(R.drawable.it1gm);
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
                    iv.setImageResource(R.drawable.it1gm);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.it2lp);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.it3sb);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.it4xt);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.it5p);
                }
            }else {
                posicion++;
                if(posicion==0){
                    iv.setImageResource(R.drawable.it1gm);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.it2lp);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.it3sb);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.it4xt);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.it5p);
                }
            }
            if(posicion==0){
                Toast.makeText(this, "Cancion: Squeeze\nArtista: Ghostemane\nAlbum: Hexada", Toast.LENGTH_LONG).show();
            }else if(posicion==1){
                Toast.makeText(this, "Cancion: Ghost Boy\nArtista: Lil Peep\nAlbum: Everybody's Everything", Toast.LENGTH_LONG).show();
            }else if(posicion==2){
                Toast.makeText(this, "Cancion: ...And To Those I Love, Thanks For Sticking Around\nArtista: $uicideBoy$\nAlbum: Stop Staring At the Shadows", Toast.LENGTH_LONG).show();
            }else if(posicion==3){
                Toast.makeText(this, "Cancion: SAD!\nArtista: XXXTENTACION\nAlbum: ?", Toast.LENGTH_LONG).show();
            }else if(posicion==4){
                Toast.makeText(this, "Cancion: Void\nArtista: Pouya\nAlbum: FIVE FIVE", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
    public void Anterior(View view){
        if(posicion>=1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0]=MediaPlayer.create(this, R.raw.t1gm);
                vectormp[1]=MediaPlayer.create(this, R.raw.t2lp);
                vectormp[2]=MediaPlayer.create(this, R.raw.t3sb);
                vectormp[3]=MediaPlayer.create(this, R.raw.t4xt);
                vectormp[4]=MediaPlayer.create(this, R.raw.t5p);

                posicion--;

                if(posicion==0){
                    iv.setImageResource(R.drawable.it1gm);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.it2lp);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.it3sb);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.it4xt);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.it5p);
                }

                vectormp[posicion].start();
            }else{
                posicion--;
                if(posicion==0){
                    iv.setImageResource(R.drawable.it1gm);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.it2lp);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.it3sb);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.it4xt);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.it5p);
                }
            }
            if(posicion==0){
                Toast.makeText(this, "Cancion: Squeeze\nArtista: Ghostemane\nAlbum: Hexada", Toast.LENGTH_LONG).show();
            }else if(posicion==1){
                Toast.makeText(this, "Cancion: Ghost Boy\nArtista: Lil Peep\nAlbum: Everybody's Everything", Toast.LENGTH_LONG).show();
            }else if(posicion==2){
                Toast.makeText(this, "Cancion: ...And To Those I Love, Thanks For Sticking Around\nArtista: $uicideBoy$\nAlbum: Stop Staring At the Shadows", Toast.LENGTH_LONG).show();
            }else if(posicion==3){
                Toast.makeText(this, "Cancion: SAD!\nArtista: XXXTENTACION\nAlbum: ?", Toast.LENGTH_LONG).show();
            }else if(posicion==4){
                Toast.makeText(this, "Cancion: Void\nArtista: Pouya\nAlbum: FIVE FIVE", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
}