package com.agesadev.shipswezacare.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.agesadev.shipswezacare.MyApplication
import com.agesadev.shipswezacare.di.RetrofitServiceInterface
import com.agesadev.shipswezacare.model.Ship
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var mService: RetrofitServiceInterface
    private var liveDataList: MutableLiveData<List<Ship>>

    init {
        (application as MyApplication).getRetroComponent().inject(this)
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<Ship>> {
        return liveDataList
    }

    fun makeApiCall() {
        mService.getShips().enqueue(object : retrofit2.Callback<List<Ship>> {
            override fun onFailure(call: retrofit2.Call<List<Ship>>, t: Throwable) {

            }

            override fun onResponse(
                call: retrofit2.Call<List<Ship>>,
                response: retrofit2.Response<List<Ship>>
            ) {
                liveDataList.value = response.body()
            }

        })
    }






}
