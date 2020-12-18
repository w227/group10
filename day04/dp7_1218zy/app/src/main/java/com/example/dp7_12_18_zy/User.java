package com.example.dp7_12_18_zy;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    @Id(autoincrement = true)
    private Long mId;
    private String title;
    private String pic;
    @Generated(hash = 2059400798)
    public User(Long mId, String title, String pic) {
        this.mId = mId;
        this.title = title;
        this.pic = pic;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getMId() {
        return this.mId;
    }
    public void setMId(Long mId) {
        this.mId = mId;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
}
