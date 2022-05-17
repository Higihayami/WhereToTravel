package com.example.wheretotravel.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.R
import com.example.wheretotravel.presentation.signin.SignInActivity
import com.google.firebase.auth.FirebaseAuth


class   SignUpActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var vm: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        vm = ViewModelProvider(this, SignUpViewModelFactory(this))
            .get(SignUpViewModel::class.java)

        val edLogin = findViewById<EditText>(R.id.edLogin)
        val edPhone = findViewById<EditText>(R.id.edPhone)
        val edName = findViewById<EditText>(R.id.edName)
        val edPassword = findViewById<EditText>(R.id.edPassword)
        val edRepeatPassword = findViewById<EditText>(R.id.edRepeatPassword)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnAuth = findViewById<Button>(R.id.btn_auth)

        btnAuth.setOnClickListener {
            vm.login(edLogin,edPhone,edName,edPassword,edRepeatPassword, this)
        }

        btnLogin.setOnClickListener {
            val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
            startActivity(intent)
        }

    }
}