package com.example.wheretotravel.presentation.signup

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.R
import com.google.firebase.auth.FirebaseAuth


class   SignUpActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var vm: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        Log.e("AAA", "Activity created")

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
            if(!TextUtils.isEmpty(edLogin.text.toString()) && !TextUtils.isEmpty(edPassword.text.toString())) {
                mAuth.signInWithEmailAndPassword(
                    edLogin.text.toString(),
                    edPassword.text.toString()
                ).addOnCompleteListener(this){task ->
                    if (task.isSuccessful)
                        Toast.makeText(this, "succes", Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(this, "not", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}