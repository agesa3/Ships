package com.agesadev.shipswezacare.di

import com.agesadev.shipswezacare.model.Ship
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServiceInterface {

    //    get all ships
    @GET("ships")
    fun getShips(): Call<List<Ship>>
}