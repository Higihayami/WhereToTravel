package com.example.wheretotravel.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretotravel.R
import com.example.wheretotravel.data.repository.RoutesRepositoryImpl
import com.example.wheretotravel.data.storage.RoutesDataBase
import com.example.wheretotravel.data.storage.dao.RoutesDao
import com.example.wheretotravel.databinding.RidesItemBinding
import com.example.wheretotravel.domain.repository.RoutesRepository
import com.example.wheretotravel.domain.usecases.GetRoutesNameUseCase
import com.example.wheretotravel.presentation.api.RidesRepository
import com.example.wheretotravel.presentation.api.response.Trip

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
            if(rides.firm)
                tvFirm.text = rides.name
            //val route = GetRoutesNameUseCase(ROUTES_REPOSITORY).getRoutesName(departure_id = rides.departureStation.toInt(), arrival_id = rides.arrivalStation.toInt())
            //tvArrivalCity.text = route.arrival_name
            //tvDepartureCity.text = route.departure_name
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