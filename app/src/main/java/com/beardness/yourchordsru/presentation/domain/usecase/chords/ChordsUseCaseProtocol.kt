package com.beardness.yourchordsru.presentation.domain.usecase.chords

interface ChordsUseCaseProtocol {
    suspend fun chords(authorId: Int, songId: Int): String?

}
