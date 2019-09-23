package com.example.databasetest;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Item implements Serializable {
    private String name;
    private String des;

    public Item() {

    }

    public Item(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Item Name: " + this.name + "\nItem Description : " + this.des;
    }
}
