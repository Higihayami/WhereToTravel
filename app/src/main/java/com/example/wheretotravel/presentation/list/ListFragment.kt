package com.example.wheretotravel.presentation.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wheretotravel.R
import com.example.wheretotravel.databinding.FragmentListBinding
import com.example.wheretotravel.presentation.MAIN
import com.example.wheretotravel.presentation.api.response.Trip
import com.example.wheretotravel.presentation.DataModel
import com.example.wheretotravel.presentation.Routes
import com.example.wheretotravel.presentation.profile.ProfileViewModel
import com.example.wheretotravel.presentation.profile.ProfileViewModelFactory
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    private val adapter = RidesAdapter()
    private val dataModel: DataModel by activityViewModels()
    private lateinit var dataBase: DatabaseReference
    private lateinit var vm: ListViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate( layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProvider(this, ListViewModelFactory(this))
            .get(ListViewModel::class.java)

        //получение станции
        dataBase  = Firebase.database.reference
        dataBase.child("routes").get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }






        binding.btnBack.setOnClickListener {
            MAIN.navController.navigate(R.id.action_listFragment_to_navigation_search)
        }
        var rides: List<Trip>
        dataModel.message.observe(activity as LifecycleOwner) {
            rides = it
            init(rides)
        }
    }

    private fun init(rides: List<Trip>){
        binding.apply {

            rcView.layoutManager = LinearLayoutManager(context)
            rcView.adapter = adapter
            adapter.addRides(rides)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}