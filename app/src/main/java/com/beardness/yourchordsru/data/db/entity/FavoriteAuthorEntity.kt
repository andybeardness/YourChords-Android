package com.beardness.yourchordsru.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorite_authors"
)
data class FavoriteAuthorEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "author_id") val authorId: Int,
)
