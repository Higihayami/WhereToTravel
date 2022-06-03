package com.example.wheretotravel.presentation.rides

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretotravel.R
import com.example.wheretotravel.databinding.FollowItemBinding
import com.example.wheretotravel.domain.models.SaveModel

class FollowAdapter:RecyclerView.Adapter<FollowAdapter.FollowHolder>() {

    var followList = emptyList<SaveModel>()
    class FollowHolder(item: View):RecyclerView.ViewHolder(item){
        val binding = FollowItemBinding.bind(item)
        fun bind(follow: SaveModel) = with(binding){
            tvDepartureTime.text = follow.departure_time
            tvArrivalTime.text = follow.arrival_time
            tvNumTrain.text = follow.number_train
            if(follow.firm_bool)
                tvFirm.text = follow.firm
            tvDepartureCity.text = follow.departure_name
            tvArrivalCity.text = follow.arrival_name
            tvDepartureDay.text = follow.date
            val day = follow.travel_time.toInt().div(86400)
            val hour: Int
            val minute: Int
            if(day == 0){
                hour = follow.travel_time.toInt().div(3600)
                minute = (follow.travel_time.toInt() - hour * 3600)/60
            }else{
                hour = (follow.travel_time.toInt().mod(86400)).div(3600)
                minute = (follow.travel_time.toInt() - day*86400- hour * 3600)/60
            }
            val time: String = "Д: $day, Ч: $hour, М: $minute"
            tvTraveltime.text = time
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowAdapter.FollowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.follow_item, parent, false)
        return FollowHolder(view)
    }

    override fun onBindViewHolder(holder: FollowHolder, position: Int) {
        holder.bind(followList[position])
    }

    override fun getItemCount(): Int {
        return followList.size
    }

    fun addFollow(rides: List<SaveModel>){
        followList = rides
        notifyDataSetChanged()
    }
}