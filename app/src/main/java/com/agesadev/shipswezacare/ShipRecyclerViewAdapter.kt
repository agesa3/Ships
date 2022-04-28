package com.agesadev.shipswezacare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.agesadev.shipswezacare.model.Ship
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ShipRecyclerViewAdapter : RecyclerView.Adapter<ShipRecyclerViewAdapter.ShipViewHolder>() {

    private var ships: List<Ship>? = null

    fun setShips(ships: List<Ship>) {
        this.ships = ships
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_ship, parent, false)
        return ShipViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShipViewHolder, position: Int) {
        holder.bind(ships?.get(position) ?: return)


    }

    override fun getItemCount(): Int {
        if (ships == null) return 0
        return ships!!.size
    }


    class ShipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val shipName: TextView = view.findViewById(R.id.shipName)
        private val shipImage: ImageView = view.findViewById(R.id.shipImage)

        fun bind(ship: Ship) {
            shipName.text = ship.ship_name
//            glide and set place holder when image is null with center crop transform
            Glide.with(itemView.context)
                .load(ship.image)
                .apply(RequestOptions.centerCropTransform())
                .placeholder(R.drawable.ic_launcher_background)
                .into(shipImage)

        }
    }
}