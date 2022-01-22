package com.luan.luxionary;

public class DataPage {
    int image;
    String title1, title2;

    public DataPage(int image, String title1, String title2) {
        this.image = image;
        this.title1 = title1;
        this.title2 = title2;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }
}
