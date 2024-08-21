package com.gmail.kfasih.mealapi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MealActivity extends AppCompatActivity {

    ImageView ivMealViewThumb;
    TextView tvMealName;
    Button btnWatchVideo;
    RecyclerView rvActivityMeal;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        ivMealViewThumb = findViewById(R.id.ivMealViewThumb);
        tvMealName = findViewById(R.id.tvMealName);
        btnWatchVideo = findViewById(R.id.btnWatchVideo);
        rvActivityMeal = findViewById(R.id.rvActivityMeal);

        Retrofit retrofit = RetrofitClient.getInstance();
        MealApiServices mealApiServices = retrofit.create(MealApiServices.class);

        //Collecting All Extras
        int idMeal = getIntent().getIntExtra(MealListModel.MEAL_ID_EXTRA,0);
        String mealName = getIntent().getStringExtra(MealListModel.MEAL_NAME_EXTRA);
        String mealThumb = getIntent().getStringExtra(MealListModel.MEAL_THUMB_EXTRA);

        String search = getIntent().getStringExtra("search");



        Call<MealList> callMealById = mealApiServices.getMealById(idMeal);
        callMealById.enqueue(new Callback<MealList>() {
            @Override
            public void onResponse(Call<MealList> call, Response<MealList> response) {
                if (response.isSuccessful()){

                    MealList mealList = response.body();

                    tvMealName.setText(mealName);
                    Glide.with(MealActivity.this)
                            .load(mealThumb)
                            .into(ivMealViewThumb);



                    MealAdaptor mealAdaptor = new MealAdaptor(mealList.getMeals());
                    rvActivityMeal.setAdapter(mealAdaptor);
                    rvActivityMeal.setLayoutManager(new LinearLayoutManager(MealActivity.this));
                    rvActivityMeal.setHasFixedSize(true);
                    btnWatchVideo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mealList.getMeals().get(0).getStrYoutube()));
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<MealList> call, Throwable t) {

            }
        });
    }
}