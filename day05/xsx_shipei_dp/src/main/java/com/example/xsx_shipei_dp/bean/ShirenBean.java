package com.example.xsx_shipei_dp.bean;

public class ShirenBean {
    private String name;
    private String desc;
    private int imgPath;

    public ShirenBean(){}

    public ShirenBean(String name, String desc, int imgPath) {
        this.name = name;
        this.desc = desc;
        this.imgPath = imgPath;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgPath() {
        return imgPath;
    }

    public void setImgPath(int imgPath) {
        this.imgPath = imgPath;
    }
}
