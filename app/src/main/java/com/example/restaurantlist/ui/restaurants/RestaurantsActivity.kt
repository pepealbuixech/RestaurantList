package com.example.restaurantlist.ui.restaurants

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.restaurantlist.R
import com.squareup.picasso.Picasso

class RestaurantsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    

    /*@BindingAdapter({"bind:imageURL", "bind:error"})
    fun loadImage(view: ImageView, url: String, error: Drawable){
        Picasso.get()
            .load(url)
            .error(error).into(view)
    }*/

}