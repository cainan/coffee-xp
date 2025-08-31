package com.cso.coffeexp.data.mapper

import com.cso.coffeexp.data.model.local.CoffeeEntity
import com.cso.coffeexp.domain.model.Coffee

fun CoffeeEntity.toCoffee(): Coffee = Coffee(
    id = id,
    name = name,
    method = method,
    grade = grade,
    imageUrl = imageUrl,
    notes = notes,
)

fun Coffee.toCoffeeEntity(): CoffeeEntity =
    CoffeeEntity(
        id = id,
        name = name,
        method = method,
        grade = grade,
        imageUrl = imageUrl,
        notes = notes,
    )
