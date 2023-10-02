package com.kiparo.cleancodetest.domain.repository

import com.kiparo.cleancodetest.domain.models.User

interface UserRepositoryInterface {
    fun getUser(): User

    fun saveUser(user: User): Boolean
}