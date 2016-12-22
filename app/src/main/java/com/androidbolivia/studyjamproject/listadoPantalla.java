package com.androidbolivia.studyjamproject;

import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;

/**
 * Created by JORGE on 18/12/2016.
 */

public class listadoPantalla extends FullscreenActivity{

    private ListView lvLista;
    private ArrayAdapter<String> adaptador;
    private String [] datos = new String [500];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_layout);
        String path = Environment.getExternalStorageDirectory().getPath()+"/Music";
        String files;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                datos[i] = listOfFiles[i].getName().toString();
                /*if (files.endsWith(".mp3") || files.endsWith(".MP3")) {
                    Toast.makeText(getApplicationContext(), files, Toast.LENGTH_LONG).show();
                }*/
            }
        }
        lvLista = (ListView) findViewById(R.id.lvLista);
        adaptador = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1 , datos);
        lvLista.setAdapter(adaptador);
    }
}
