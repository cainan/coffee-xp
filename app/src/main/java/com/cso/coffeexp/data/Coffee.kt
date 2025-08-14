package com.cso.coffeexp.data

data class Coffee(
    val id: String = java.util.UUID.randomUUID().toString(), // Unique ID
    val name: String,
    val method: String,
    val grade: Float, // Assuming a numerical grade
    val imageUrl: String? = null // Optional image URL
)
