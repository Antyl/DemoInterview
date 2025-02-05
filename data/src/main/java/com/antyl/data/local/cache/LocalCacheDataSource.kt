package com.antyl.data.local.cache

import com.antyl.data.remote.model.SomethingDTO

internal interface LocalCacheDataSource {
    fun saveSomethingList(data: List<SomethingDTO>)
    fun getSomethingList(): List<SomethingDTO>
    fun getSomething(id: Long): SomethingDTO?
}