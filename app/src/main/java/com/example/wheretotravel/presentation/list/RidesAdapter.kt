package com.example.wheretotravel.presentation.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretotravel.R
import com.example.wheretotravel.databinding.RidesItemBinding
import com.example.wheretotravel.domain.models.Category
import com.example.wheretotravel.domain.models.SaveModel
import com.example.wheretotravel.presentation.RoutesNames
import com.example.wheretotravel.presentation.api.response.Trip

class RidesAdapter(val listener: (SaveModel) -> Unit): RecyclerView.Adapter<RidesAdapter.RidesHolder>() {


    var ridesList = emptyList<Trip>()
    lateinit var routes : RoutesNames
    lateinit var category: Category
    class RidesHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = RidesItemBinding.bind(item)
        fun bind(rides: Trip, routes: RoutesNames) = with(binding){

            tvDepartureTime.text = rides.departureTime
            tvArrivalTime.text = rides.arrivalTime
            tvNumTrain.text = rides.trainNumber
            if(rides.firm)
                tvFirm.text = rides.name
            tvDepartureCity.text = routes.departure_name
            tvArrivalCity.text = routes.arrival_name
            tvDepartureDay.text = routes.date
            val day = rides.travelTimeInSeconds.toInt().div(86400)
            val hour: Int
            val minute: Int
            if(day == 0){
                hour = rides.travelTimeInSeconds.toInt().div(3600)
                minute = (rides.travelTimeInSeconds.toInt() - hour * 3600)/60
            }else{
                hour = (rides.travelTimeInSeconds.toInt().mod(86400)).div(3600)
                minute = (rides.travelTimeInSeconds.toInt() - day*86400- hour * 3600)/60
            }
            val time: String = "Д: $day, Ч: $hour, М: $minute"
            tvTraveltime.text = time
            for(i in 0 until rides.categories.size) {
                if (i==0) {
                    tvCategory.text = rides?.categories[i]?.type
                    tvCost.text = rides?.categories[i]?.price.toString()
                }
                if (i==1) {
                    tvCategory2.text = rides?.categories[i]?.type
                    tvCost2.text = rides?.categories[i]?.price.toString()
                }
                if (i==2) {
                    tvCategory3.text = rides?.categories[i]?.type
                    tvCost3.text = rides?.categories[i]?.price.toString()
                }
                if(i==3) {
                    tvCategory4.text = rides?.categories[i].type
                    tvCost4.text = rides?.categories[i].price.toString()
                }
            }

        }
    }

    override fun onViewAttachedToWindow(holder: RidesHolder) {
        super.onViewAttachedToWindow(holder)
        holder.binding.btnSave.setOnClickListener {
            val routeSave = SaveModel(
                arrival_name = routes.arrival_name,
                departure_name = routes.departure_name,
                travel_time = ridesList[holder.adapterPosition].travelTimeInSeconds,
                date = routes.date,
                number_train = ridesList[holder.adapterPosition].trainNumber,
                firm = ridesList[holder.adapterPosition].name,
                firm_bool = ridesList[holder.adapterPosition].firm,
                arrival_time = ridesList[holder.adapterPosition].arrivalTime,
                departure_time = ridesList[holder.adapterPosition].departureTime
            )
            listener(routeSave)
            Log.e("WWW", routeSave.travel_time)
        }
    }

    override fun onViewDetachedFromWindow(holder: RidesHolder) {
        holder.binding.btnSave.setOnClickListener(null)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RidesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rides_item, parent, false)
        return  RidesHolder(view)
    }

    override fun onBindViewHolder(holder: RidesHolder, position: Int) {
        holder.bind(ridesList[position], routes )
    }

    override fun getItemCount(): Int {
        return ridesList.size
    }

    fun addRides(rides: List<Trip>, routes: RoutesNames){
        ridesList = rides
        this.routes = routes
        notifyDataSetChanged()
    }



}