package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {

    private List<Pair<String, Integer>> listObjects; // objects in the Adapter
    private OnItemCustomClickListener clickListener; // items click listener

    /**
     * Custom clickListener for items in the Adapter
     */
    public interface OnItemCustomClickListener {
        void onItemClicked(int position, ImageView ivLogo, TextView tvName);
    }

    /**
     * Constructor
     */
    public VerticalAdapter(int count, OnItemCustomClickListener clickListener) {
        // generate list of objects
        listObjects = ObjectGenerator.generateObjects(count);
        this.clickListener = clickListener;
    }

    /**
     * Getting item from its position
     */
    public Pair<String, Integer> getItem(int position) {
        if (position >= 0 && position < listObjects.size()) {
            return listObjects.get(position);
        } else return null;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_vertical_adapter, viewGroup,
                false);
        return new ViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Pair<String, Integer> object = listObjects.get(position);
        viewHolder.tvName.setText("Item position " + position);
        viewHolder.ivLogo.setBackgroundColor(Color.parseColor(object.first));
        viewHolder.ivLogo.setImageResource(object.second);
    }

    @Override
    public int getItemCount() {
        return listObjects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private ImageView ivLogo;

        public ViewHolder(@NonNull View itemView, final OnItemCustomClickListener clickListener) {
            super(itemView);
            // find views
            tvName = itemView.findViewById(R.id.tvName);
            ivLogo = itemView.findViewById(R.id.ivLogo);
            // set click listener
            itemView.setOnClickListener(v -> {
                if (clickListener != null) {
                    clickListener.onItemClicked(getAdapterPosition(), ivLogo, tvName);
                }
            });
        }
    }
}
