package com.example.restaurantlist.data

import com.example.restaurantlist.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Esta clase sirve para crear una instancia de ApiService con los datos del cliente creado. Y la instancia de ApiService sera
// utilizada en Modules para crear un objeto RestaurantViewModel

//Se crea un cliente y se crea una variable INSTANCE donde metemos un tipo ApiService con los datos de nuestra url

object ApiClient {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder =
                    original.newBuilder()
                        .method(original.method(), original.body())


            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    val INSTANCE: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://arcane-atoll-67184.herokuapp.com/api/")//BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        retrofit.create(ApiService::class.java)
    }
}



