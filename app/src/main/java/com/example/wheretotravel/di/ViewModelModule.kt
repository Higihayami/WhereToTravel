package com.example.wheretotravel.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.presentation.MainViewModel
import com.example.wheretotravel.presentation.ViewModelFactory
import com.example.wheretotravel.presentation.help.HelpViewModel
import com.example.wheretotravel.presentation.list.ListViewModel
import com.example.wheretotravel.presentation.profile.ProfileViewModel
import com.example.wheretotravel.presentation.rides.RideViewModel
import com.example.wheretotravel.presentation.search.SearchViewModel
import com.example.wheretotravel.presentation.signin.SignInViewModel
import com.example.wheretotravel.presentation.signup.SignUpViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    fun bindSignUpViewModel(
        viewModel: SignUpViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    fun bindSignInViewModel(
        viewModel: SignInViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindSearchViewModel(
        viewModel: SearchViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun bindProfileModel(
        viewModel: ProfileViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    fun bindListViewModel(
        viewModel: ListViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RideViewModel::class)
    fun bindRideViewModel(
        viewModel: RideViewModel
    ): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(HelpViewModel::class)
    fun bindHelpViewModel(
        viewModel: HelpViewModel
    ): ViewModel


}