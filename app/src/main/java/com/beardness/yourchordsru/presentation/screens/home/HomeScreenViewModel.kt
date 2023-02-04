package com.beardness.yourchordsru.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.presentation.core.authors.IAuthorsCore
import com.beardness.yourchordsru.presentation.screens.dto.authorsCoreDtoToViewDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val authorsCore: IAuthorsCore,
): ViewModel(), IHomeScreenViewModel {

    override val authors =
        authorsCore
            .authors
            .map { author ->
                author
                    .authorsCoreDtoToViewDto()
                    .sortedBy { authorViewDto -> authorViewDto.name }
            }
}