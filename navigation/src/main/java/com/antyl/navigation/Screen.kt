package com.antyl.navigation

import kotlinx.serialization.Serializable

internal object Screen {

    @Serializable
    object SomethingList

    @Serializable
    data class SomethingDetails(val id: Long)
}