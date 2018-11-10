package com.example.iowner.eva2_examen_practico;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SeleccionImagenes extends AppCompatActivity implements ListView.OnItemClickListener{
    Intent inRespuestaCapturar;//INTENTO PARA REGRESAR DATOS
    ListView listViewImagenes;
    Integer[] iImages = {R.drawable.barrafina,R.drawable.bourkestreetbakery,
                            R.drawable.cafedeadend,R.drawable.cafeloisl,R.drawable.cafelore,
                            R.drawable.confessional,R.drawable.donostia,R.drawable.fiveleaves,
                            R.drawable.forkeerestaurant,R.drawable.grahamavenuemeats,
                            R.drawable.haighschocolate,R.drawable.homei,R.drawable.palominoespresso,
                            R.drawable.petiteoyster,R.drawable.posatelier,R.drawable.royaloak,
                            R.drawable.teakha,R.drawable.thaicafe};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_imagenes);
        //TOMAOS EL INTENTO PARA REGRESAR DATOS
        inRespuestaCapturar = getIntent();
        listViewImagenes = findViewById(R.id.listViewImagenes);//VINCULAMOS LA LISTA
        //ASIGNAMOS EL ADAPTADOR
        listViewImagenes.setAdapter(new ImagenesAdapter(this,R.layout.layout_image,iImages));
        //ASIGNAMOS EL LISTENER
        listViewImagenes.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        inRespuestaCapturar.putExtra("imagen",iImages[i]);
        setResult(Activity.RESULT_OK,inRespuestaCapturar);
        finish();
    }
}
