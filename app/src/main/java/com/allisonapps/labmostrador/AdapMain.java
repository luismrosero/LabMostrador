package com.allisonapps.labmostrador;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapMain extends RecyclerView.Adapter<AdapMain.ImgViewHolder> {

    private Context context;
    private ArrayList<String> imagenes;

    public AdapMain(Context context, ArrayList<String> imagenes) {
        this.context = context;
        this.imagenes = imagenes;
    }

    @NonNull
    @Override
    public ImgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_imagen,parent,false);
        return new ImgViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImgViewHolder holder, int position) {

        String imgString = imagenes.get(position);
        Picasso.with(context).load(imgString).fit().into(holder.img);
    }

    @Override
    public int getItemCount() {
        return imagenes.size();
    }

    class ImgViewHolder extends RecyclerView.ViewHolder{

        ImageView img;

        public ImgViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_item);
        }
    }
}
