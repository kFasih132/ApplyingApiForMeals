package com.gmail.kfasih.mealapi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    public static final String ET_SEARCH_EXTRA = "etSearch";
    public static final String SEARCH_MEAL_ID_EXTRA = "idMealSearch";

    RecyclerView recyclerView;
    EditText etSearch;
    Button btnSearch;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
//        etSearch = findViewById(R.id.etSearch);
//        btnSearch = findViewById(R.id.btnSearch);

        Retrofit retrofit = RetrofitClient.getInstance();
        MealApiServices mealApiServices = retrofit.create(MealApiServices.class);
        Call<CategoriesList> categoryCall = mealApiServices.getCategories();

        categoryCall.enqueue(new Callback<CategoriesList>() {
            @Override
            public void onResponse(Call<CategoriesList> call, Response<CategoriesList> response) {
                CategoriesList categoriesList = response.body();
                CategoriesListAdaptor categoriesListAdaptor = new CategoriesListAdaptor(categoriesList.getCategories());
                recyclerView.setAdapter(categoriesListAdaptor);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setHasFixedSize(true);
//                recyclerView.
//                recyclerView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent = new Intent(getApplicationContext(), MealListActivity.class);
//                        intent.putExtra(CategoriesModel.CATEGORY_ID_EXTRA,23);
//                    }
//                });
                categoriesListAdaptor.setOnRVItemClickListener(new CategoriesListAdaptor.OnRVItemClickListener() {
                    @Override
                    public void onClick(int position) {
                        Intent intent = new Intent(getApplicationContext(), MealListActivity.class);
                        CategoriesModel categoriesModel = categoriesList.categories.get(position);
                        Toast.makeText(MainActivity.this, categoriesModel.getStrCategory(), Toast.LENGTH_SHORT).show();
                        intent.putExtra(CategoriesModel.CATEGORY_ID_EXTRA,categoriesModel.getIdCategory());
                        intent.putExtra(CategoriesModel.CATEGORY_NAME_EXTRA,categoriesModel.getStrCategory());
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onFailure(Call<CategoriesList> call, Throwable t) {

            }
        });


    }
}