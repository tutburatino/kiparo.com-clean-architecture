package com.kiparo.cleancodetest.presentation

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kiparo.R

import com.kiparo.cleancodetest.domain.usecases.SaveUserUseCase
import com.kiparo.cleancodetest.domain.usecases.GetUserUseCase

import com.kiparo.cleancodetest.data.repository.UserRepositoryImplementation
import com.kiparo.cleancodetest.data.storage.sharedprefstorage.SharedPrefUserStorage

import com.kiparo.cleancodetest.domain.models.User
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity: AppCompatActivity() {

    private val vm: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        Log.d("myLog", "Activity created")

        val userDataView = findViewById<TextView>(R.id.userDataView);
        val getButton = findViewById<Button>(R.id.getButton)

        val firstnameTextField = findViewById<TextView>(R.id.firstnameTextField)
        val lastnameTextField = findViewById<TextView>(R.id.lastnameTextField)
        val saveButton = findViewById<Button>(R.id.saveButton)

        vm.liveResult.observe(this) { text ->
            userDataView.text = text
        }

        saveButton.setOnClickListener {
            Log.d("myLog", "Клик по кнопке `SAVE USER DATA`")
            val firstname = firstnameTextField.text.toString()
            val lastname = lastnameTextField.text.toString()
            vm.save(firstname, lastname)
        }

        getButton.setOnClickListener {
            Log.d("myLog", "Клик по кнопке `GET USER DATA`")
            vm.load()
        }
    }
}