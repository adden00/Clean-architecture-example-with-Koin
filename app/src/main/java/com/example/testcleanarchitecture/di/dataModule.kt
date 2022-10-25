package com.example.testcleanarchitecture.di

import com.example.testcleanarchitecture.data.repository.UserRepositoryImpl
import com.example.testcleanarchitecture.data.storage.UserStorage
import com.example.testcleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.testcleanarchitecture.domain.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}

