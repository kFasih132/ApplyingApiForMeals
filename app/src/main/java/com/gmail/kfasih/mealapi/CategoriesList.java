package com.gmail.kfasih.mealapi;

import java.util.List;
import java.util.Objects;

public class CategoriesList {
    List<CategoriesModel> categories;

    public CategoriesList(List<CategoriesModel> categories) {
        this.categories = categories;
    }

    public List<CategoriesModel> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesModel> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriesList that = (CategoriesList) o;
        return Objects.equals(categories, that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(categories);
    }
}
