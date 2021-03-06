package com.example.wheretotravel.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.wheretotravel.R
import com.example.wheretotravel.app.App
import com.example.wheretotravel.databinding.ActivitySignUpBinding
import com.example.wheretotravel.domain.models.UserSignUp
import com.example.wheretotravel.presentation.MainActivity
import com.example.wheretotravel.presentation.MainViewModel
import com.example.wheretotravel.presentation.ViewModelFactory
import com.example.wheretotravel.presentation.signin.SignInActivity
import com.example.wheretotravel.presentation.signin.SignInViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import javax.inject.Inject


class   SignUpActivity : AppCompatActivity() {


    @Inject
    lateinit var factory: ViewModelFactory

    private val vm: SignUpViewModel by viewModels{
        factory
    }
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        (applicationContext as App).appComponent.inject(this)


        binding.run{
            btnAuth.setOnClickListener {
                if(!(edLogin.text.toString().isEmpty() &&  edPassword.text.toString().isEmpty() && edPhone.text.toString().isEmpty() && edRepeatPassword.text.toString().isEmpty() && edName.text.toString().isEmpty())){
                    val param = UserSignUp(
                        login = edLogin.text.toString(),
                        password = edPassword.text.toString(),
                        phone = edPhone.text.toString(),
                        name = edName.text.toString(),
                        repeatPassword = edRepeatPassword.text.toString())
                    lifecycleScope.launch{
                        if(vm.login(param))
                        {
                            val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                        else
                            Toast.makeText(this@SignUpActivity, "???????????????? ????????????", Toast.LENGTH_SHORT).show()
                    }
                }
                else
                    Toast.makeText(this@SignUpActivity, "?????????????????? ?????? ????????", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
            startActivity(intent)
        }

    }
}