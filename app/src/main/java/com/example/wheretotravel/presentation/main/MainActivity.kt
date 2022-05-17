package com.example.wheretotravel.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.wheretotravel.R
import com.example.wheretotravel.databinding.ActivityMainBinding
import com.example.wheretotravel.presentation.main.fragment.HelpFragment
import com.example.wheretotravel.presentation.main.fragment.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

//import com.example.wheretotravel.domain.usecase.GetUserNameUseCase
//import com.example.wheretotravel.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding  = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            val navView:BottomNavigationView = findViewById(R.id.nav_view)

            val navController = findNavController(R.id.nav_host_fragment)
            val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.search_fragment,
                R.id.help_fragment,
                R.id.ride_fragment,
                R.id.profile_fragment))
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)


            /*supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, SearchFragment.newInstance())
                .commit()*/
        }
}