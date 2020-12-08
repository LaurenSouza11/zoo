package com.example.zoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends SwipeAc {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onSwipeRight() {  //Arrasta pra esquerda - Tela Mamíferos
        Intent telaMami = new Intent(MainActivity.this, MamiferosActivity.class);
        finish(); //encerra a activity atual
        startActivity(telaMami);
    }

    @Override
    protected void onSwipeLeft() {  //Arrasta pra direita - Tela Répteis
        Intent telaRepteis = new Intent(MainActivity.this, RepteisActivity.class);
        finish(); //encerra a activity atual
        startActivity(telaRepteis);
    }

    @Override
    protected void onSwipeUp() {    //Arrasta pra cima - Tela Aves
        Intent telaAves = new Intent(MainActivity.this, AvesActivity.class);
        finish(); //encerra a activity atual
        startActivity(telaAves);
    }

    @Override
    protected void onSwipeDown() {

    }
}