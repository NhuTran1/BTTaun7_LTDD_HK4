package com.example.ex9_inclass_webservice

import android.provider.ContactsContract.CommonDataKinds.Email

data class Post(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)
