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

public class AvesActivity extends AppCompatActivity {
    //Widgets das opções de animais
    ImageButton btArarajuba, btTucano, btHarpia;

    //Widgets do layout do perfil do animal
    public MediaPlayer audio;
    TextView txNomePop, txNomeCient, txDescr;
    ImageView imAnimalPerfil;
    Button btSom, btVoltarInicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aves);

        btArarajuba = (ImageButton) findViewById(R.id.imgbtAvesArarajuba);
        btTucano = (ImageButton) findViewById(R.id.imgbtAvesTucano);
        btHarpia = (ImageButton) findViewById(R.id.imgbtAvesHarpia);

        btArarajuba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layout_perfil);
                carregaWidgetsPerfil();
                carregaArarajuba();
            }
        });
        btTucano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layout_perfil);
                carregaWidgetsPerfil();
                carregaTucano();
            }
        });
        btHarpia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layout_perfil);
                carregaWidgetsPerfil();
                carregaHarpia();
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
                Intent voltar = new Intent(AvesActivity.this, MainActivity.class);
                finish(); //encerra a activity atual
                startActivity(voltar);
            }
        });
    }

    public void carregaArarajuba(){
        txNomePop.setText("ARARAJUBA");
        txNomeCient.setText("Guaruba guarouba");
        txDescr.setText("Recebe também o nome de Guaruba, que em Tupi significa pássaro amarelo e habita regiões exclusivamente brasileiras," +
                " como matas do Maranhão, Pará e Rondônia.\nSua dieta é composta por futros, brotos e sementes.");
        imAnimalPerfil.setImageResource(R.drawable.ararajubaperfil);

        btSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //audio.release();
                if (audio == null){
                    audio = MediaPlayer.create(AvesActivity.this, R.raw.somararajuba);
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

    public void carregaTucano(){
        txNomePop.setText("TUCANO TOCO");
        txNomeCient.setText("Ramphastos toco");
        txDescr.setText("Com um grande bico colorido, o tucano é uma ave exótica originária de matas e cerrados.\n" +
                "Apesar de sua dieta ser compostas principalmente por frutos, eles são animais onivoros podendo comer pequenos répteis, insetos e ovos de outras espécies!");
        imAnimalPerfil.setImageResource(R.drawable.tucanoperfil);

        btSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //audio.release();
                if (audio == null){
                    audio = MediaPlayer.create(AvesActivity.this, R.raw.somtucano);
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

    public void carregaHarpia(){
        txNomePop.setText("HARPIA ou ÁGUIA REAL");
        txNomeCient.setText("Harpia harpyja");
        txDescr.setText("Uma das maiores aves de rapina, podem caçar animais de pequeno e médio porte, como carneiros.\n" +
                "Tem o costume de atacar dando curtas e potentes investidas. As fêmeas caçam animais maiores que o macho devido a diferença de tamanho entre eles!" +
                "\nSeu habitat é composto por florestas desde o México à Argentina, e em quase todo o Brasil.");
        imAnimalPerfil.setImageResource(R.drawable.harpiaperfil);

        //audio do animal
        btSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //audio.release();
                if (audio == null){
                    audio = MediaPlayer.create(AvesActivity.this, R.raw.somharpia);
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