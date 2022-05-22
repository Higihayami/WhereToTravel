package com.example.wheretotravel.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretotravel.R
import com.example.wheretotravel.databinding.RidesItemBinding
import com.example.wheretotravel.presentation.api.Rides
import com.example.wheretotravel.presentation.api.response.Trip
import com.example.wheretotravel.presentation.main.fragment.DataModel

class RidesAdapter(): RecyclerView.Adapter<RidesAdapter.RidesHolder>() {

    var ridesList = emptyList<Trip>()
    class RidesHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = RidesItemBinding.bind(item)
        fun bind(rides: Trip) = with(binding){
            tvDepartureTime.text = rides.departureTime
            tvArrivalTime.text = rides.arrivalTime
            tvDepartureCity.text = rides.departureStation
            tvArrivalCity.text = rides.arrivalStation
            tvNumTrain.text = rides.trainNumber
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

    fun addRides(rides: List<Trip>){
        ridesList = rides
        notifyDataSetChanged()
    }
}