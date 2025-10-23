package com.leoanrdo.gatosproyecto

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostDao {
    @Insert
    suspend fun guardar(item: Post)

    @Query("SELECT * FROM post")
    suspend fun obtenerLista(): List<Post>
}