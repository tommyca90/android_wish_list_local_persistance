package com.example.mywishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name="wish-title")
    val title: String = "",
    @ColumnInfo(name="wish-description")
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