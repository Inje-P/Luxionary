package com.luan.luxionary;

public class MyModel {

    String title, description;
    int idx, image;

    public MyModel(String title, String description, int idx, int image) {
        this.title = title;
        this.description = description;
        this.idx = idx;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}