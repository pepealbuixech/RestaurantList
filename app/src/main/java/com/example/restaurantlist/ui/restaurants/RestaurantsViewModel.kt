package com.example.restaurantlist.ui.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restaurantlist.BuildConfig
import com.example.restaurantlist.data.ApiService
import com.example.restaurantlist.models.Restaurant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//creamos una variable para la lista de restaurantes(restaurants) y en el init{} ejecutamos el metodo que implementamos abajo
//donde llamamos a los metodos de la interfaz ApiService, que nos sirven para obtener los datos de la API y meterlos
// en la variable de lista de restaurantes

class RestaurantsViewModel(private val service: ApiService) : ViewModel(){ //Lógica de la app

    //private val service : ApiService
    private val _restaurants = MutableLiveData<MutableList<Restaurant>>()
    val restaurants: LiveData<MutableList<Restaurant>> = _restaurants

    init {

        getRestaurants()
    }

    fun getRestaurants(){

        service.getAllRestaruants().enqueue(object : Callback<List<Restaurant>> {
            override fun onResponse(
                call: Call<List<Restaurant>>,
                response: Response<List<Restaurant>>
            ) {
             _restaurants.value = response.body()?.toMutableList()
            }

            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                t?.printStackTrace()
            }

        })

    }
}