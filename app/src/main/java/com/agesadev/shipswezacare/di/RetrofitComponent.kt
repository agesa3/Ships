package com.agesadev.shipswezacare.di

import com.agesadev.shipswezacare.viewmodel.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [RetrofitModule::class])

interface RetrofitComponent {
    fun inject(mainActivityViewModel: MainActivityViewModel)
}