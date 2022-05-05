package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Clasica extends AppCompatActivity {
    MediaPlayer mp;
    ImageView iv;
    ImageButton playPause, btnRepetir;
    int repetir=2, posicion=0;

    MediaPlayer vectormp[]=new MediaPlayer[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasica);
        playPause=(ImageButton) findViewById(R.id.btnPlayC);
        btnRepetir=(ImageButton) findViewById(R.id.btnRepetirC);
        iv=(ImageView) findViewById(R.id.imageViewC);

        vectormp[0]=MediaPlayer.create(this, R.raw.c1ch);
        vectormp[1]=MediaPlayer.create(this, R.raw.c2p);
        vectormp[2]=MediaPlayer.create(this, R.raw.c3chvsk);
        vectormp[3]=MediaPlayer.create(this, R.raw.c4m);
        vectormp[4]=MediaPlayer.create(this, R.raw.c5jsb);
    }
    public void PlayPauseC(View view){
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
            Toast.makeText(this, "Cancion: Nocturne op.9 No.2\nArtista: Frédéric Chopin\nAlbum: hmGold", Toast.LENGTH_LONG).show();
        }
    }
    public void StopC(View view){
        if (vectormp[posicion]!=null){
            vectormp[posicion].stop();

            vectormp[0]=MediaPlayer.create(this, R.raw.c1ch);
            vectormp[1]=MediaPlayer.create(this, R.raw.c2p);
            vectormp[2]=MediaPlayer.create(this, R.raw.c3chvsk);
            vectormp[3]=MediaPlayer.create(this, R.raw.c4m);
            vectormp[4]=MediaPlayer.create(this, R.raw.c5jsb);
            posicion=0;
            playPause.setBackgroundResource(R.drawable.play);
            iv.setImageResource(R.drawable.ic1ch);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }
    public void RepetirC(View view){
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
    public void SiguienteC(View view){
        if (posicion< vectormp.length -1){
            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();
                if(posicion==0){
                    iv.setImageResource(R.drawable.ic1ch);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.ic2p);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.ic3chvsk);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.ic4m);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.ic5jsb);
                }
            }else {
                posicion++;
                if(posicion==0){
                    iv.setImageResource(R.drawable.ic1ch);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.ic2p);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.ic3chvsk);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.ic4m);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.ic5jsb);
                }
            }
            if(posicion==0){
                Toast.makeText(this, "Cancion: Nocturne op.9 No.2\nArtista: Frédéric Chopin\nAlbum: hmGold", Toast.LENGTH_LONG).show();
            }else if(posicion==1){
                Toast.makeText(this, "Cancion: Caprice 24\nArtista: Niccoló Paganini\nAlbum: Ruggiero Ricci", Toast.LENGTH_LONG).show();
            }else if(posicion==2){
                Toast.makeText(this, "Cancion: El Lago de los Cisnes\nArtista: Tchaikovsky\nAlbum: The Very Best Of Tchaikovsky ", Toast.LENGTH_LONG).show();
            }else if(posicion==3){
                Toast.makeText(this, "Cancion: Lacrimosa\nArtista: Mozart\nAlbum: Essential Classic", Toast.LENGTH_LONG).show();
            }else if(posicion==4){
                Toast.makeText(this, "Cancion: Air\nArtista: Johann Sebastian Bach\nAlbum: The Essentials", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
    public void AnteriorC(View view){
        if(posicion>=1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0]=MediaPlayer.create(this, R.raw.c1ch);
                vectormp[1]=MediaPlayer.create(this, R.raw.c2p);
                vectormp[2]=MediaPlayer.create(this, R.raw.c3chvsk);
                vectormp[3]=MediaPlayer.create(this, R.raw.c4m);
                vectormp[4]=MediaPlayer.create(this, R.raw.c5jsb);

                posicion--;

                if(posicion==0){
                    iv.setImageResource(R.drawable.ic1ch);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.ic2p);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.ic3chvsk);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.ic4m);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.ic5jsb);
                }

                vectormp[posicion].start();
            }else{
                posicion--;
                if(posicion==0){
                    iv.setImageResource(R.drawable.ic1ch);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.ic2p);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.ic3chvsk);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.ic4m);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.ic5jsb);
                }
            }
            if(posicion==0){
                Toast.makeText(this, "Cancion: Nocturne op.9 No.2\nArtista: Frédéric Chopin\nAlbum: hmGold", Toast.LENGTH_LONG).show();
            }else if(posicion==1){
                Toast.makeText(this, "Cancion: Caprice 24\nArtista: Niccoló Paganini\nAlbum: Ruggiero Ricci", Toast.LENGTH_LONG).show();
            }else if(posicion==2){
                Toast.makeText(this, "Cancion: El Lago de los Cisnes\nArtista: Tchaikovsky\nAlbum: The Very Best Of Tchaikovsky ", Toast.LENGTH_LONG).show();
            }else if(posicion==3){
                Toast.makeText(this, "Cancion: Lacrimosa\nArtista: Mozart\nAlbum: Essential Classic", Toast.LENGTH_LONG).show();
            }else if(posicion==4){
                Toast.makeText(this, "Cancion: Air\nArtista: Johann Sebastian Bach\nAlbum: The Essentials", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
}