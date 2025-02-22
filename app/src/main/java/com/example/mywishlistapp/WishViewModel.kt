package com.example.mywishlistapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class WishViewModel: ViewModel() {
    private val _wishTitleState = mutableStateOf("")
    private val _wishDescriptionState = mutableStateOf("")

    val wishTitleState: MutableState<String> = _wishTitleState
    val wishDescriptionState: MutableState<String> = _wishDescriptionState

    fun onWishTitleChanged(newTitle: String){
        _wishTitleState.value = newTitle
    }

    fun onWishDescriptionChanged(newDescription: String){
        _wishDescriptionState.value = newDescription
    }
}