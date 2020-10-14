package com.example.restaurantlist.ui.restaurants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.restaurantlist.R
import com.example.restaurantlist.databinding.ComponentRestaurantBinding
import com.example.restaurantlist.models.Restaurant
import kotlinx.android.synthetic.main.view_model.view.*

//Clase para el funcionamiento del RecyclerView --> VITAL
// Esta clase sera llamada desde el activity para pasarle la lista de Restaurantes sacada de la API
//Creamos el Adapter para crear todas las vistas a raiz de los restaurantes de la API
//Desde el ViewHolder se organiza como se gestiona UNA vista

class RestaurantAdapter(private val RestaurantDataset : List<Restaurant> = ArrayList()) :
    RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {


    class RestaurantViewHolder(private val binding: ComponentRestaurantBinding) : RecyclerView.ViewHolder(binding.root){
       //para llamar al binding creado en layout unicamente se lo pasamos por parametros a esta clase. So ->
        // binding es del tipo DataBinding que nosotros hemos creado, en concreto ComponentRestaurantBinding

        fun inicializar(restaurante: Restaurant){
            //binding.restaurant hace referencia a nuestro layout completo entonces se le puede meter un restaurante y
            // como las variables del layout ya esta puesta para ser rellenadas con la informacion de los restaurantes,
            // con @{}, se autocompletara
            binding.restaurant = restaurante
            binding.restaurantImage.load(restaurante.logoUrl){
                crossfade(true)
            }//Menos el restauranteImage que no esta puesto como los otros

            //binding.locationIcon.onClick()
        }
    }
    //Crea nuevas vistas (controlado por: layoutmanager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ComponentRestaurantBinding>(layoutInflater, R.layout.component_restaurant, parent,
            false)
        return RestaurantViewHolder(binding)
    }
    //Reemplaza el contenido de las vistas (controlado por: layoutmanager)
    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int)  {
        holder.inicializar(RestaurantDataset[position])
    }

    override fun getItemCount(): Int {
        return RestaurantDataset.size
    }
}