package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button rock,salsa,clasica,trap,metal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rock=findViewById(R.id.btnRock);
        salsa=findViewById(R.id.btnSalsa);
        clasica=findViewById(R.id.btnClasica);
        metal=findViewById(R.id.btnMetal);
        trap=findViewById(R.id.btnTrap);
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LlamarRock();
            }
        });
        salsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LlamarSalsa();
            }
        });
        clasica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LlamarClasica();
            }
        });
        metal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LlamarMetal();
            }
        });
        trap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LlamarTrap();
            }
        });
    }

    private void LlamarRock() {
        Intent intent=new Intent(MainActivity.this,Rock.class);
        startActivity(intent);
    }
    private void LlamarClasica() {
        Intent intent=new Intent(MainActivity.this,Clasica.class);
        startActivity(intent);
    }
    private void LlamarSalsa() {
        Intent intent=new Intent(MainActivity.this,Salsa.class);
        startActivity(intent);
    }
    private void LlamarMetal() {
        Intent intent=new Intent(MainActivity.this,Metal.class);
        startActivity(intent);
    }
    private void LlamarTrap() {
        Intent intent=new Intent(MainActivity.this,Trap.class);
        startActivity(intent);
    }

    public void Salir(View view) {
        finish();
    }
}