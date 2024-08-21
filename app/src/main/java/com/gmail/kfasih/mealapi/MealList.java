package com.gmail.kfasih.mealapi;

import java.util.List;

public class MealList {

    private List<Meal> meals;

    public MealList(List<Meal> meals) {
        this.meals = meals;
    }

    // Getter
    public List<Meal> getMeals() {
        return meals;
    }

    // Setter
    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
