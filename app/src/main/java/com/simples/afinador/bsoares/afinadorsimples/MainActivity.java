package com.simples.afinador.bsoares.afinadorsimples;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import model.Jogador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static int REQUEST_ADD = 1;
    private static boolean STATUS_REPEAT = false;
    private MediaPlayer mediaPlayer;
    private Switch btnRepetir;
    ArrayAdapter adapter;
    ArrayList<String> rankingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rankingList = new ArrayList<>();
    }

    public void repetirSom(View view) {
        btnRepetir = findViewById(R.id.swtRepeatSound);
        STATUS_REPEAT = btnRepetir.isChecked();
        if (mediaPlayer != null && !STATUS_REPEAT) {
            if (mediaPlayer.isLooping()) {
                mediaPlayer.release();
            }
        }
    }

    public void testarOuvidoAbsButton(View view) {
        Intent intent = new Intent(this, TesteOuvido.class);
        startActivityForResult(intent, REQUEST_ADD);
    }

    public void onClickStringButton(View view) {

        switch (view.getId()) {
            case R.id.MiAgudoButton :
                mediaPlayer = MediaPlayer.create(this, R.raw.firststring);
                break;
            case R.id.SiButton :
                mediaPlayer = MediaPlayer.create(this, R.raw.secondstring);
                break;
            case R.id._btnSolSound :
                mediaPlayer = MediaPlayer.create(this, R.raw.thirdstring);
                break;
            case R.id._btnReSound :
                mediaPlayer = MediaPlayer.create(this, R.raw.fourthstring);
                break;
            case R.id._btnLaSound :
                mediaPlayer = MediaPlayer.create(this, R.raw.fithstring);
                break;
            case R.id._btnMiSound :
                mediaPlayer = MediaPlayer.create(this, R.raw.sixthstrin);
                break;
        }
        if (STATUS_REPEAT) {
            mediaPlayer.setLooping(true);
        }

        mediaPlayer.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Jogador jogador = new Jogador();

        if (resultCode == REQUEST_ADD) {
            if (data.getExtras() != null) {
                String nome = data.getExtras().get("nome").toString();
                int pontos = (int) data.getExtras().get("pontos");

                jogador.setNome(nome);
                jogador.setṔontos(pontos);
            }
            rankingList.add(jogador.getNome() + " - " + jogador.getṔontos());
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, rankingList);

            ListView listView = findViewById(R.id._dynamicList);
            listView.setAdapter(adapter);
            listView.setSelection(android.R.color.holo_blue_dark);

        }

    }
}
