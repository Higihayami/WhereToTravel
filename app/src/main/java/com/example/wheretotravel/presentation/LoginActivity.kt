package com.example.wheretotravel.presentation

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wheretotravel.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val edLogin = findViewById<EditText>(R.id.edLogin)
        val edPassword = findViewById<EditText>(R.id.edPassword)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnAuth = findViewById<Button>(R.id.btn_auth)
        mAuth = FirebaseAuth.getInstance();

        btnAuth.setOnClickListener {
            if(!TextUtils.isEmpty(edLogin.text.toString()) && !TextUtils.isEmpty(edPassword.text.toString())){
                mAuth.createUserWithEmailAndPassword(edLogin.text.toString(),edPassword.text.toString()).addOnCompleteListener(this){task ->
                    if (task.isSuccessful)
                        Toast.makeText(this, "succes", Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(this, "not", Toast.LENGTH_SHORT).show()
                }
            }
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

    private fun init(){
        val edLogin = findViewById<EditText>(R.id.edLogin)
        val edPassword = findViewById<EditText>(R.id.edPassword)
        mAuth = FirebaseAuth.getInstance();
    }

    override fun onStart() {
        super.onStart()
        val cUser = mAuth?.currentUser
        if(cUser != null){
            Toast.makeText(this, "User not null", Toast.LENGTH_SHORT)
        }
        else{
            Toast.makeText(this, "User not null", Toast.LENGTH_SHORT)
        }
    }

}