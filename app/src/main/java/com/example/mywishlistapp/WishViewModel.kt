package com.example.mywishlistapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywishlistapp.data.Wish
import com.example.mywishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
) : ViewModel() {

    private val _wishTitleState = mutableStateOf("")
    private val _wishDescriptionState = mutableStateOf("")

    val wishTitleState: MutableState<String> = _wishTitleState
    val wishDescriptionState: MutableState<String> = _wishDescriptionState

    fun onWishTitleChanged(newTitle: String) {
        _wishTitleState.value = newTitle
    }

    fun onWishDescriptionChanged(newDescription: String) {
        _wishDescriptionState.value = newDescription
    }

    lateinit var wishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            wishes = wishRepository.getWishes()
        }
    }

    fun addWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addWish(wish)
        }
    }

    fun updateWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateWish(wish)
        }
    }

    fun getWishById(id: Long): Flow<Wish> {
        return wishRepository.getWishById(id)
    }

    fun deleteWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteWish(wish)
        }
    }
}