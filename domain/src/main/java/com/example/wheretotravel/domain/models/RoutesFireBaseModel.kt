//package com.example.wheretotravel.domain.models


class RoutesFireBaseModel {
    private var arrival_station_id: Int = 0
    private var arrival_station_name: String? = null
    private var departure_station_id: Int = 0
    private var departure_station_name: String? = null


    fun RoutesFromFireBaseModel() {}

    fun RoutesFromFireBaseModel(
        arrival_station_id: Int,
        arrival_station_name: String,
        departure_station_id: Int,
        departure_station_name: String
    ) {
        this.arrival_station_id = arrival_station_id
        this.arrival_station_name = arrival_station_name
        this.departure_station_id = departure_station_id
        this.departure_station_name = departure_station_name
    }

    fun getArrival_Station_Name(): String? {
        return arrival_station_name; }
    fun getArrival_Station_Id(): Int? {
        return arrival_station_id; }
    fun getDeparture_station_name(): String? {
        return departure_station_name; }
    fun getdeparture_station_id(): Int? {
        return departure_station_id; }
}