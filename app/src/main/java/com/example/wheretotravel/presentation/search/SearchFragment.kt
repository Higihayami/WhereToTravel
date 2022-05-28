package com.example.wheretotravel.presentation.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.wheretotravel.R
import com.example.wheretotravel.databinding.FragmentSearchBinding
import com.example.wheretotravel.domain.models.RoutesModel
import com.example.wheretotravel.domain.usecases.RoutesUseCase
import com.example.wheretotravel.presentation.MAIN
import com.example.wheretotravel.presentation.api.RidesRepository
import com.example.wheretotravel.presentation.DataModel
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchFragment : Fragment() {

    private lateinit var vm: SearchViewModel
    lateinit var binding: FragmentSearchBinding
    private val repository by lazy {
        RidesRepository()
    }
    private val dataModel: DataModel by activityViewModels()
    private val get = RoutesUseCase()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate( layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this)[SearchViewModel::class.java]
        vm.getRoutes()
        binding.btnSearch.setOnClickListener {
            MAIN.navController.navigate(R.id.action_navigation_search_to_listFragment)
            lifecycleScope.launch {
                try {
                    val where = binding.edWhere.text.toString()
                    val whence = binding.edWhence.text.toString()
                    vm.getRoutesName(departure_name = where, arrival_name = whence).observe(viewLifecycleOwner) { listProduct ->
                        Log.e("roma", listProduct.toString())
                    }
                    val response = repository.getRides(/*route.arrival_id.toString()*/"2064001",/*route.departure_id.toString()*/"2060500" ,"21.07.2022" )
                        Toast.makeText(context, response.trips[1].trainNumber, Toast.LENGTH_LONG).show()
                    dataModel.message.value = response.trips
                }catch(ex:Exception){
                }
            }
        }


    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}