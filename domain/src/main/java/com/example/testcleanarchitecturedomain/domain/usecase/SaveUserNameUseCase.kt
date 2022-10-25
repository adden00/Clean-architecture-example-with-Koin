package com.example.testcleanarchitecture.domain.usecase

import com.example.testcleanarchitecture.domain.UserRepository
import com.example.testcleanarchitecture.domain.models.SaveUserNameParam

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {

        return userRepository.saveName(param=param)
    }

}