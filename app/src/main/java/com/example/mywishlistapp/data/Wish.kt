package com.example.mywishlistapp.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyWishes {
    val wishList = listOf(
        Wish(0, "Wish 0", "Wish 0 description"),
        Wish(1, "Wish 1", "Wish 1 description"),
        Wish(2, "Wish 2", "Wish 2 description"),
        Wish(3, "Wish 3", "Wish 3 description"),
    )
}