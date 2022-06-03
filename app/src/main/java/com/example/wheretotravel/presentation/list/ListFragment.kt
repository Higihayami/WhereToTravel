package com.example.wheretotravel.presentation.list

import android.os.Bundle
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
import com.example.wheretotravel.presentation.MAIN
import com.example.wheretotravel.presentation.api.response.Trip
import com.example.wheretotravel.presentation.DataModel
import com.example.wheretotravel.presentation.RoutesNames
import javax.inject.Inject

class ListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ListViewModelFactory
    lateinit var binding: FragmentListBinding
    private val adapter = RidesAdapter(){vm.setRides(it)}
    private val dataModel: DataModel by activityViewModels()
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

        (requireContext().applicationContext as App).appComponent.inject(this)

        vm = ViewModelProvider(this, viewModelFactory)[ListViewModel::class.java]

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
            adapter.addRides(rides, currentRoutes)

        }
    }

    companion object{
        @JvmStatic
        fun newInstance() = ListFragment()

    }

}