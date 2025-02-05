package com.antyl.data.repository.mapper

import com.antyl.domain.model.Something
import com.antyl.data.remote.model.SomethingDTO

internal object SomethingMapper {

    fun map(data: SomethingDTO): Something {
        return Something(
            id = data.id,
            name = data.name,
            parameter = data.param,
        )
    }

    fun map(data: List<SomethingDTO>): List<Something> {
        return data.map {
            Something(
                id = it.id,
                name = it.name,
                parameter = it.param,
            )
        }
    }
}