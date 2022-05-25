package com.example.wheretotravel.presentation.help

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.R
import com.example.wheretotravel.presentation.list.ListViewModel
import com.example.wheretotravel.presentation.list.ListViewModelFactory
import com.example.wheretotravel.presentation.profile.ProfileViewModel

class HelpFragment : Fragment() {

    private lateinit var vm: HelpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProvider(this, HelpViewModelFactory(this))
            .get(HelpViewModel::class.java)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HelpFragment()
    }
}