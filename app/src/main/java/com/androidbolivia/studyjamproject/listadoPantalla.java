package com.androidbolivia.studyjamproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by JORGE on 18/12/2016.
 */

public class listadoPantalla extends FullscreenActivity{

    private ListView lvLista;
    private ArrayAdapter<String> adaptador;
    private String [] datos = {"hola","todos","putos","amos","mejores","iron","maiden","la mejor","banda","del NWBAM","JEJEJEJE"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_layout);
        lvLista = (ListView) findViewById(R.id.lvLista);
        adaptador = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1 , datos);
        lvLista.setAdapter(adaptador);
    }
}
