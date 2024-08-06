package com.example.roleta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button girar;
    private ImageView imagemRoleta;
    private Random random;
    private int ultimaPosicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        girar = findViewById(R.id.girar);
        imagemRoleta = findViewById(R.id.imagemRoleta);
        random = new Random();
    }

    public void girar(View v)
    {
        int novaPosicao = random.nextInt(1800);
        float eixoX = imagemRoleta.getWidth()/2;
        float eixoY = imagemRoleta.getHeight()/2;

        Animation giro = new RotateAnimation(ultimaPosicao, novaPosicao, eixoX, eixoY);
        giro.setDuration(1000);
        giro.setFillAfter(true);

        ultimaPosicao = novaPosicao;
        imagemRoleta.startAnimation(giro);
    }
}