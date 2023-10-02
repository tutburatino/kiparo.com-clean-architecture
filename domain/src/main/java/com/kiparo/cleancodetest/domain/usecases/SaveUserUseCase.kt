package com.kiparo.cleancodetest.domain.usecases

import com.kiparo.cleancodetest.domain.models.User
import com.kiparo.cleancodetest.domain.repository.UserRepositoryInterface

class SaveUserUseCase(private val userRepository: UserRepositoryInterface) {

    fun execute (user: User): Boolean {
        var result: Boolean = userRepository.saveUser(user)
        return result
    }
}