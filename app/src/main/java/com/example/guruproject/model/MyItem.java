package com.example.guruproject.model;

public class MyItem {
    private int imgId;      // 이미지
    private String title;   // 타이틀
    private String subTitle;// 타이틀 설명
    private String price;   // 가격

    public MyItem() {}

    public MyItem(int imgId, String title, String subTitle, String price) {
        this.imgId = imgId;
        this.title = title;
        this.subTitle = subTitle;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MyItem{" + "imgeId=" + imgId + ", title='" + title + '\'' + ", subTitle='" + subTitle + '\'' + ", price='" + price + '\'' + '}';
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgeId) {
        this.imgId = imgeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
