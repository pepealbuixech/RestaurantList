package com.example.restaurantlist

fun formatOpeningHours(openingHour: Int, closingHour: Int) : String{
    val ini =  String.format("00:00", openingHour)
    val close = String.format("00:00", closingHour)
    return "$ini - $close"
}