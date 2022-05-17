package com.example.wheretotravel.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wheretotravel.R
import com.example.wheretotravel.databinding.ActivityMainBinding
import com.example.wheretotravel.presentation.main.fragment.HelpFragment
import com.example.wheretotravel.presentation.main.fragment.SearchFragment

//import com.example.wheretotravel.domain.usecase.GetUserNameUseCase
//import com.example.wheretotravel.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding  = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.btnFragHelp.setOnClickListener {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.place_holder, HelpFragment.newInstance())
                    .commit()
            }

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, SearchFragment.newInstance())
                .commit()
        }
}