package com.example.a10120246uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class AdapterRecyclerViewGallery extends RecyclerView.Adapter<AdapterRecyclerViewGallery.ViewHolder> {
    //(8 juni 2023, 10120246, Muhammad Naufal Malikulmulki, IF-06)

    private String[] SubjectValuesGallery;
    private int[] SubjectValuesImageGallery;
    private Context contextGallery;


    public AdapterRecyclerViewGallery(String[] subjectValuesGallery, int[] subjectValuesImageGallery, Context contextGallery) {
        SubjectValuesGallery = subjectValuesGallery;
        SubjectValuesImageGallery = subjectValuesImageGallery;
        this.contextGallery = contextGallery;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        ViewHolder(View v) {

            super(v);
            imageView = v.findViewById(R.id.imageItem);
            textView = v.findViewById(R.id.textItem);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(contextGallery).inflate(R.layout.list_gallery_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(SubjectValuesGallery[position]);
        holder.imageView.setImageResource(SubjectValuesImageGallery[position]);
    }

    @Override
    public int getItemCount() {
        return SubjectValuesGallery.length;
    }
}
