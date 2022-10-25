package com.example.testcleanarchitecture.di

import com.example.testcleanarchitecture.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel>{
        MainViewModel(getUserNameUseCase = get(), saveUserNameUseCase = get())
    }
}