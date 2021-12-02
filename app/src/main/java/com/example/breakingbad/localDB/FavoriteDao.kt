package com.example.breakingbad.localDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.breakingbad.data.FavouriteEntity

@Dao
interface FavouriteDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavourite(favourite: FavouriteEntity)

    @Query("SELECT * FROM favourites WHERE id = :id")

    fun getFavouriteById(id: Int): FavouriteEntity?
}