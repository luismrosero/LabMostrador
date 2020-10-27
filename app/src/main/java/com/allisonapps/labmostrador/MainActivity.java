package com.allisonapps.labmostrador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private DiscreteScrollView dsvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dsvMain = findViewById(R.id.dsv_main);

        // crear un ArrayList de Strig que contendran las url
        // de las imagenes que se mostraran

        // creamos una array list vacio
        ArrayList<String> imanges = new ArrayList<>();
        // llenamos uno a uno los espacios
        imanges.add("https://universoabiertoblog.files.wordpress.com/2019/09/700x420_770x420-museo-reina-sofia-dia-internacional-de-los-museos.jpg");
        imanges.add("https://s1.eestatic.com/2020/05/18/cultura/arte/Museos-Arte-Obras_de_arte-Coronavirus-Arte_490961597_152145101_1706x960.jpg");

        // !!!aumenta 3 imagenes mas¡¡¡¡
        

        // creamo el adaptador
        AdapMain adaptador = new AdapMain(this, imanges);

        // damos orientacion al nuevo view
        dsvMain.setOrientation(DSVOrientation.HORIZONTAL);
        // tiempo de trancicion
        dsvMain.setItemTransitionTimeMillis(500);
        // damos la transformacion
        dsvMain.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.5f)
                // .setMaxScale(0.5f) lo hace de grande a pequeño
                .build());
        // ?
        dsvMain.setClampTransformProgressAfter(3);

        // seteamos el adaptador
        dsvMain.setAdapter(adaptador);



    }
}
