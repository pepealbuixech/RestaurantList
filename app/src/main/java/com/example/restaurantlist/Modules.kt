package com.example.restaurantlist

import com.example.restaurantlist.data.ApiClient
import com.example.restaurantlist.data.ApiService
import com.example.restaurantlist.ui.restaurants.RestaurantsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

//@JvmField
val appModule = module {
    single<ApiService> { ApiClient.INSTANCE }

    viewModel { RestaurantsViewModel(get()) }
}