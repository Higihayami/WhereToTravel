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
import com.example.wheretotravel.app.App
import com.example.wheretotravel.databinding.FragmentListBinding
import com.example.wheretotravel.domain.usecases.GetRoutesNameUseCase
import com.example.wheretotravel.presentation.MAIN
import com.example.wheretotravel.presentation.api.response.Trip
import com.example.wheretotravel.presentation.DataModel
import com.example.wheretotravel.presentation.ROUTES_REPOSITORY
import com.example.wheretotravel.presentation.RoutesNames
import com.example.wheretotravel.presentation.search.SearchViewModelFactory
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class ListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ListViewModelFactory
    lateinit var binding: FragmentListBinding
    private val adapter = RidesAdapter()
    private val dataModel: DataModel by activityViewModels()
    private lateinit var dataBase: DatabaseReference
    private lateinit var vm: ListViewModel
    lateinit var currentRoutes: RoutesNames



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        currentRoutes = arguments?.getSerializable("Arg") as RoutesNames
        binding = FragmentListBinding.inflate( layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (MAIN.applicationContext as App).appComponent.inject(this)

        vm = ViewModelProvider(this, viewModelFactory)[ListViewModel::class.java]

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
            val routes = vm.getRoutesId(arrival_id = rides[0].arrivalStation.toInt() , departure_id = rides[0].departureStation.toInt())

            rcView.layoutManager = LinearLayoutManager(context)
            rcView.adapter = adapter
            adapter.addRides(rides, currentRoutes)

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}