package com.gmail.kfasih.mealapi;

import java.util.Objects;

public class MealListModel {
    public static final String MEAL_ID_EXTRA ="idMeal";
    public static final String MEAL_NAME_EXTRA ="strMeal";
    public static final String MEAL_THUMB_EXTRA ="strMealThumb";

    private String strMeal;
    private String strMealThumb;
    private int idMeal;

    public MealListModel(String strMeal, String strMealThumb, int idMeal) {
        this.strMeal = strMeal;
        this.strMealThumb = strMealThumb;
        this.idMeal = idMeal;
    }
    public MealListModel() {
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public int getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(int idMeal) {
        this.idMeal = idMeal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealListModel that = (MealListModel) o;
        return idMeal == that.idMeal && Objects.equals(strMeal, that.strMeal) && Objects.equals(strMealThumb, that.strMealThumb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strMeal, strMealThumb, idMeal);
    }

    @Override
    public String toString() {
        return "MealListModel{" +
                "strMeal='" + strMeal + '\'' +
                ", strMealThumb='" + strMealThumb + '\'' +
                ", idMeal=" + idMeal +
                '}';
    }
}
