package com.example.data12_17homework.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class CollectionDbBean {

    @Id(autoincrement = true)
    private Long id;
    private String icon;
    private String title;
    private String content;
    @Generated(hash = 1032306689)
    public CollectionDbBean(Long id, String icon, String title, String content) {
        this.id = id;
        this.icon = icon;
        this.title = title;
        this.content = content;
    }
    @Generated(hash = 1521980762)
    public CollectionDbBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }


}
