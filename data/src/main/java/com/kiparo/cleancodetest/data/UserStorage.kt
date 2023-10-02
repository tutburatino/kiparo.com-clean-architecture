package com.kiparo.cleancodetest.data

import com.kiparo.cleancodetest.data.storage.models.UserData

interface UserStorage {
    fun save(userData: UserData): Boolean

    fun get(): UserData
}