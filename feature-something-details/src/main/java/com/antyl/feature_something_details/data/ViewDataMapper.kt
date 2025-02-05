package com.antyl.feature_something_details.data

import com.antyl.domain.model.Something

internal class ViewDataMapper {

    fun map(data: Something): SomethingDetailsViewData {
        return SomethingDetailsViewData(
            id = data.id,
            name = "It`s ${data.name}",
            currentParam = "Param = ${data.parameter}"
        )
    }
}