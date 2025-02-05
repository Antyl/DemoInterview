package com.antyl.data.remote.source

import com.antyl.data.remote.model.SomethingDTO
import com.antyl.core.utils.NetworkResult

internal interface RemoteDataSource {

    suspend fun getSomething(): NetworkResult<List<SomethingDTO>>
}