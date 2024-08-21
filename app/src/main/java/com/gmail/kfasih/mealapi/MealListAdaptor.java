package com.gmail.kfasih.mealapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MealListAdaptor extends RecyclerView.Adapter<MealListAdaptor.MealListHolder> {
    private List<MealListModel> mealList;
    private OnRVItemClickListener onRVItemClickListener;

    public void setOnRVItemClickListener(OnRVItemClickListener onRVItemClickListener) {
        this.onRVItemClickListener = onRVItemClickListener;
    }

    public MealListAdaptor(List<MealListModel> mealList) {
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public MealListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_list_view,parent,false);
        return new MealListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealListHolder holder, int position) {
        MealListModel mealListModel = mealList.get(position);
        holder.tvStrMeal.setText(mealListModel.getStrMeal());
        Glide.with(holder.itemView.getContext())
                .load(mealListModel.getStrMealThumb())
                .into(holder.ivMealThumb);

    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    class MealListHolder extends RecyclerView.ViewHolder {
        ImageView ivMealThumb;
        TextView tvStrMeal;

        public MealListHolder(@NonNull View itemView) {
            super(itemView);
            ivMealThumb = itemView.findViewById(R.id.ivMealThumb);
            tvStrMeal = itemView.findViewById(R.id.tvStrMeal);
            ivMealThumb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onRVItemClickListener != null){
                        int position = getAdapterPosition();
                        onRVItemClickListener.onClick(position);
                    }
                }
            });
        }
    }
    interface OnRVItemClickListener {
        void onClick(int position);
    }
}
