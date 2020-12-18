package com.example.myapplication;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Shu {
    @Id(autoincrement = true)
    private Long mid;
    private String title;
    private String intro;
    private String icon;
    @Generated(hash = 891872993)
    public Shu(Long mid, String title, String intro, String icon) {
        this.mid = mid;
        this.title = title;
        this.intro = intro;
        this.icon = icon;
    }
    @Generated(hash = 770183894)
    public Shu() {
    }
    public Long getMid() {
        return this.mid;
    }
    public void setMid(Long mid) {
        this.mid = mid;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIntro() {
        return this.intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    

}
