package com.example.shrekrestaurant.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.shrekrestaurant.Food;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface FoodDao {


    @Insert
    Void addFood(List<Food> foodList);

    @Query("SELECT * FROM food")
    List<Food> getFoodList();


}
