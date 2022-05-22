package com.example.wheretotravel.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretotravel.R
import com.example.wheretotravel.databinding.RidesItemBinding
import com.example.wheretotravel.presentation.api.Rides

class RidesAdapter: RecyclerView.Adapter<RidesAdapter.RidesHolder>() {

    val ridesList = ArrayList<Rides>()
    class RidesHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = RidesItemBinding.bind(item)
        fun bind(rides: Rides) = with(binding){
            tvDepartureTime.text = rides.departureTime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RidesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rides_item, parent, false)
        return  RidesHolder(view)
    }

    override fun onBindViewHolder(holder: RidesHolder, position: Int) {
        holder.bind(ridesList[position])
    }

    override fun getItemCount(): Int {
        return ridesList.size
    }

    fun addRides(rides: Rides){
        ridesList.add(rides)
        notifyDataSetChanged()
    }
}