package com.example.wheretotravel.domain.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class ProfileModel(val email: String? = null, val phone: String? = null, val name: String? = null)
