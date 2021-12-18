package com.example.stacy.prueba1.model;
import com.google.gson.annotations.Expose;

public class Examen {

    @Expose
    private String categoria;
    @Expose
    private String cantidad;
    @Expose
    private int id;

    public Examen(String categoria, String cantidad, int id) {
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCantidad() {
        return cantidad;
    }

    public int getId() {
        return id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }


    public void setId(int id) {
        this.id = id;
    }
}
