package com.iaa.databasestudy.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.iaa.databasestudy.room.AlbumEntity

@Dao
interface AlbumDao {

    @Query("Select * from Album")
    fun getAll(): List<AlbumEntity>

    @Insert(onConflict = REPLACE)
    fun insert(post: AlbumEntity)

    @Delete
    fun delete(post: AlbumEntity)
}