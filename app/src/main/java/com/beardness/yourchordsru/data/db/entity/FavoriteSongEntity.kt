package com.beardness.yourchordsru.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorite_songs"
)
data class FavoriteSongEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "author_id") val authorId: Int,
    @ColumnInfo(name = "song_id") val songId: Int,
)