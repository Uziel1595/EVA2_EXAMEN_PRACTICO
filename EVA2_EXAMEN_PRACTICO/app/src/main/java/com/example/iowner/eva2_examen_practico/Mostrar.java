package com.example.iowner.eva2_examen_practico;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Mostrar extends AppCompatActivity implements ListView.OnItemClickListener {

    ArrayList<Restaurantes> rRestaurantes;
    ListView lvRestaurantes;
    Intent inPrincipal;
    Intent inMostrarInfo;
    int MOSTRAR_CODE = 420;
    Restaurantes restSeleccionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        inPrincipal = getIntent();
        //TOMAMOS LA LISTA DEL INTENTO
        //DE ESTA LISTA TOMAMOS LOS DATOS PARA LLENAR LA LISTA PERSONALIZADO
        rRestaurantes = (ArrayList<Restaurantes>) inPrincipal.getSerializableExtra("restaurantes");
        Log.d("lmao", Arrays.toString(rRestaurantes.toArray()));
        lvRestaurantes = findViewById(R.id.listViewRestaurantes);
        lvRestaurantes.setAdapter(new RestaurantesAdapter(this, R.layout.layout_restaurantes, rRestaurantes));
        lvRestaurantes.setOnItemClickListener(this);
        inMostrarInfo = new Intent(this, EvaluacionRestaurante.class);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        restSeleccionado = rRestaurantes.get(i);
        inMostrarInfo.putExtra("restaurante",rRestaurantes.get(i));
        startActivityForResult(inMostrarInfo, MOSTRAR_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MOSTRAR_CODE){
            if(resultCode == Activity.RESULT_OK){
                restSeleccionado.setOpinion(data.getIntExtra("rating", 0));
                lvRestaurantes.invalidateViews();
            }
        }
    }
}
