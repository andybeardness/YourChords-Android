package com.beardness.yourchordsru.presentation.core.search

import com.beardness.yourchordsru.presentation.core.dto.SongCoreDto
import com.beardness.yourchordsru.presentation.core.dto.coreDto
import com.beardness.yourchordsru.presentation.data.repo.authors.IAuthorsRepo
import com.beardness.yourchordsru.presentation.data.repo.songs.ISongsRepo
import javax.inject.Inject

class SearchCore @Inject constructor(
    private val authorsRepo: IAuthorsRepo,
    private val songsRepo: ISongsRepo,
) : ISearchCore {
    override suspend fun searchSongs(pattern: String): List<SongCoreDto> {
        val foundedSongs = mutableListOf<SongCoreDto>()

        val authors = authorsRepo.authors()

        authors.forEach { authorRepoDto ->
            val songs = songsRepo.songs(authorId = authorRepoDto.id)

            songs.forEach { songRepoDto ->
                val isPatternMatch =
                    songRepoDto
                        .chords
                        .lowercase()
                        .contains(other = pattern)

                if (isPatternMatch) {
                    foundedSongs.add(element = songRepoDto.coreDto())
                }
            }
        }

        return foundedSongs
    }
}