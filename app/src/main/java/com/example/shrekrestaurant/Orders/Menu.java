package com.example.shrekrestaurant.Orders;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "food")
public class Menu {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String name;
    private Double price;

    public Menu(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
