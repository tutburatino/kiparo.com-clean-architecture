package com.kiparo.cleancodetest.di

import com.kiparo.cleancodetest.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel <MainViewModel> {
        MainViewModel(saveUserUseCase = get(),
            getUserUseCase = get())
    }
}