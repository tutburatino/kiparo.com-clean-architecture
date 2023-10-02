package com.kiparo.cleancodetest.domain.usecases

import com.kiparo.cleancodetest.domain.models.User
import com.kiparo.cleancodetest.domain.repository.UserRepositoryInterface

class GetUserUseCase (private val userRepository: UserRepositoryInterface) {

    fun execute(): User {
        println("myLog GetUserUseCase.execute()")
        return userRepository.getUser()
    }
}