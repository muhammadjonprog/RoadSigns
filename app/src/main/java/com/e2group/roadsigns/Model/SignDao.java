package com.e2group.roadsigns.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SignDao {
    @Query("SELECT * FROM CategoriesSign")
    LiveData<List<CategoriesSign>> getAll();
}
