package com.gmail.kfasih.mealapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MealListActivity extends AppCompatActivity {
    TextView tvCategory;
    RecyclerView rvMealList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_list);

        tvCategory = findViewById(R.id.tvCategory);
        rvMealList = findViewById(R.id.rvMealList);

        Retrofit retrofit = RetrofitClient.getInstance();
        MealApiServices mealApiServices = retrofit.create(MealApiServices.class);

        //getting extra for category name
        String strCategory = getIntent().getStringExtra(CategoriesModel.CATEGORY_NAME_EXTRA);

//        Call<MealList> mealsCall = mealApiServices.getMealsList(strCategory);
        Call<MealViewList> mealsCall = mealApiServices.getMealsList2(strCategory);
        mealsCall.enqueue(new Callback<MealViewList>() {
            @Override
            public void onResponse(Call<MealViewList> call, Response<MealViewList> response) {
               if (response.isSuccessful()){
                   tvCategory.setText(strCategory);
                   MealViewList mealViewList = response.body();
                   MealListAdaptor mealListAdaptor = new MealListAdaptor(mealViewList.getMeals());
                   rvMealList.setAdapter(mealListAdaptor);
                   rvMealList.setLayoutManager(new LinearLayoutManager(MealListActivity.this));
                   rvMealList.setHasFixedSize(true);
                   mealListAdaptor.setOnRVItemClickListener(new MealListAdaptor.OnRVItemClickListener() {
                       @Override
                       public void onClick(int position) {
                           Intent intent = new Intent(MealListActivity.this,MealActivity.class);
                           intent.putExtra(MealListModel.MEAL_ID_EXTRA,mealViewList.getMeals().get(position).getIdMeal());
                           intent.putExtra(MealListModel.MEAL_NAME_EXTRA,mealViewList.getMeals().get(position).getStrMeal());
                           intent.putExtra(MealListModel.MEAL_THUMB_EXTRA,mealViewList.getMeals().get(position).getStrMealThumb());
                           startActivity(intent);
                       }
                   });
               }
            }

            @Override
            public void onFailure(Call<MealViewList> call, Throwable t) {

            }
        });
    }
}