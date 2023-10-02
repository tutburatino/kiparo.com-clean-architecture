package com.kiparo.cleancodetest.data.repository

import android.util.Log
import com.kiparo.cleancodetest.data.UserStorage
import com.kiparo.cleancodetest.data.storage.models.UserData
import com.kiparo.cleancodetest.domain.models.User
import com.kiparo.cleancodetest.domain.repository.UserRepositoryInterface

class UserRepositoryImplementation(private val userStorage: UserStorage): UserRepositoryInterface {
    override fun saveUser(user: User): Boolean {
        Log.d("myLog", "UserRepositoryImplementation.saveUser()`")
        val userData = UserData(firstname = user.firstname, lastname = user.lastname)
        return userStorage.save(userData)
    }

    override fun getUser(): User {
        Log.d("myLog", "UserRepositoryImplementation.getUser()`")
        val userData = userStorage.get()
        return User(firstname = userData.firstname, lastname = userData.lastname)
    }
}