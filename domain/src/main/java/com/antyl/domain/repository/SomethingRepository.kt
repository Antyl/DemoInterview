package com.antyl.domain.repository

import com.antyl.domain.model.Something

interface SomethingRepository {
    suspend fun getSomething(): Result<List<Something>>
}