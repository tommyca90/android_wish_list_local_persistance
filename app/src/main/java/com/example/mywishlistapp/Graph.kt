package com.example.mywishlistapp

import android.content.Context
import androidx.room.Room
import com.example.mywishlistapp.data.WishDatabase
import com.example.mywishlistapp.data.WishRepository

object Graph {
    lateinit var wishDatabase: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDatabase.wishDao())
    }

    fun provide(context: Context){
        wishDatabase = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}