package com.leoanrdo.gatosproyecto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class Post (
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val name: String,
    val username: String,
    val content: String,
    val likes: Int
)