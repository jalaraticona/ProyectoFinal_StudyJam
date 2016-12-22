package com.androidbolivia.studyjamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by JORGE on 18/12/2016.
 */

public class segundaPantalla extends FullscreenActivity{

    private Button btnListado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_activity);
        btnListado = (Button) findViewById(R.id.btnListado);
        btnListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rcod = 0;
                Intent intent = new Intent(getApplicationContext(), listadoPantalla.class);
                startActivityForResult(intent, rcod);
            }
        });
    }
}
