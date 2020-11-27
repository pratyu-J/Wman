package com.Neuralsift.Sesvo.Classes;

public class CategoryClass {

    String image;
    String categoryName;

    public CategoryClass() {
    }

    public CategoryClass(String image, String categoryName) {
        this.image = image;
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
