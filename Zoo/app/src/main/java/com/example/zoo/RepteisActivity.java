package com.example.zoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RepteisActivity extends AppCompatActivity {

    ImageButton btCoral, btJacare, btIguana;

    //Widgets do layout do perfil do animal
    public MediaPlayer audio;
    TextView txNomePop, txNomeCient, txDescr;
    ImageView imAnimalPerfil;
    Button btSom, btVoltarInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repteis);

        btCoral = (ImageButton)findViewById(R.id.imgbtRepteisCoral);
        btJacare = (ImageButton)findViewById(R.id.imgbtRepteisJacare);
        btIguana = (ImageButton)findViewById(R.id.imgbtRepteisIguana);

        btCoral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layout_perfil);
                carregaWidgetsPerfil();
                carregaCoral();
            }
        });
        btJacare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layout_perfil);
                carregaWidgetsPerfil();
                carregaJacare();
            }
        });
        btIguana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layout_perfil);
                carregaWidgetsPerfil();
                carregaIguana();
            }
        });
    }

    public void carregaWidgetsPerfil(){
        txNomePop = (TextView) findViewById(R.id.txtNomePopular);
        txNomeCient =  (TextView) findViewById(R.id.txtNomeCientifico);
        txDescr = (TextView) findViewById(R.id.txtDescricao);
        imAnimalPerfil = (ImageView) findViewById(R.id.imgPerfil);

        btSom = (Button) findViewById(R.id.btnSom);
        btVoltarInicio=(Button) findViewById(R.id.btnVoltarInicio);

        btVoltarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlayer();
                Intent voltar = new Intent(RepteisActivity.this, MainActivity.class);
                finish(); //encerra a activity atual
                startActivity(voltar);
            }
        });

    }

    public void carregaCoral(){
        txNomePop.setText("CORAL VERDADEIRA");
        txNomeCient.setText("Micrurus frontalis");
        txDescr.setText("Conhecidas por sua linda coloração e seu veneno mortal, a cobra coral é um animais que vive em florestas com mata densa, " +
                "vivendo em várias partes do Brasil como no Nordeste e também em áreas da Argentina e do Paraguai.\n" +
                "\nCuriosidade: outra espécie de cobra (a coral falsa), se aproveita da coloração semelhante para afastar predadores");
        imAnimalPerfil.setImageResource(R.drawable.coralperfil);
        btSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RepteisActivity.this, "Este animal não produz som! :(", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void carregaJacare(){
        txNomePop.setText("JACARÉ-DO-PAPO-AMARELO");
        txNomeCient.setText("Caiman crocodilus");
        txDescr.setText("São répteis de água doce que podem medir entre 2 a 3 metros, tendo geralmente uma cor verde bem escura.\n" +
                "Vivem no Brasil principalmente nas regiões sul, sudeste e nordeste, com pequenas ocorrências no centro oeste, vivendo geralmente em pequenos rios, lagos, brejos e mangues.\n\n" +
                "São carnívoros vorazes podendo comer uma grande variedade de animais como peixes, anfíbios e mamíferos.");
        imAnimalPerfil.setImageResource(R.drawable.jacareperfil);

        btSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (audio == null){
                    audio = MediaPlayer.create(RepteisActivity.this, R.raw.somjacare);
                    audio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            stopPlayer();
                        }
                    });
                }
                audio.start();
            }
        });
    }
    public void carregaIguana(){
        txNomePop.setText("IGUANA");
        txNomeCient.setText("Iguana iguana");
        txDescr.setText("Um tipo de lagarto que, dependendo da espécie, chega à 2 metros." +
                "Vivem em regiões de campo e mata da América do sul e Central, tendo hábitos arborícolas e vivem em colônias pequenas.\n" +
                "São herbivoros e sua dieta é composta quase exclusivamente de folhas.\n" +
                "\nCuriosidade: Têm uma cauda bem longa, que utilizam como chicote para se defender.");
        imAnimalPerfil.setImageResource(R.drawable.iguanaperfil);

        btSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RepteisActivity.this, "Este animal não produz som! :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void stopPlayer() {
        if (audio != null) {
            audio.release();
            audio = null;
        }
    }
}