package com.example.wman.Classes;

public class SellerCategoryClass {

    String img;
    String categoryName;

    public SellerCategoryClass() {
    }

    public SellerCategoryClass(String img, String categoryName) {
        this.img = img;
        this.categoryName = categoryName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
