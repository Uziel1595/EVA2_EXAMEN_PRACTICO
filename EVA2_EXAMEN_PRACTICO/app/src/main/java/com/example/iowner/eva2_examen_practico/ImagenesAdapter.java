package com.example.iowner.eva2_examen_practico;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by iOwner on 09/11/2018.
 */

public class ImagenesAdapter extends ArrayAdapter<Integer> {
    Context cContexto;
    int iLayoaut;
    Integer[] iImages;

    public ImagenesAdapter(@NonNull Context context, int resource, @NonNull Integer[] objects) {
        super(context, resource, objects);
        cContexto = context;
        iLayoaut = resource;
        iImages = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgVw;
        View vFila = convertView;
        if(vFila == null){//no existe fila creeamos
            //PARA CREAR LA VISTA USAMOS LAYOUTINFLATER
            LayoutInflater liVista = ((Activity)cContexto).getLayoutInflater();
            vFila = liVista.inflate(iLayoaut,parent,false);

        }
        //VINCULAR WIDGETS
        imgVw = vFila.findViewById(R.id.imgViewImg);

        Integer cActual = iImages[position];
        imgVw.setImageResource(cActual.intValue());
        return vFila;

    }
}
