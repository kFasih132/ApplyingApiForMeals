package com.gmail.kfasih.mealapi;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealAdaptor extends RecyclerView.Adapter<MealAdaptor.IngredientViewHolder> {
    List<Meal> meals;

    public MealAdaptor(List<Meal> meals) {
        this.meals = meals;
    }

    @NonNull
    @Override
    public MealAdaptor.IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_vs_measurement,parent,false);
            return new IngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        Meal meal = meals.get(position);

        holder.tvIngredientsName1.setText(R.string.ingredients);
        holder.tvIngredientsName2.setText(meal.getStrIngredient1());
        holder.tvIngredientsName3.setText(meal.getStrIngredient2());
        holder.tvIngredientsName4.setText(meal.getStrIngredient3());
        holder.tvIngredientsName5.setText(meal.getStrIngredient4());
        holder.tvIngredientsName6.setText(meal.getStrIngredient5());
        holder.tvIngredientsName7.setText(meal.getStrIngredient6());
        holder.tvIngredientsName8.setText(meal.getStrIngredient7());
        holder.tvIngredientsName9.setText(meal.getStrIngredient8());
        holder.tvIngredientsName10.setText(meal.getStrIngredient9());
        holder.tvIngredientsName11.setText(meal.getStrIngredient10());
        holder.tvIngredientsName12.setText(meal.getStrIngredient11());
        holder.tvIngredientsName13.setText(meal.getStrIngredient12());
        holder.tvIngredientsName14.setText(meal.getStrIngredient13());

        holder.tvMeasurement1.setText(R.string.measurements);
        holder.tvMeasurement2.setText(meal.getStrMeasure1());
        holder.tvMeasurement3.setText(meal.getStrMeasure2());
        holder.tvMeasurement4.setText(meal.getStrMeasure3());
        holder.tvMeasurement5.setText(meal.getStrMeasure4());
        holder.tvMeasurement6.setText(meal.getStrMeasure5());
        holder.tvMeasurement7.setText(meal.getStrMeasure6());
        holder.tvMeasurement8.setText(meal.getStrMeasure7());
        holder.tvMeasurement9.setText(meal.getStrMeasure8());
        holder.tvMeasurement10.setText(meal.getStrMeasure9());
        holder.tvMeasurement11.setText(meal.getStrMeasure10());
        holder.tvMeasurement12.setText(meal.getStrMeasure11());
        holder.tvMeasurement13.setText(meal.getStrMeasure12());
        holder.tvMeasurement14.setText(meal.getStrMeasure13());

        holder.tvInstructions.setText("Instructions: "+meal.getStrInstructions());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public int getItemCount() {
        if (meals != null){
            return meals.size();
        }
        return 0;
    }

    class IngredientViewHolder extends RecyclerView.ViewHolder{
        TextView tvInstructions;
        TextView tvIngredientsName1 , tvIngredientsName2 , tvIngredientsName3,tvIngredientsName4,tvIngredientsName5,tvIngredientsName6,tvIngredientsName7,tvIngredientsName8,tvIngredientsName9,tvIngredientsName10,tvIngredientsName11,tvIngredientsName12,tvIngredientsName13,tvIngredientsName14;
        TextView tvMeasurement1 , tvMeasurement2 , tvMeasurement3,tvMeasurement4,tvMeasurement5,tvMeasurement6,tvMeasurement7,tvMeasurement8,tvMeasurement9,tvMeasurement10,tvMeasurement11,tvMeasurement12,tvMeasurement13,tvMeasurement14;

        public IngredientViewHolder(@NonNull View itemView) {
            super(itemView);

            tvInstructions = itemView.findViewById(R.id.tvInstructions);

            tvIngredientsName1 = itemView.findViewById(R.id.tvIngredientsName1);
            tvIngredientsName2 = itemView.findViewById(R.id.tvIngredientsName2);
            tvIngredientsName3 = itemView.findViewById(R.id.tvIngredientsName3);
            tvIngredientsName4 = itemView.findViewById(R.id.tvIngredientsName4);
            tvIngredientsName5 = itemView.findViewById(R.id.tvIngredientsName5);
            tvIngredientsName6 = itemView.findViewById(R.id.tvIngredientsName6);
            tvIngredientsName7 = itemView.findViewById(R.id.tvIngredientsName7);
            tvIngredientsName8 = itemView.findViewById(R.id.tvIngredientsName8);
            tvIngredientsName9 = itemView.findViewById(R.id.tvIngredientsName9);
            tvIngredientsName10 = itemView.findViewById(R.id.tvIngredientsName10);
            tvIngredientsName11 = itemView.findViewById(R.id.tvIngredientsName11);
            tvIngredientsName12 = itemView.findViewById(R.id.tvIngredientsName12);
            tvIngredientsName13 = itemView.findViewById(R.id.tvIngredientsName13);
            tvIngredientsName14 = itemView.findViewById(R.id.tvIngredientsName14);

            tvMeasurement1 = itemView.findViewById(R.id.tvMeasurement1);
            tvMeasurement2 = itemView.findViewById(R.id.tvMeasurement2);
            tvMeasurement3 = itemView.findViewById(R.id.tvMeasurement3);
            tvMeasurement4 = itemView.findViewById(R.id.tvMeasurement4);
            tvMeasurement5 = itemView.findViewById(R.id.tvMeasurement5);
            tvMeasurement6 = itemView.findViewById(R.id.tvMeasurement6);
            tvMeasurement7 = itemView.findViewById(R.id.tvMeasurement7);
            tvMeasurement8 = itemView.findViewById(R.id.tvMeasurement8);
            tvMeasurement9 = itemView.findViewById(R.id.tvMeasurement9);
            tvMeasurement10 = itemView.findViewById(R.id.tvMeasurement10);
            tvMeasurement11 = itemView.findViewById(R.id.tvMeasurement11);
            tvMeasurement12 = itemView.findViewById(R.id.tvMeasurement12);
            tvMeasurement13 = itemView.findViewById(R.id.tvMeasurement13);
            tvMeasurement14 = itemView.findViewById(R.id.tvMeasurement14);

        }
    }
}
