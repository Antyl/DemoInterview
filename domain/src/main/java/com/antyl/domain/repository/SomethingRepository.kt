package com.antyl.domain.repository

import com.antyl.domain.model.Something

interface SomethingRepository {
    suspend fun getSomethingList(): Result<List<Something>>
    suspend fun getSomething(id: Long): Result<Something>
}