package com.example.xsx_shipei_dp.bean;

public class DushiBean {
    private String name;
    private String desc;
    private int imgPath;
    private String content;

    public DushiBean(){}

    public DushiBean(String name, String desc, int imgPath,String content) {
        this.content = content;
        this.name = name;
        this.desc = desc;
        this.imgPath = imgPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
