package com.beardness.yourchordsru.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.beardness.yourchordsru.data.db.dao.FavoriteAuthorsDao
import com.beardness.yourchordsru.data.db.dao.FavoriteSongsDao
import com.beardness.yourchordsru.data.db.entity.FavoriteAuthorEntity
import com.beardness.yourchordsru.data.db.entity.FavoriteSongEntity

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