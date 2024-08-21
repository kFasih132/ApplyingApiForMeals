package com.gmail.kfasih.mealapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit instance;
    private RetrofitClient(){}
    public static final String BASE_URL = "https://www.themealdb.com";
    public static Retrofit getInstance(){
        if (instance == null){
            instance = new  Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
