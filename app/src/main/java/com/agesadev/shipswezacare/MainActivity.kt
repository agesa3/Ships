package com.agesadev.shipswezacare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.agesadev.shipswezacare.adapters.ShipRecyclerViewAdapter
import com.agesadev.shipswezacare.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: ShipRecyclerViewAdapter
    private lateinit var shipsViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        shipRecyclerview.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = ShipRecyclerViewAdapter()
        shipRecyclerview.adapter = recyclerViewAdapter


    }

    private  fun initViewModel() {
        shipsViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        shipsViewModel.getLiveDataObserver().observe(
            this
        ) { ships ->
            recyclerViewAdapter.setShips(ships!!)
        }
        shipsViewModel.makeApiCall()

    }


}