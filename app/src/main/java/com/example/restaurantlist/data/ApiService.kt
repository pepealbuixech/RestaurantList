package com.example.restaurantlist.data

import com.example.restaurantlist.models.Restaurant
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService { // Metodos Retrofit para el contacto con la API

    @GET("restaurants/")
    fun getAllRestaruants(): Call<List<Restaurant>>

    @GET("restaurants/{id}")//PATH -> para reconocer el parametro
    fun getRestaurantById(@Path("id") id: Int) : Call<Restaurant>

    @POST("restaurant/{id}")
    fun editPostById(@Path("id") id: Int, @Body restaurant: Restaurant?) : Call<Restaurant>

}