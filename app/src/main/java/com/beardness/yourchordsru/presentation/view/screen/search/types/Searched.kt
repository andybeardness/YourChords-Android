package com.beardness.yourchordsru.presentation.view.screen.search.types

import com.beardness.yourchordsru.presentation.entity.Author
import com.beardness.yourchordsru.presentation.entity.Song

sealed class Searched

class SearchedAuthor(
    val author: Author
) : Searched()

class SearchedSong(
    val authorId: Int,
    val authorName: String,
    val song: Song,
) : Searched()
