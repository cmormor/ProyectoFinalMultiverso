package com.cmormor.proyectofinalmultiverso;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static List<ItemCart> items = new ArrayList<>();

    public static void agregarAlCarrito(ItemCart item) {
        items.add(item);
    }

    public static List<ItemCart> obtenerCarrito() {
        return items;
    }

    public static double calcularTotal() {
        double total = 0.0;
        for (ItemCart item : items) {
            total += item.getPrecio();
        }
        return total;
    }

    public static void vaciarCarrito() {
        items.clear();
    }

    public static void eliminarItem(ItemCart item) {
        items.remove(item);
    }

}
