package com.beardness.yourchordsru.presentation.screens.home

import com.beardness.yourchordsru.presentation.screens.dto.AuthorViewDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface IHomeScreenViewModel {
    val authors: Flow<List<AuthorViewDto>>
    val scrollUp: StateFlow<Boolean?>
    fun openDrawer()
    fun navigateToAuthor(authorId: Int)
    fun navigateToSearch()
    fun updateScrollPosition(firstVisibleItemIndex: Int)
}