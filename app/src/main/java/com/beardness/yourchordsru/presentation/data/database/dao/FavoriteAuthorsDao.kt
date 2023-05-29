package com.beardness.yourchordsru.presentation.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.beardness.yourchordsru.presentation.data.database.entity.FavoriteAuthorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteAuthorsDao {
    @Query("SELECT * FROM favorite_authors")
    fun flow(): Flow<List<FavoriteAuthorEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favoriteAuthorEntity: FavoriteAuthorEntity)

    @Query("DELETE FROM favorite_authors WHERE author_id = :authorId")
    suspend fun remove(authorId: Int)
}