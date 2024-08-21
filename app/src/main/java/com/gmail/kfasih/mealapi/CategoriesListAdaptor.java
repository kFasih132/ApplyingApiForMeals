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

public class CategoriesListAdaptor extends RecyclerView.Adapter<CategoriesListAdaptor.ViewHolder>{
    private OnRVItemClickListener onRVItemClickListener;
    private List<CategoriesModel> categoriesList;

    public void setOnRVItemClickListener(OnRVItemClickListener onRVItemClickListener) {
        this.onRVItemClickListener = onRVItemClickListener;
    }

    public CategoriesListAdaptor(List<CategoriesModel> categoriesList) {
        this.categoriesList = categoriesList;
    }


    @NonNull
    @Override
    public CategoriesListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categorie_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesListAdaptor.ViewHolder holder, int position) {
        CategoriesModel categoriesModel = categoriesList.get(position);
        holder.tvCategoriesName.setText(categoriesModel.getStrCategory());
        holder.tvCategoriesDescription.setText(categoriesModel.getStrCategoryDescription());
        Glide.with(holder.itemView.getContext())
                .load(categoriesModel.getStrCategoryThumb())
                .into(holder.ivCategoriesThumbImage);

    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivCategoriesThumbImage;
        TextView tvCategoriesName;
        TextView tvCategoriesDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCategoriesThumbImage = itemView.findViewById(R.id.ivCategoriesThumbImage);
            tvCategoriesName = itemView.findViewById(R.id.tvCategoriesName);
            tvCategoriesDescription = itemView.findViewById(R.id.tvCategoriesDescription);
            ivCategoriesThumbImage.setOnClickListener(new View.OnClickListener() {
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
