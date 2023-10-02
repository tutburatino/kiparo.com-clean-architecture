package com.kiparo.cleancodetest.data.storage.sharedprefstorage

import android.content.Context
import android.content.SharedPreferences
import com.kiparo.cleancodetest.data.UserStorage
import com.kiparo.cleancodetest.data.storage.models.UserData

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRSTNAME = "firstname"
private const val KEY_LASTNAME = "lastname"

class SharedPrefUserStorage(context: Context): UserStorage {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        SHARED_PREFS_NAME,
        Context.MODE_PRIVATE
    )
    private val defaultValue: String = "unknown"

    override fun save(userData: UserData): Boolean {
        sharedPreferences.edit().putString(KEY_FIRSTNAME, userData.firstname).apply()
        sharedPreferences.edit().putString(KEY_LASTNAME, userData.lastname).apply()

        return userData.firstname.isNotEmpty() && userData.lastname.isNotEmpty()
    }

    override fun get(): UserData {
        val firstname: String = sharedPreferences.getString(KEY_FIRSTNAME, defaultValue) ?: defaultValue
        val lastname: String = sharedPreferences.getString(KEY_LASTNAME, defaultValue) ?: defaultValue

        return UserData(firstname, lastname)
    }
}