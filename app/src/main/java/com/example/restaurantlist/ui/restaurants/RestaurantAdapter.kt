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

class RestaurantAdapter(private val RestaurantDataset: ArrayList<Restaurant> = ArrayList()) :
    RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {


    class RestaurantViewHolder(private val binding: ComponentRestaurantBinding) : RecyclerView.ViewHolder(binding.root){
       // lateinit var restaurant: Restaurant

        fun inicializar(restaurante: Restaurant){
            binding.restaurant = restaurante
            binding.restaurantImage.load(restaurante.logoUrl){
                crossfade(true)
            }
        }
    }
    //Crea nuevas vistas (controlado por: layoutmanager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        //LayoutInflater.from(parent.context).inflate(R.layout.component_restaurant, parent, false)
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ComponentRestaurantBinding>(layoutInflater, R.layout.component_restaurant, parent,
            false)
        return RestaurantViewHolder(binding)
    }
    //Reemplaza el contenido de las vistas (controlado por: layoutmanager)
    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
       // holder.itemView.restaurant_name.text = RestaurantDataset[position].name
        holder.inicializar(RestaurantDataset[position])
    }

    override fun getItemCount(): Int {
        return RestaurantDataset.size
    }
}