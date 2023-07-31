package com.billycarlyle.diabetesdb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MealViewHolder extends RecyclerView.ViewHolder {
    private final TextView mealItemView;

    private MealViewHolder(@NonNull View itemView) {
        super(itemView);
        mealItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text){
        mealItemView.setText(text);
    }

    static MealViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new MealViewHolder(view);
    }
}
