package com.cso.coffeexp.domain.model

import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class Coffee(
    val id: String = UUID.randomUUID().toString(), // Unique ID
    val name: String = "",
    val method: String = "",
    val grade: Float = 10f, // Assuming a numerical grade
    val imageUrl: String? = null, // Optional image URL
    val notes: String? = null, // Optional tasting notes
)