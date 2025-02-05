package com.antyl.data.remote.source

import com.antyl.data.remote.model.SomethingDTO
import com.antyl.core.utils.NetworkResult
import kotlinx.coroutines.delay
import kotlin.random.Random

internal class RemoteDataSourceImpl: RemoteDataSource {

    override suspend fun getSomething(): NetworkResult<List<SomethingDTO>> {
        delay(1000)
        return NetworkResult.Success(
            listOf(
                SomethingDTO(id = 0, name = "one", param = Random.nextInt(from = 0, until = 1000)),
                SomethingDTO(id = 1, name = "two", param = Random.nextInt(from = 0, until = 1000)),
                SomethingDTO(id = 2, name = "three", param = Random.nextInt(from = 0, until = 1000)),
                SomethingDTO(id = 3, name = "four", param = Random.nextInt(from = 0, until = 1000)),
                SomethingDTO(id = 4, name = "five", param = Random.nextInt(from = 0, until = 1000)),
                SomethingDTO(id = 5, name = "six", param = Random.nextInt(from = 0, until = 1000)),
                SomethingDTO(id = 6, name = "seven", param = Random.nextInt(from = 0, until = 1000)),
                SomethingDTO(id = 7, name = "eight", param = Random.nextInt(from = 0, until = 1000)),
                SomethingDTO(id = 8, name = "nine", param = Random.nextInt(from = 0, until = 1000)),
            )
        )
    }
}