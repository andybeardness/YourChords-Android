package com.beardness.yourchordsru.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.beardness.yourchordsru.data.db.entity.FavoriteSongEntity

@Dao
interface FavoriteSongsDao {
    @Query("SELECT * FROM favorite_songs")
    suspend fun all(): List<FavoriteSongEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favoriteSongEntity: FavoriteSongEntity)

    @Query("DELETE FROM favorite_songs WHERE author_id = :authorId AND song_id = :songId")
    suspend fun remove(authorId: Int, songId: Int)
}