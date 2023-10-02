package com.kiparo.cleancodetest.di

import com.kiparo.cleancodetest.domain.usecases.GetUserUseCase
import com.kiparo.cleancodetest.domain.usecases.SaveUserUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<SaveUserUseCase> {
        SaveUserUseCase(userRepository = get())
    }

    factory<GetUserUseCase> {
        GetUserUseCase(userRepository = get())
    }
}