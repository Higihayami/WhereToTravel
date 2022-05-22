package com.example.wheretotravel.presentation.main.fragment.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.wheretotravel.R
import com.example.wheretotravel.databinding.FragmentSearchBinding
import com.example.wheretotravel.presentation.MAIN
import com.example.wheretotravel.presentation.api.RidesRepository
import com.example.wheretotravel.presentation.api.response.RidesResponseJson
import com.example.wheretotravel.presentation.api.response.Trip
import com.example.wheretotravel.presentation.main.fragment.DataModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchFragment : Fragment() {

    private lateinit var vm: SearchViewModel
    lateinit var binding: FragmentSearchBinding
    private val repository by lazy {
        RidesRepository()
    }
    private val dataModel:DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate( layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("AAA","fragment created")
        vm = ViewModelProvider(this, SearchViewModelFactory(this))
            .get(SearchViewModel::class.java)
        binding.btnSearch.setOnClickListener {
            MAIN.navController.navigate(R.id.action_navigation_search_to_listFragment)
            lifecycleScope.launch {
                try {
                    val response = repository.getRides("2024600","2000003", "21.05.2022" )
                        Toast.makeText(context, response.trips[1].trainNumber, Toast.LENGTH_LONG).show()
                    dataModel.message.value = response.trips
                }catch(ex:Exception){
                    Log.e("asd",ex.message.toString())
                }
            }
        }


    }


    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}