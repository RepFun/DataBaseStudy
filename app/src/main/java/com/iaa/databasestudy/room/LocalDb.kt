package com.iaa.databasestudy.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AlbumEntity::class], version = 1)
abstract class LocalDb : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}