package com.cso.coffeexp.domain.model

import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class Coffee(
    var id: String = UUID.randomUUID().toString(), // Unique ID
    var name: String = "",
    var method: String = "",
    var grade: Float = 10f, // Assuming a numerical grade
    var imageUrl: String? = null, // Optional image URL
    var notes: String? = null, // Optional tasting notes
)