package com.example.connectsupabasejc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserModel(
    var id: String? = "",
    @SerialName("updated_at")
    var updatedAt: String? = "",
    var name: String? = "",
    var phone: String? = "",
    var balance: Float? = 0F,
    var rider: Boolean? = false,
    var image: String? = "",
)

