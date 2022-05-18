package com.example.wheretotravel.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
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

            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = findNavController(R.id.nav_host_fragment)

            val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_search,
                R.id.navigation_help,
                R.id.navigation_ride,
                R.id.navigation_profile))
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)

            /*supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, SearchFragment.newInstance())
                .commit()*/
        }
}