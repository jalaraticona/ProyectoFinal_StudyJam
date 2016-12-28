package com.androidbolivia.studyjamproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by JORGE on 18/12/2016.
 */

public class segundaPantalla extends FullscreenActivity{

    private Button btnListado, btnPlay, btnStop, btnPreview, btnNext, btnAleatorio;
    private int sw = 0, ind = 0;
    private MediaPlayer mp;
    private ArrayList<String> musicas = new ArrayList<String>();
    private TextView nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_activity);
        btnListado = (Button) findViewById(R.id.btnListado);
        btnPlay = (Button) findViewById(R.id.play);
        btnStop = (Button) findViewById(R.id.stop);
        btnAleatorio = (Button) findViewById(R.id.aleatorio);
        btnNext = (Button) findViewById(R.id.siguiente);
        btnPreview = (Button) findViewById(R.id.anterior);
        nombre = (TextView) findViewById(R.id.tvNombre);
        String path = Environment.getExternalStorageDirectory().getPath()+"/Music";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                musicas.add(listOfFiles[i].getName());
                /*if (files.endsWith(".mp3") || files.endsWith(".MP3")) {
                    Toast.makeText(getApplicationContext(), files, Toast.LENGTH_LONG).show();
                }*/
            }
        }
        btnListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int RC = 100;
                Intent intent = new Intent(getApplicationContext(), listadoPantalla.class);
                startActivityForResult(intent, RC);
            }

        });
        String a = "/Music/" + musicas.get(ind);
        Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
        mp = MediaPlayer.create(getApplicationContext(), datos);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw == 0) {
                    mp.start();
                    sw = 1;
                    btnStop.setEnabled(true);
                    nombre.setText(musicas.get(ind));
                }
                else{
                    mp.pause();
                    btnStop.setEnabled(false);
                    sw = 0;
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()){
                    if(ind < musicas.size() - 1){
                        mp.stop();
                        mp.release();
                        ind++;
                        String a = "/Music/" + musicas.get(ind);
                        Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
                        mp = MediaPlayer.create(getApplicationContext(), datos);
                        mp.start();
                        nombre.setText(musicas.get(ind));
                    }
                    else{
                        mp.stop();
                        mp.release();
                        ind = 0;
                        String a = "/Music/" + musicas.get(ind);
                        Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
                        mp = MediaPlayer.create(getApplicationContext(), datos);
                        mp.start();
                        nombre.setText(musicas.get(ind));
                    }
                }
                else{
                    if(ind < musicas.size() - 1){
                        ind++;
                        String a = "/Music/" + musicas.get(ind);
                        Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
                        mp = MediaPlayer.create(getApplicationContext(), datos);
                        nombre.setText(musicas.get(ind));
                    }
                    else{
                        mp.release();
                        ind = 0;
                        String a = "/Music/" + musicas.get(ind);
                        Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
                        mp = MediaPlayer.create(getApplicationContext(), datos);
                        nombre.setText(musicas.get(ind));
                    }
                }
            }
        });
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()){
                    if(ind > 0){
                        mp.stop();
                        mp.release();
                        ind--;
                        String a = "/Music/" + musicas.get(ind);
                        Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
                        mp = MediaPlayer.create(getApplicationContext(), datos);
                        mp.start();
                        nombre.setText(musicas.get(ind));
                    }
                    else{
                        mp.stop();
                        mp.release();
                        ind = musicas.size() - 1;
                        String a = "/Music/" + musicas.get(ind);
                        Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
                        mp = MediaPlayer.create(getApplicationContext(), datos);
                        mp.start();
                        nombre.setText(musicas.get(ind));
                    }
                }
                else{
                    if(ind >= 1){
                        mp.release();
                        ind--;
                        String a = "/Music/" + musicas.get(ind);
                        Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
                        mp = MediaPlayer.create(getApplicationContext(), datos);
                        nombre.setText(musicas.get(ind));
                    }
                    else{
                        mp.release();
                        ind = musicas.size() - 1;
                        String a = "/Music/" + musicas.get(ind);
                        Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
                        mp = MediaPlayer.create(getApplicationContext(), datos);
                        nombre.setText(musicas.get(ind));
                    }
                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()){
                    mp.stop();
                    mp.release();
                    String a = "/Music/" + musicas.get(ind);
                    Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
                    mp = MediaPlayer.create(getApplicationContext(), datos);
                    sw = 0;
                }
                else{
                    mp.release();
                    String a = "/Music/" + musicas.get(ind);
                    Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
                    mp = MediaPlayer.create(getApplicationContext(), datos);
                    sw = 0;
                }
            }
        });
        nombre.setText(musicas.get(ind)+"");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(getApplicationContext(), requestCode+"", Toast.LENGTH_LONG).show();
        if (requestCode == 100){
            String resultado = data.getStringExtra("pos");
            Toast.makeText(getApplicationContext(), requestCode+"", Toast.LENGTH_LONG).show();
            if(mp.isPlaying()){
                mp.stop();
                String a = "/Music/" + musicas.get(Integer.parseInt(resultado));
                Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
                mp.start();
                nombre.setText(a);
            }
            else{

                String a = "/Music/" + musicas.get(Integer.parseInt(resultado));
                Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
                mp.start();
                nombre.setText(a);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
