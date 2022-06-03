package com.example.wheretotravel.presentation.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.wheretotravel.databinding.FragmentProfileBinding
import com.example.wheretotravel.domain.models.ProfileModel
import com.example.wheretotravel.domain.usecases.ProfileUseCase
import com.example.wheretotravel.presentation.signup.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private lateinit var profileModelee: ProfileModel
    private lateinit var profile: ProfileUseCase
    private lateinit var dataBase: DatabaseReference
    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var vm: ProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, ProfileViewModelFactory(this))
            .get(ProfileViewModel::class.java)
        val userId = mAuth.currentUser?.uid.toString()
        dataBase  = Firebase.database.reference
        var name :String
        var phone: String
        var email: String
        lifecycleScope.launch{
            name = vm.getName(userId)
            binding.tvName.text =  name
        }
        lifecycleScope.launch{
            phone = vm.getPhone(userId)
            binding.tvPhone.text =  phone
        }
        lifecycleScope.launch{
            email = vm.getEmail(userId)
            binding.tvEmail.text =  email
        }
        lifecycleScope.launch{
            vm.signOut()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}