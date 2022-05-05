package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Salsa extends AppCompatActivity {
    ImageButton playPause, btnRepetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir=2, posicion=0;

    MediaPlayer vectormp[]=new MediaPlayer[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salsa);

        playPause=(ImageButton) findViewById(R.id.btnPlayS);
        btnRepetir=(ImageButton) findViewById(R.id.btnRepetirS);
        iv=(ImageView) findViewById(R.id.imageViewS);

        vectormp[0]=MediaPlayer.create(this, R.raw.s1gn);
        vectormp[1]=MediaPlayer.create(this, R.raw.s2vm);
        vectormp[2]=MediaPlayer.create(this, R.raw.s3fr);
        vectormp[3]=MediaPlayer.create(this, R.raw.s4ej);
        vectormp[4]=MediaPlayer.create(this, R.raw.s5dd);
    }
    public void PlayPauseS(View view) {
        if (vectormp[posicion].isPlaying()) {
            vectormp[posicion].pause();
            playPause.setBackgroundResource(R.drawable.playc);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        } else {
            vectormp[posicion].start();
            playPause.setBackgroundResource(R.drawable.playc);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
        if (posicion == 0) {
            Toast.makeText(this, "Cancion: Una Aventura\nArtista: Grupo Niche\nAlbum: Una Aventura", Toast.LENGTH_LONG).show();

        }
    }
    public void StopS(View view){
        if (vectormp[posicion]!=null){
            vectormp[posicion].stop();

            vectormp[0]=MediaPlayer.create(this, R.raw.s1gn);
            vectormp[1]=MediaPlayer.create(this, R.raw.s2vm);
            vectormp[2]=MediaPlayer.create(this, R.raw.s3fr);
            vectormp[3]=MediaPlayer.create(this, R.raw.s4ej);
            vectormp[4]=MediaPlayer.create(this, R.raw.s5dd);
            posicion=0;
            playPause.setBackgroundResource(R.drawable.play);
            iv.setImageResource(R.drawable.is1gn);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }
    public void RepetirS(View view){
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
    public void SiguienteS(View view){
        if (posicion< vectormp.length -1){
            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();
                if(posicion==0){
                    iv.setImageResource(R.drawable.is1gn);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.is2vm);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.is3fr);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.is4ej);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.is5dd);
                }
            }else {
                posicion++;
                if(posicion==0){
                    iv.setImageResource(R.drawable.is1gn);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.is2vm);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.is3fr);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.is4ej);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.is5dd);
                }
            }
            if(posicion==0){
                Toast.makeText(this, "Cancion: Una Aventura\nArtista: Grupo Niche\nAlbum: Una Aventura", Toast.LENGTH_LONG).show();
            }else if(posicion==1){
                Toast.makeText(this, "Cancion: Nuestro Amor Se Ha Vuelto Ayer\nArtista: Victor Manuelle\nAlbum: Decisión Unánime", Toast.LENGTH_LONG).show();
            }else if(posicion==2){
                Toast.makeText(this, "Cancion: Tú con Él\nArtista: Frankie Ruíz\nAlbum: Mejores Éxitos", Toast.LENGTH_LONG).show();
            }else if(posicion==3){
                Toast.makeText(this, "Cancion: Hechizo De Luna\nArtista: Edgar Joel y su Orquesta\nAlbum: En El Tope", Toast.LENGTH_LONG).show();
            }else if(posicion==4){
                Toast.makeText(this, "Cancion: Mi Cuerpo\nArtista: Dan Den\nAlbum: Joyitas Tropicales", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
    public void AnteriorS(View view){
        if(posicion>=1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0]=MediaPlayer.create(this, R.raw.s1gn);
                vectormp[1]=MediaPlayer.create(this, R.raw.s2vm);
                vectormp[2]=MediaPlayer.create(this, R.raw.s3fr);
                vectormp[3]=MediaPlayer.create(this, R.raw.s4ej);
                vectormp[4]=MediaPlayer.create(this, R.raw.s5dd);

                posicion--;

                if(posicion==0){
                    iv.setImageResource(R.drawable.is1gn);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.is2vm);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.is3fr);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.is4ej);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.is5dd);
                }

                vectormp[posicion].start();
            }else{
                posicion--;
                if(posicion==0){
                    iv.setImageResource(R.drawable.is1gn);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.is2vm);
                }else if(posicion==2){
                    iv.setImageResource(R.drawable.is3fr);
                }else if(posicion==3){
                    iv.setImageResource(R.drawable.is4ej);
                }else if(posicion==4){
                    iv.setImageResource(R.drawable.is5dd);
                }
            }
            if(posicion==0){
                Toast.makeText(this, "Cancion: Una Aventura\nArtista: Grupo Niche\nAlbum: Una Aventura", Toast.LENGTH_LONG).show();
            }else if(posicion==1){
                Toast.makeText(this, "Cancion: Nuestro Amor Se Ha Vuelto Ayer\nArtista: Victor Manuelle\nAlbum: Decisión Unánime", Toast.LENGTH_LONG).show();
            }else if(posicion==2){
                Toast.makeText(this, "Cancion: Tú con Él\nArtista: Frankie Ruíz\nAlbum: Mejores Éxitos", Toast.LENGTH_LONG).show();
            }else if(posicion==3){
                Toast.makeText(this, "Cancion: Hechizo De Luna\nArtista: Edgar Joel y su Orquesta\nAlbum: En El Tope", Toast.LENGTH_LONG).show();
            }else if(posicion==4){
                Toast.makeText(this, "Cancion: Mi Cuerpo\nArtista: Dan Den\nAlbum: Joyitas Tropicales", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
}