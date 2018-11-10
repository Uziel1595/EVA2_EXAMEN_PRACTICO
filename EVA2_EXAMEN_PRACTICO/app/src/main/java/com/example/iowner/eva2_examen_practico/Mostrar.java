package com.example.iowner.eva2_examen_practico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Mostrar extends AppCompatActivity {
    ArrayList<Restaurantes> rRestaurantes;
    Intent inPrincipal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        inPrincipal = getIntent();
        //TOMAMOS LA LISTA DEL INTENTO

        //DE ESTA LISTA TOMAMOS LOS DATOS PARA LLENAR LA LISTA PERSONALIZADO
        rRestaurantes = (ArrayList<Restaurantes>) inPrincipal.getSerializableExtra("arrayList");

    }
}
