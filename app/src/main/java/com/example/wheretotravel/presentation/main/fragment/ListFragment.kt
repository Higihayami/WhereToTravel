package com.example.wheretotravel.presentation.main.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wheretotravel.R
import com.example.wheretotravel.databinding.FragmentListBinding
import com.example.wheretotravel.databinding.FragmentSearchBinding
import com.example.wheretotravel.presentation.MAIN
import com.example.wheretotravel.presentation.RidesAdapter

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    private val adapter = RidesAdapter()

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

        binding.btnBack.setOnClickListener {
            MAIN.navController.navigate(R.id.action_listFragment_to_navigation_search)
        }

        init()

    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(context)
            rcView.adapter
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}