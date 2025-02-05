package com.antyl.domain.usecase

import com.antyl.domain.model.Something
import com.antyl.domain.repository.SomethingRepository
import javax.inject.Inject

class GetSomethingDetailsUC @Inject constructor(
    private val somethingRepository: SomethingRepository
) {
    suspend operator fun invoke(id: Long): Result<Something> {
        return somethingRepository.getSomething(id = id)
    }
}