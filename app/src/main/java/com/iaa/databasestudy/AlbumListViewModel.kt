package com.iaa.databasestudy

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iaa.databasestudy.model.AlbumData
import com.iaa.databasestudy.model.AlbumRepository
import kotlinx.coroutines.launch

class AlbumListViewModel(application: Application) : AndroidViewModel(application) {

    private var repository = AlbumRepository(application)

    private val posts = MutableLiveData<List<AlbumData>>()


    fun getAll(): MutableLiveData<List<AlbumData>> {
        viewModelScope.launch {
            repository.initPosts()
            posts.value = repository.list
        }
        return posts
    }

}