package com.example.wheretotravel.presentation.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.R
import com.example.wheretotravel.domain.functions.SignUp
import com.example.wheretotravel.presentation.MainActivity
import com.example.wheretotravel.presentation.signup.SignUpActivity
import com.example.wheretotravel.presentation.signup.SignUpViewModel
import com.example.wheretotravel.presentation.signup.SignUpViewModelFactory

class SignInActivity : AppCompatActivity() {
    private lateinit var vm: SignInViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val edLogin = findViewById<EditText>(R.id.edLogin)
        val edPassword = findViewById<EditText>(R.id.edPassword)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnAuth = findViewById<Button>(R.id.btn_auth)

        vm = ViewModelProvider(this, SignInViewModelFactory(this))
            .get(SignInViewModel::class.java)

        btnLogin.setOnClickListener {
            if(vm.signIn(edLogin,edPassword, this)) {
                val intent = Intent(this@SignInActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
        btnAuth.setOnClickListener {
            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}