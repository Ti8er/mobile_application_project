package com.example.shrekrestaurant.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.shrekrestaurant.Orders.Menu;

import java.util.List;

@Dao
public interface MenuDao {
@Insert
Void insert(Menu menu);

}
