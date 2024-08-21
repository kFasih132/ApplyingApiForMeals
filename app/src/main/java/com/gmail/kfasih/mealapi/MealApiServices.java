package com.gmail.kfasih.mealapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealApiServices {
    String API_URL = "/api/json/v1/1";

    @GET(API_URL+"/categories.php")
    Call<CategoriesList> getCategories();

    @GET(API_URL+"/filter.php?c={strCategory}")
    Call<MealViewList> getMealsList(@Query("strCategory") String strCategory);

    @GET(API_URL+"/filter.php")
    Call<MealViewList> getMealsList2(@Query("c") String category);

    @GET(API_URL+"/lookup.php")
    Call<MealList> getMealById(@Query("i") int idMeal);

    @GET(API_URL+"/search.php")
    Call<MealList>  getMealByName(@Query("s") String mealName);



}
