package com.example.iowner.eva2_examen_practico;

import java.io.Serializable;

/**
 * Created by iOwner on 09/11/2018.
 */

public class Restaurantes implements Serializable {
    private String sNombre;
    private String sDescripcion;
    private String sDireccionTelefono;
    private int iImagen;
    private int iOpinion;

    public Restaurantes(String nom, String des, String dir, int img, int opinion){
        setNombre(nom);
        setDescripcion(des);
        setDireccionTelefono(dir);
        setImagen(img);
        setOpinion(opinion);
    }

    public String getNombre() {
        return sNombre;
    }

    public void setNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getDescripcion() {
        return sDescripcion;
    }

    public void setDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    public String getDireccionTelefono() {
        return sDireccionTelefono;
    }

    public void setDireccionTelefono(String sDireccionTelefono) {
        this.sDireccionTelefono = sDireccionTelefono;
    }

    public int getImagen() {
        return iImagen;
    }

    public void setImagen(int iImagen) {
        this.iImagen = iImagen;
    }

    public int getOpinion() {
        return iOpinion;
    }

    public void setOpinion(int iOpinion) {
        this.iOpinion = iOpinion;
    }
}
