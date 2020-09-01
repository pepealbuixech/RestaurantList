package com.example.restaurantlist.models

data class Restaurant(
    val name: String,
    val logoUrl: String?,
    val openingHour: Int,
    val closingHour: Int,
    val location: GeoPoint,
    val category: String,
    val id: Int?
)