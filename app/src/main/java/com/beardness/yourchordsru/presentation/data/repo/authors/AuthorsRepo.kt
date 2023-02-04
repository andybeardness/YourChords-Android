package com.beardness.yourchordsru.presentation.data.repo.authors

import com.beardness.yourchordsru.presentation.data.datasource.authors.IAuthorsDataSource
import com.beardness.yourchordsru.presentation.data.repo.dto.AuthorRepoDto
import com.beardness.yourchordsru.presentation.data.repo.dto.authorsSourceDtoToRepoDto
import javax.inject.Inject

class AuthorsRepo @Inject constructor(
    private val authorsDataSource: IAuthorsDataSource,
): IAuthorsRepo {

    override suspend fun authors(): List<AuthorRepoDto> {
        return authorsDataSource
            .authors()
            .authorsSourceDtoToRepoDto()
    }
}