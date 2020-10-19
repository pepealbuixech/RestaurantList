package com.example.restaurantlist.ui.restaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantlist.R
import com.example.restaurantlist.data.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


//Conecta con el xml de la pantalla principal
//Creamos un objeto viewModel llamado a traves del Modules con by inject. Con esa instancia observamos el contenido de
// la varaible de RestaurantViewModel donde se almacenan la lista de restaurantes.
//llamamos al objetoi recyclerView del xml para indicarle que utilizaremos un LinearLayoutManager


class RestaurantsActivity : AppCompatActivity() {

private val viewModel by inject<RestaurantsViewModel>()
//private val viewModel: RestaurantsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = RestaurantAdapter(restaurantes ?: listOf())

        viewModel.restaurants.observe(this, Observer
            { recyclerView.adapter = RestaurantAdapter(it ?: listOf())  })
            // Ó ----- {restaurantes -> recyclerView.adapter = RestaurantAdapter(restaurantes ?: listOf())  }


    }


    


}

