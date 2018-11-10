package com.example.iowner.eva2_examen_practico;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Capturar extends AppCompatActivity {
    //VARIBLES PARA GUARDAR UN OBJETO DE LA CLASE RESTAURANTE
    String sNombre,sDescripcion,sDireccionTelefono;
    int iImagen;

    Intent inImagen,inPrincipal;//INTENTO PARA LA SELECCION DE IMAGENES Y PARA REGRESAR DATOS
    final int RESPUESTA_IMAGEN = 11;//CONSTANTE PARA IDENTIFICADOR DE RESPUESTA

    EditText editTxtNombre,editTxtDescripcion,editTxtDirTel;//VARIABLES PARA LOS WIDGETS
    ImageView imgViewRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar);
        //TOMAMOS EL INTENTO
        inPrincipal = getIntent();
        //VINCULAMOS WIDGETS
        editTxtNombre = findViewById(R.id.editTxtNombre);
        editTxtDescripcion = findViewById(R.id.editTxtDescripcion);
        editTxtDirTel = findViewById(R.id.editTxtDirTel);
        imgViewRes = findViewById(R.id.imgViewRes);

        inImagen = new Intent(this,SeleccionImagenes.class);//INICIALIZAMOS LA ACTIVIDAD

    }
    //METODO PARA LA SELECION DE IMAGEN
    public void clickImagen(View v){
        startActivityForResult(inImagen,RESPUESTA_IMAGEN);
    }
    //METODO PARA EL BOTON GUARDAR
    public void clickGuardar(View v){
        //TOMAMOS LOS VALORES DE LOS EDITS
        sNombre = editTxtNombre.getText().toString();
        sDescripcion = editTxtDescripcion.getText().toString();
        sDireccionTelefono = editTxtDirTel.getText().toString();
        //PONEMOS LOS DATOS EN EXTRAS
        inPrincipal.putExtra("nombre",sNombre);
        inPrincipal.putExtra("descripcion",sDescripcion);
        inPrincipal.putExtra("direccion",sDireccionTelefono);
        inPrincipal.putExtra("imagen",iImagen);
        //MODIFICAMOS LA RESPUESTA
        setResult(Activity.RESULT_OK,inPrincipal);
        //COPNFIRMAMOS
        Toast.makeText(this, "SE GUARDO RESTAURANTE", Toast.LENGTH_SHORT).show();
        //TERMINAMOS ACTIVIDAD
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESPUESTA_IMAGEN){//IDENTIFICAMOS LA ACTIVIDAD QUE NOS MANDO UN RESULTADO
            if(resultCode == Activity.RESULT_OK){//ACCION OK
               iImagen = data.getIntExtra("imagen",0);
               imgViewRes.setImageResource(iImagen);
            }
        }
    }
}
