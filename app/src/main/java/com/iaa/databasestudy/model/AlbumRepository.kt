package com.iaa.databasestudy.model

import android.content.Context
import androidx.room.Room
import com.iaa.databasestudy.api.AlbumResponse
import com.iaa.databasestudy.api.AlbumRestApi
import com.iaa.databasestudy.room.LocalDb
import com.iaa.databasestudy.room.AlbumDao
import com.iaa.databasestudy.room.AlbumEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AlbumRepository(context: Context) {

    var list = mutableListOf<AlbumData>()

    private val postService = AlbumRestApi.getService()
    private val postDao =
        Room.databaseBuilder(context, LocalDb::class.java, "post").build().AlbumDao()


    suspend fun initPosts() {
        withContext(Dispatchers.IO) {
            val result = postService.getAll().execute().body()
            if (result != null) {
                list = convertFromPostResponse(result)
                result.forEach {
                    postDao.insert(AlbumEntity(it.id, it.userId, it.title))
                }
            }
        }
    }

    private fun convertFromPostResponse(list: List<AlbumResponse>?): MutableList<AlbumData> {
        val result = mutableListOf<AlbumData>()

        list?.forEach {
            val post = AlbumData(it.id, it.userId, it.title)
            result.add(post)
        }

        return result
    }

}