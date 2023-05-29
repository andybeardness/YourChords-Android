package com.beardness.yourchordsru.presentation.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.beardness.yourchordsru.presentation.data.database.entity.FavoriteSongEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteSongsDao {
    @Query("SELECT * FROM favorite_songs")
    fun flow(): Flow<List<FavoriteSongEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favoriteSongEntity: FavoriteSongEntity)

    @Query("DELETE FROM favorite_songs WHERE author_id = :authorId AND song_id = :songId")
    suspend fun remove(authorId: Int, songId: Int)
}