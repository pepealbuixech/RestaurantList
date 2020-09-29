package com.example.restaurantlist.ui.restaurants

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.restaurantlist.R
import com.example.restaurantlist.databinding.ComponentRestaurantBinding
import com.example.restaurantlist.interfaces.ApiService
import com.example.restaurantlist.models.GeoPoint
import com.example.restaurantlist.models.Restaurant
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RestaurantsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //restaurant_image.load("")

        val ejemplo = Restaurant("casaPepe",
            "https://rockcontent.com/es/wp-content/uploads/2019/02/google-trends-1280x720.png",
            10, 0,
            GeoPoint(2.4,3.5), "estrellaMichelin", 1)
        val restaurants = arrayListOf<Restaurant>(ejemplo, ejemplo, ejemplo, ejemplo, ejemplo)

        recyclerView.adapter = RestaurantAdapter(restaurants)
        recyclerView.layoutManager = LinearLayoutManager(this)

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://arcane-atoll-67184.herokuapp.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

        val service = retrofit.create<ApiService>(ApiService::class.java)

        service.getAllRestaruants().enqueue(object : Callback<List<Restaurant>> {
            override fun onResponse(
                call: Call<List<Restaurant>>,
                response: Response<List<Restaurant>>
            ) {
                val restaurants = response?.body()
                Log.i("name", Gson().toJson(restaurants))
            }

            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                t?.printStackTrace()
            }

        })

    }

    


}

