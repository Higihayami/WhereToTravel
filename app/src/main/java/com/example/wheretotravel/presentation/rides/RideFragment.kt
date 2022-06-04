package com.example.wheretotravel.presentation.rides

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wheretotravel.databinding.FragmentRideBinding
import com.example.wheretotravel.domain.models.SaveModel
import com.example.wheretotravel.presentation.MainActivity

class RideFragment : Fragment() {

    private val vm: RideViewModel by viewModels {
        (activity as MainActivity).factory
    }
    lateinit var binding: FragmentRideBinding
    private val adapter = FollowAdapter()


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