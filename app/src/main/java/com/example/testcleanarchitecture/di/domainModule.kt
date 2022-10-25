package com.example.testcleanarchitecture.di

import com.example.testcleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.testcleanarchitecture.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}