package com.antyl.domain.usecase

import com.antyl.domain.model.Something
import com.antyl.domain.repository.SomethingRepository
import javax.inject.Inject

class GetSomethingDomainUseCase @Inject constructor(
    private val somethingRepository: SomethingRepository
) {

    suspend operator fun invoke(): Result<List<Something>> {
        return somethingRepository.getSomething()
    }
}