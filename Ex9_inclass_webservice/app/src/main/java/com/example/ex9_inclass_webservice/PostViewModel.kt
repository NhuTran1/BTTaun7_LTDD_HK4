package com.example.ex9_inclass_webservice

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostViewMode : ViewModel() {
    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    ApiClient.api.getPosts() }
                Log.d("PostViewModel", "Results: ${response.size}")
                _posts.value = response
            } catch (e: Exception) {
                Log.e("PostViewModel", "Error", e)
            }
        }
    }

    fun createPost(post: Post) {
        viewModelScope.launch {
            try {
                val response = ApiClient.api.createPost(post)
                if (response.isSuccessful) {
                    fetchPosts() //Refresh data
                }
            } catch (e: Exception) {
                Log.e("PostViewModel", "Error", e)
            }
        }
    }
//
//    fun updatePost(id: Int, post: Post) {
//        viewModelScope.launch {
//            try {
//                val respone = ApiClient.api.updatePost(id, post)
//                if(respone.isSuccessful){
//                    fetchPosts()
//                }
//            } catch (e: Exception) {
//                Log.e("PostViewModel", "Error", e)
//            }
//        }
//    }
//
//    fun deletePost(id: Int) {
//        viewModelScope.launch {
//            try {
//                val response = ApiClient.api.deletePost(id)
//                if (response.isSuccessful) {
//                    fetchPosts() //Refresh data
//                }
//            } catch (e:Exception) {
//                Log.e("PostViewModel", "Error", e)
//            }
//        }
//    }
}