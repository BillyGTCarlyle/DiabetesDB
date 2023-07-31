package com.billycarlyle.diabetesdb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealViewHolder extends RecyclerView.ViewHolder {
    private final TextView mealCarbType;
    private final TextView mealCarbCount;

    private MealViewHolder(@NonNull View itemView) {
        super(itemView);
        mealCarbType = itemView.findViewById(R.id.lblCarbTypeDB);
        mealCarbCount = itemView.findViewById(R.id.lblCarbCountDB);
    }

    public void bind(List<String> details){
        mealCarbType.setText(details.get(1));
        mealCarbCount.setText(details.get(2));
    }

    static MealViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new MealViewHolder(view);
    }
}
