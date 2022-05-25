package com.example.wheretotravel.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.wheretotravel.R
import com.example.wheretotravel.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var navController: NavController
    private val dataModel: DataModel by viewModels()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding  = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            MAIN = this

            dataModel.message.observe(this) {}

            val navView:BottomNavigationView = findViewById(R.id.nav_view)

            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            navController = findNavController(R.id.nav_host_fragment)


            navView.setupWithNavController(navController)

        }
}