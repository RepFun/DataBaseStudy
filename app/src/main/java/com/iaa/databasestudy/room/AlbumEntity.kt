package com.iaa.databasestudy.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Album")
data class AlbumEntity(
    @PrimaryKey(autoGenerate = false) var id: Int,
    var userId: Int,
    var title: String
)
