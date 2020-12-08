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

public class MamiferosActivity extends AppCompatActivity {

    ImageButton btMico, btElefante, btGuara;

    //Widgets do layout do perfil do animal
    public MediaPlayer audio;
    TextView txNomePop, txNomeCient, txDescr;
    ImageView imAnimalPerfil;
    Button btSom, btVoltarInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mamiferos);

        btMico = (ImageButton) findViewById(R.id.imgbtMamiferosMico);
        btElefante = (ImageButton)findViewById(R.id.imgbtMamiferosElefante);
        btGuara = (ImageButton)findViewById(R.id.imgbtMamiferosGuara);

        btMico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layout_perfil);
                carregaWidgetsPerfil();
                carregaMico();
            }
        });
        btElefante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layout_perfil);
                carregaWidgetsPerfil();
                carregaElefante();
            }
        });
        btGuara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layout_perfil);
                carregaWidgetsPerfil();
                carregaGuara();
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
                Intent voltar = new Intent(MamiferosActivity.this, MainActivity.class);
                finish(); //encerra a activity atual
                startActivity(voltar);
            }
        });
    }

    public void carregaMico(){
        txNomePop.setText("MICO-LEÃO-DOURADO");
        txNomeCient.setText("Leontopithecus rosalia");
        txDescr.setText("De origem brasileira, mais específico na Mata Atlântica do RJ, esse mamífero vive em bando e buscam abrigo em troncos de árvores." +
                "\nUma espécie de macaco de pequeno porte, são animais onivoros, comendo desde frutas e ovos a pequenos vertebrados\n" +
                "Devido à sua aparência muitas vezes é alvo do contrabando.");
        imAnimalPerfil.setImageResource(R.drawable.micoperfil);

        btSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (audio == null){
                    audio = MediaPlayer.create(MamiferosActivity.this, R.raw.sommico);
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

    public void carregaElefante(){
        txNomePop.setText("ELEFANTE-INDIANO");
        txNomeCient.setText("Elephas maximus");
        txDescr.setText("Grandes animais com habitat natural na África e na Ásia, são animais herbívoros que vivem em bando, com um comportamento de proteger os mais novos da manada. Atacam de surpresa caso se sintam ameaçados.\n" +
                "Devido a sua grande força e porte já foi usado por alguns povos em guerras ou mesmo como meio de transporte. Se alimentam de campim e frutas.\n" +
                "Durante muito tempo foram caçados devido às suas presas de marfim.");
        imAnimalPerfil.setImageResource(R.drawable.elefperfil);

        btSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (audio == null){
                    audio = MediaPlayer.create(MamiferosActivity.this, R.raw.somelefante);
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

    public void carregaGuara(){
        txNomePop.setText("LOBO-GUARÁ");
        txNomeCient.setText("Chrysocyon brachyurus");
        txDescr.setText("Apesar do nome ser 'lobo'', ele é o maior cão selvagem da América do Sul. Seu habitat vai desde campos abertos a cerrados." +
                "Seu nome vem do termo tupi awa'rá que significa 'vermelho'." +
                "do Brasil, passando por Bolívia, Argentina e outros países. Se alimenta de outros mamíferos, pássaros, répteis, insetos e frutas.");
        imAnimalPerfil.setImageResource(R.drawable.guaraperfil);

        btSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (audio == null){
                    audio = MediaPlayer.create(MamiferosActivity.this, R.raw.somguara);
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

    private void stopPlayer() {
        if (audio != null) {
            audio.release();
            audio = null;
        }
    }
}