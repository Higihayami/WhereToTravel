package com.example.wheretotravel.presentation.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.wheretotravel.databinding.ActivitySignInBinding
import com.example.wheretotravel.domain.models.UserSignIn
import com.example.wheretotravel.presentation.MainActivity
import com.example.wheretotravel.presentation.signup.SignUpActivity
import com.example.wheretotravel.presentation.signup.SignUpViewModel
import kotlinx.coroutines.launch

class SignInActivity : AppCompatActivity() {
    private lateinit var vm: SignInViewModel

    lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        vm = ViewModelProvider(this, SignInViewModelFactory(this))
            .get(SignInViewModel::class.java)



        binding.run {
            btnLogin.setOnClickListener {
                if (!(edLogin.text.toString().isEmpty() &&  edPassword.text.toString().isEmpty())) {
                    val param = UserSignIn(
                        login = edLogin.text.toString(),
                        password = edPassword.text.toString())
                    lifecycleScope.launch {
                        if (vm.signIn(param)){
                            val intent = Intent(this@SignInActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                        else
                            Toast.makeText(this@SignInActivity, "Неверные данные", Toast.LENGTH_SHORT).show()
                    }
                }
                else
                    Toast.makeText(this@SignInActivity, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }

            btnAuth.setOnClickListener {
                val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
                startActivity(intent)
            }
        }

    }
}