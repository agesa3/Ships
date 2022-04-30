package com.agesadev.shipswezacare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.agesadev.shipswezacare.adapters.ShipRecyclerViewAdapter
import com.agesadev.shipswezacare.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: ShipRecyclerViewAdapter
    private lateinit var shipsViewModel: MainActivityViewModel
    private lateinit var progressBar: ProgressBar
    private lateinit var searchView:SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progressBar)
        searchView=findViewById(R.id.searchView)
        initRecyclerView()
        initViewModel()
        searchShip()
    }

    private fun initRecyclerView() {
        shipRecyclerview.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = ShipRecyclerViewAdapter()
        shipRecyclerview.adapter = recyclerViewAdapter


    }

    private fun initViewModel() {
        shipsViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        shipsViewModel.getLiveDataObserver().observe(
            this
        ) { ships ->
            progressBar.visibility = View.GONE
            recyclerViewAdapter.setShips(ships!!)
        }
        shipsViewModel.makeApiCall()

    }
    private fun searchShip(){
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
    }


}