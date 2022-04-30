package com.agesadev.shipswezacare.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.agesadev.shipswezacare.R
import com.agesadev.shipswezacare.model.Ship
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.card.MaterialCardView
import org.w3c.dom.Text

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
        private val singleShipCard: MaterialCardView = view.findViewById(R.id.single_ship_card)

        fun bind(ship: Ship) {
            shipName.text = ship.ship_name
//            glide and set place holder when image is null with center crop transform
            Glide.with(itemView.context)
                .load(ship.image)
                .apply(RequestOptions.centerCropTransform())
                .placeholder(R.drawable.ic_launcher_background)
                .into(shipImage)
            singleShipCard.setOnClickListener {
                //display the data on bottom sheet dialog
                val bottomSheet = BottomSheetDialog(itemView.context)
                val view2: View =
                    LayoutInflater.from(itemView.context).inflate(R.layout.ship_bottom_sheet, null)
                val shipImageSheet: ImageView = view2.findViewById(R.id.shipImageSheet)
                val shipNameSheet: TextView = view2.findViewById(R.id.shipNameSheet)
                val shipStatusSheet: TextView = view2.findViewById(R.id.shipStatusSheet)
                val shipYearBuiltSheet: TextView = view2.findViewById(R.id.yearBuilt)
                Glide.with(itemView.context)
                    .load(ship.image)
                    .apply(RequestOptions.centerCropTransform())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(shipImageSheet)
                shipNameSheet.text = ship.ship_name
//                if(ship.active){
//                    shipStatusSheet.text="Active"
//                }
                shipYearBuiltSheet.text = ship.year_built.toString()
                bottomSheet.setContentView(view2)
                bottomSheet.show()
            }

        }
    }
}