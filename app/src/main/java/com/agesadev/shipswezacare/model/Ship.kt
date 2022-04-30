package com.agesadev.shipswezacare.model

data class Ship(
    val ship_id: String,
    val ship_name: String,
    val ship_type: String,
    val ship_model: String,
    val active: Boolean,
    val weight_kg: Int,
    val image: String,
    val year_built: Int,
    val home_port:String
)
