package com.example.iowner.eva2_examen_practico;

/**
 * Created by iOwner on 09/11/2018.
 */

public class Restaurantes {
    String sNombre,sDescripcion,sDireccionTelefono;
    int iImagen,iOpinion;

    public Restaurantes(String nom, String des, String dir, int img, int opinion){
        sNombre = nom;
        sDescripcion = des;
        sDireccionTelefono = dir;
        iImagen = img;
        iOpinion = opinion;
    }
}
