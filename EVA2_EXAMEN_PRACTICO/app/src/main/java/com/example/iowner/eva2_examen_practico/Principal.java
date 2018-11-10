package com.example.iowner.eva2_examen_practico;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {
    ArrayList<Restaurantes> rRestaurantes = new ArrayList<Restaurantes>();

    final int RESULTADO_CAPTURAR = 10;//CONSTANTE PARA LA RESPUESTA DE LA ACTIVIDAD CAPTURAR
    Intent inCapturar,inMostrar;//INTENTOS PARA LAS ACTIVIDADES CAPTURAR Y MOSTRAR
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //INICIALIZAMOS LAS DOS ACTIVIDADES
        inCapturar = new Intent(this,Capturar.class);
        inMostrar = new Intent(this,Mostrar.class);
    }
    //METODO PARA EL BOTON CAPTURAR
    public void clickCapturar(View v){
        startActivityForResult(inCapturar,RESULTADO_CAPTURAR);
    }
    //METODO PARA EL BOTON MOSTRAR
    public void clickMostrar(View v){
        inMostrar.putExtra("arrayList",rRestaurantes);//MANDAMOS LA LISTA A MOSTRAR
        startActivity(inMostrar);
    }
    //METODO PARA EL BOTON SALIR
    public void clickSalir(View v){
        finish();
    }

    //METODO PARA TOMAR EL RESULTADO DE LAS ACTIVIDADES STARTEADAS
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULTADO_CAPTURAR){//IDENTIFICAMOS LA ACTIVIDAD QUE NOS MANDO UN RESULTADO
            if(resultCode == Activity.RESULT_OK){//ACCION OK
                Restaurantes rRestaurante = new Restaurantes(data.getStringExtra("nombre"),
                        data.getStringExtra("descripcion"),data.getStringExtra("direccion"),
                        data.getIntExtra("imagen",0),3);
                rRestaurantes.add(rRestaurante);
            }
        }
    }
}
