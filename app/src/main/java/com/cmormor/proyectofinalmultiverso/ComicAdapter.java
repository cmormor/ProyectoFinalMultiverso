package com.cmormor.proyectofinalmultiverso;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> {

    private List<Comic> listaComics;
    private Context contexto;

    public ComicAdapter(Context contexto, List<Comic> listaComics) {
        this.contexto = contexto;
        this.listaComics = listaComics;
    }

    @NonNull
    @Override
    public ComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comic, parent, false);
        return new ComicViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicViewHolder holder, int position) {
        Comic comic = listaComics.get(position);
        holder.imagen.setImageResource(comic.getImagenResId());
        holder.titulo.setText(comic.getTitulo());
        holder.precio.setText(String.format("$%.2f", comic.getPrecio()));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(contexto, Details.class);
            intent.putExtra("titulo", comic.getTitulo());
            intent.putExtra("imagenResId", comic.getImagenResId());
            intent.putExtra("descripcion", comic.getDescripcion());
            intent.putExtra("precio", comic.getPrecio());
            contexto.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listaComics.size();
    }

    public static class ComicViewHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView titulo, precio;

        public ComicViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.comicImagen);
            titulo = itemView.findViewById(R.id.comicTitulo);
            precio = itemView.findViewById(R.id.comicPrecio);
        }
    }
}