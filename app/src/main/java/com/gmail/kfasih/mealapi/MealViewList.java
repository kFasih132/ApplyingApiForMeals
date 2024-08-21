package com.gmail.kfasih.mealapi;

import java.util.List;

public class MealViewList {


    public List<MealListModel> meals;

    public MealViewList(List<MealListModel> meals) {
        this.meals = meals;
    }

    public MealViewList() {
    }

    public List<MealListModel> getMeals() {
        return meals;
    }

    public void setMeals(List<MealListModel> meals) {
        this.meals = meals;
    }
    class Meals{

    }
}
