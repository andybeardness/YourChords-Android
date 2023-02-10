package com.beardness.yourchordsru.presentation.screens.home

import com.beardness.yourchordsru.presentation.screens.dto.AuthorViewDto
import com.beardness.yourchordsru.presentation.screens.dto.types.AuthorsSortType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface IHomeScreenViewModel {
    val authorsSortType: StateFlow<AuthorsSortType>
    val authors: Flow<List<AuthorViewDto>>
    val scrollUp: StateFlow<Boolean?>
    fun navigateToHome()
    fun navigateToAuthor(authorId: Int)
    fun navigateToSearch()
    fun navigateToSettings()
    fun updateScrollPosition(firstVisibleItemIndex: Int)
    fun changeAuthorsSortType()
}