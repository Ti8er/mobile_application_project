package com.example.shrekrestaurant.Orders;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cart")
public class Cart {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "USERID")
    public int userID;
    @ColumnInfo(name = "ITEM")
    public int item;
    @ColumnInfo(name = "Quantity")
    public int Quantity;

    public int getId() {
        return id;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
