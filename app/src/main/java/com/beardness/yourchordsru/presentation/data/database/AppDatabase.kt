package com.beardness.yourchordsru.presentation.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.beardness.yourchordsru.presentation.data.database.dao.FavoriteAuthorsDao
import com.beardness.yourchordsru.presentation.data.database.dao.FavoriteSongsDao
import com.beardness.yourchordsru.presentation.data.database.entity.FavoriteAuthorEntity
import com.beardness.yourchordsru.presentation.data.database.entity.FavoriteSongEntity

@Database(
    entities = [
        FavoriteAuthorEntity::class,
        FavoriteSongEntity::class,
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteAuthorsDao(): FavoriteAuthorsDao
    abstract fun favoriteSongsDao(): FavoriteSongsDao
}