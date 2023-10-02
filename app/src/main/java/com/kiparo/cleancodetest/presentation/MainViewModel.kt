package com.kiparo.cleancodetest.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kiparo.cleancodetest.domain.models.User
import com.kiparo.cleancodetest.domain.usecases.GetUserUseCase
import com.kiparo.cleancodetest.domain.usecases.SaveUserUseCase

class MainViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase,
): ViewModel() {

    private var liveResultMutable = MutableLiveData<String>()
    val liveResult: LiveData<String> = liveResultMutable

    init {
        Log.d("myLog", "VM created - создана")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("myLog", "VM cleared - уничтожена")
    }

    fun save(firstname: String, lastname: String) {
        Log.d("myLog", "save()")
        val user = User(firstname, lastname)
        saveUserUseCase.execute(user)
        liveResultMutable.value = "$firstname $lastname"
    }

    fun load() {
        Log.d("myLog", "load()")
        val user: User = getUserUseCase.execute()
        liveResultMutable.value = user.firstname + " " + user.lastname
    }
}