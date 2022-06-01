package com.example.wheretotravel.presentation.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.wheretotravel.R
import com.example.wheretotravel.app.App
import com.example.wheretotravel.databinding.FragmentSearchBinding
import com.example.wheretotravel.presentation.DataModel
import com.example.wheretotravel.presentation.MAIN
import com.example.wheretotravel.presentation.RoutesNames
import com.example.wheretotravel.presentation.api.RidesRepository
import com.example.wheretotravel.presentation.api.response.RidesResponseJson
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class SearchFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: SearchViewModelFactory
    private lateinit var vm: SearchViewModel
    lateinit var binding: FragmentSearchBinding
    lateinit var repository: RidesRepository
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireContext().applicationContext as App).appComponent.inject(this)
        repository = RidesRepository()


        vm = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]

        //vm.getRoutes()

        //lifecycleScope.launch{
        //    val routes =
        //    Log.e("BBB", routes.departure_name + "    " + routes.departure_id)
        //    if (routes.departure_name == null)
        //
        //}
        //lifecycleScope.launch {
        //    val route = vm.getRoutesName("Казань", "Тюмень")
        //    if (route?.departure_name == null) {
        //        vm.getRoutes()
        //    }
        //}

        binding.btnSearch.setOnClickListener {
            val bundle =  Bundle()
            val where = binding.edWhere.text.toString()
            val whence = binding.edWhence.text.toString()
            val date = binding.edDate.text.toString()
            lifecycleScope.launch {

                val route = vm.getRoutesName(whence, where)
                if (route == null) {
                    withContext(lifecycleScope.coroutineContext) {
                        Toast.makeText(requireContext(), "Неверные данные", Toast.LENGTH_LONG)
                            .show()
                    }
                } else {
                    try {
                        val response =
                            repository.getRides(
                                route?.arrival_id.toString(), route.departure_id.toString(),
                                date
                            ).trips
                        Log.e("HIH", response[0].arrivalTime)
                        dataModel.message.value = response
                        val routeName = RoutesNames(
                            arrival_name = where,
                            departure_name = whence,
                            date = date
                        )
                        bundle.putSerializable("Arg", routeName)
                        findNavController().navigate(R.id.action_navigation_search_to_listFragment, bundle)
                    }
                    catch (ex:Exception){
                        Toast.makeText(requireContext(), "Таких маршрутов нет :(", Toast.LENGTH_LONG)
                            .show()
                    }

                }
            }
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}