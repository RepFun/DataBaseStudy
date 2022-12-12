package com.iaa.databasestudy.api

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Album")
data class AlbumResponse(
    @PrimaryKey(autoGenerate = false) var id: Int,
    var id: Int,
    var userId: Int,
    var title: String,
    var body: String)
