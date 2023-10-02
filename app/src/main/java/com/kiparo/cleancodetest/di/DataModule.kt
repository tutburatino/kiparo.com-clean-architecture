package com.kiparo.cleancodetest.di

import com.kiparo.cleancodetest.data.UserStorage
import com.kiparo.cleancodetest.data.repository.UserRepositoryImplementation
import com.kiparo.cleancodetest.data.storage.sharedprefstorage.SharedPrefUserStorage
import com.kiparo.cleancodetest.domain.repository.UserRepositoryInterface
import org.koin.dsl.module


val dataModule = module {
   single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepositoryInterface> {
        UserRepositoryImplementation(userStorage = get())
    }
}