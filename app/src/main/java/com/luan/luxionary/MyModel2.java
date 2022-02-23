package com.luan.luxionary;

public class MyModel2 {

    String title, sub;
    int idx;

    public MyModel2(String title, String sub, int idx) {
        this.title = title;
        this.sub = sub;
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

}