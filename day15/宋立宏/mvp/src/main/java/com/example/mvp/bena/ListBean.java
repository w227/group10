package com.example.mvp.bena;

public class ListBean {
    private String name;

    public ListBean(String name) {
        this.name = name;
    }

    public ListBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "ListBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
