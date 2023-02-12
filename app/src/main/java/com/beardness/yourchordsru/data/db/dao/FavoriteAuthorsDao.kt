package com.beardness.yourchordsru.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.beardness.yourchordsru.data.db.entity.FavoriteAuthorEntity

@Dao
interface FavoriteAuthorsDao {
    @Query("SELECT * FROM favorite_authors")
    suspend fun all(): List<FavoriteAuthorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favoriteAuthorEntity: FavoriteAuthorEntity)

    @Query("DELETE FROM favorite_authors WHERE author_id = :authorId")
    suspend fun remove(authorId: Int)
}