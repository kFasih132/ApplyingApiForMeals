package com.gmail.kfasih.mealapi;

import java.util.Objects;

public class CategoriesModel {
    public static final String CATEGORY_ID_EXTRA="idCategory";
    public static final String CATEGORY_NAME_EXTRA="strCategory";
    private String strCategory;
    private String strCategoryThumb;
    private String strCategoryDescription;
    private int idCategory;

    public CategoriesModel(String strCategory, String strCategoryThumb, String strCategoryDescription, int idCategory) {
        this.strCategory = strCategory;
        this.strCategoryThumb = strCategoryThumb;
        this.strCategoryDescription = strCategoryDescription;
        this.idCategory = idCategory;
    }

    public CategoriesModel() {
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }

    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }

    public void setStrCategoryDescription(String strCategoryDescription) {
        this.strCategoryDescription = strCategoryDescription;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriesModel that = (CategoriesModel) o;
        return idCategory == that.idCategory && Objects.equals(strCategory, that.strCategory) && Objects.equals(strCategoryThumb, that.strCategoryThumb) && Objects.equals(strCategoryDescription, that.strCategoryDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strCategory, strCategoryThumb, strCategoryDescription, idCategory);
    }

    @Override
    public String toString() {
        return "CategoriesListModel{" +
                "strCategory='" + strCategory + '\'' +
                ", strCategoryThumb='" + strCategoryThumb + '\'' +
                ", strCategoryDescription='" + strCategoryDescription + '\'' +
                ", idCategory=" + idCategory +
                '}';
    }
}
