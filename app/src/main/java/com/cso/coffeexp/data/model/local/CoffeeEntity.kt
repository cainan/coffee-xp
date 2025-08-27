package com.cso.coffeexp.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "coffee")
data class CoffeeEntity(
    @PrimaryKey(autoGenerate = true)
    val idDb: Long = 0L,
    val id: String = UUID.randomUUID().toString(), // Unique ID
    val name: String = "",
    val method: String = "",
    val grade: Float = 10f, // Assuming a numerical grade
    val imageUrl: String? = null, // Optional image URL
    val notes: String? = null, // Optional tasting notes
)