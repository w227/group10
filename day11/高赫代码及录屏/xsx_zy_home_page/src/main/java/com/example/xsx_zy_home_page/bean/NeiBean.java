package com.example.xsx_zy_home_page.bean;

public class NeiBean {
    private int imgPath;
    private String name;

    public NeiBean(int imgPath, String name) {
        this.imgPath = imgPath;
        this.name = name;
    }
    public NeiBean(){}

    public int getImgPath() {
        return imgPath;
    }

    public void setImgPath(int imgPath) {
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
