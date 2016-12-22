package com.androidbolivia.studyjamproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

/**
 * Created by JORGE on 18/12/2016.
 */

public class segundaPantalla extends FullscreenActivity{

    private Button btnListado;
    private Button btnPlay;
    private int sw = 0;
    private MediaPlayer mp;
    private String datos[] = new String[500];
    private TextView nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_activity);
        btnListado = (Button) findViewById(R.id.btnListado);
        btnPlay = (Button) findViewById(R.id.play);
        nombre = (TextView) findViewById(R.id.tvNombre);
        String path = Environment.getExternalStorageDirectory().getPath()+"/Music";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                datos[i] = listOfFiles[i].getName();
                /*if (files.endsWith(".mp3") || files.endsWith(".MP3")) {
                    Toast.makeText(getApplicationContext(), files, Toast.LENGTH_LONG).show();
                }*/
            }
        }
        btnListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rcod = 0;
                Intent intent = new Intent(getApplicationContext(), listadoPantalla.class);
                startActivityForResult(intent, rcod);
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw == 0) {
                    String a = "/Music/" + datos[30];
                    Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + a);
                    mp = MediaPlayer.create(getApplicationContext(), datos);
                    mp.start();
                    sw = 1;
                    nombre.setText(a);
                }
                else{
                    mp.pause();
                    sw = 0;
                }
            }
        });
    }

}
