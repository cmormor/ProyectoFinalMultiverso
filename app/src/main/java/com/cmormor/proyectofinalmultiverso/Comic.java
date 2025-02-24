package com.cmormor.proyectofinalmultiverso;

public class Comic {
    private String titulo;
    private int imagenResId;
    private String descripcion;
    private double precio;

    public Comic(String titulo, int imagenResId, String descripcion, double precio) {
        this.titulo = titulo;
        this.imagenResId = imagenResId;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getTitulo() { return titulo; }
    public int getImagenResId() { return imagenResId; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
}
