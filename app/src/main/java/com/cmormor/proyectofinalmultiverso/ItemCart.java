package com.cmormor.proyectofinalmultiverso;

public class ItemCart {
    private String titulo;
    private double precio;

    public ItemCart(String titulo, double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }
}
