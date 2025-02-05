package com.antyl.feature_something_list.data

import com.antyl.domain.model.Something

internal class ViewDataMapper {

    fun map(data: Something): SomethingViewData {
        return SomethingViewData(
            id = data.id,
            name = "It`s ${data.name}",
            currentParam = "Param = ${data.parameter}"
        )
    }

    fun mapList(data: List<Something>): List<SomethingViewData> {
        return data.map { map(it) }
    }
}