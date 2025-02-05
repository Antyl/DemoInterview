package com.antyl.data.local.cache

import com.antyl.data.remote.model.SomethingDTO
import java.util.Collections
import java.util.concurrent.CopyOnWriteArrayList

internal class LocalCacheDataSourceImpl: LocalCacheDataSource {

    private val somethingData = CopyOnWriteArrayList<SomethingDTO>(emptyList())

    @Synchronized
    override fun saveSomethingList(data: List<SomethingDTO>) {
        somethingData.clear()
        somethingData.addAll(data)
    }

    override fun getSomethingList(): List<SomethingDTO> {
        return somethingData
    }

    override fun getSomething(id: Long): SomethingDTO? {
        return somethingData.first { it.id == id }
    }
}