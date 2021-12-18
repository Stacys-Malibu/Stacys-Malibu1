package com.example.stacy.prueba1.model;
import com.google.gson.annotations.Expose;

public class Usuario {

    @Expose
    private String apellido;
    @Expose
    private String nombre;
    @Expose
    private String tipoE;
    @Expose
    private int id;

    public Usuario(int id,String apellido, String nombre, String tipoE) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.tipoE = tipoE;
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoE() {
        return tipoE;
    }

    public int getId() {
        return id;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoE(String tipoE) {
        this.tipoE = tipoE;
    }

    public void setId(int id) {
        this.id = id;
    }
}
