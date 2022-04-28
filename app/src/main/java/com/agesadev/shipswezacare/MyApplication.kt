package com.agesadev.shipswezacare

import android.app.Application
import com.agesadev.shipswezacare.di.DaggerRetrofitComponent
import com.agesadev.shipswezacare.di.RetrofitComponent
import com.agesadev.shipswezacare.di.RetrofitModule

class MyApplication : Application() {
    private lateinit var retroComponent: RetrofitComponent

    override fun onCreate() {
        super.onCreate()
        retroComponent = DaggerRetrofitComponent.builder().retrofitModule(RetrofitModule()).build()
    }

    fun getRetroComponent(): RetrofitComponent {
        return retroComponent
    }
}