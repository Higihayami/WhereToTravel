package com.example.wheretotravel.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.wheretotravel.R
import com.example.wheretotravel.domain.models.SaveNameParam
import com.example.wheretotravel.domain.models.UserName
import com.example.wheretotravel.domain.usecase.GetUserNameUseCase
import com.example.wheretotravel.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase= SaveUserNameUseCase()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtData = findViewById<TextView>(R.id.txtData)
        val editPutData = findViewById<EditText>(R.id.editPutData)
        val btnGetData = findViewById<Button>(R.id.btnGetData)
        val btnSaveData = findViewById<Button>(R.id.btnSaveData)

        btnGetData.setOnClickListener {
            val text = editPutData.text.toString()
            val params = SaveNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(params)
            txtData.text = "Save result = $result"
        }

        btnSaveData.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            txtData.text ="${userName.firstname} ${userName.lastname}"
        }
    }
}