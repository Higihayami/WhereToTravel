package com.example.wheretotravel.presentation.rides

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.wheretotravel.R
import com.example.wheretotravel.presentation.profile.ProfileViewModel
import com.example.wheretotravel.presentation.search.SearchViewModel

class RideFragment : Fragment() {

    private lateinit var vm: RideViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ride, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, RideViewModelFactory(this ))[RideViewModel::class.java]
    }

    companion object {

        @JvmStatic
        fun newInstance() = RideFragment()
    }
}