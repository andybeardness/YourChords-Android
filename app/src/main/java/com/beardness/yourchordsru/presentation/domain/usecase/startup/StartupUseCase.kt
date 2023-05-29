package com.beardness.yourchordsru.presentation.domain.usecase.startup

import com.beardness.yourchordsru.presentation.domain.core.authors.AuthorsCoreProtocol
import javax.inject.Inject

class StartupUseCase @Inject constructor(
    private val authorsCore: AuthorsCoreProtocol,
) : StartupUseCaseProtocol {

    override suspend fun startup() {
        authorsCore.init()
    }
}