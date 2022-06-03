package com.example.wheretotravel.presentation.rides

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wheretotravel.R
import com.example.wheretotravel.app.App
import com.example.wheretotravel.databinding.FragmentRideBinding
import com.example.wheretotravel.domain.models.SaveModel
import com.example.wheretotravel.presentation.api.response.Trip
import com.example.wheretotravel.presentation.list.ListViewModelFactory
import com.example.wheretotravel.presentation.profile.ProfileViewModel
import com.example.wheretotravel.presentation.search.SearchViewModel
import javax.inject.Inject

class RideFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: RideViewModelFactory
    lateinit var binding: FragmentRideBinding
    private val adapter = FollowAdapter()
    private lateinit var vm: RideViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRideBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireContext().applicationContext as App).appComponent.inject(this)

        vm = ViewModelProvider(this, viewModelFactory)[RideViewModel::class.java]

        val rides = vm.getTable()
        init(rides)
    }

    private fun init(rides: List<SaveModel>) {
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(context)
            rcView.adapter = adapter
            adapter.addFollow(rides)

        }
    }


    companion object {

        @JvmStatic
        fun newInstance() = RideFragment()
    }
}