package com.example.testcleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testcleanarchitecture.data.repository.UserRepositoryImpl
import com.example.testcleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.testcleanarchitecture.domain.models.SaveUserNameParam
import com.example.testcleanarchitecture.domain.models.UserName
import com.example.testcleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.testcleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel(private val getUserNameUseCase: GetUserNameUseCase, private val saveUserNameUseCase: SaveUserNameUseCase): ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable


    init{

    }



    override fun onCleared() {
        super.onCleared()
    }

    fun load(){
        val userName =  getUserNameUseCase.execute()
        resultLiveMutable.postValue("${userName.firstName} ${userName.lastName}")

    }

    fun save(text: String) {
        val params = SaveUserNameParam(name=text)
        resultLiveMutable.postValue("save results = ${saveUserNameUseCase.execute(param=params)}")

    }

}