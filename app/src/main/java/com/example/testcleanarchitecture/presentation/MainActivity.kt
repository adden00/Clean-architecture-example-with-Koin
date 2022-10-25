package com.example.testcleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testcleanarchitecture.data.repository.UserRepositoryImpl
import com.example.testcleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.testcleanarchitecture.databinding.ActivityMainBinding
import com.example.testcleanarchitecture.domain.UserRepository
import com.example.testcleanarchitecture.domain.models.SaveUserNameParam
import com.example.testcleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.testcleanarchitecture.domain.usecase.SaveUserNameUseCase
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.receiveButton.setOnClickListener {
            viewModel.load()

        }

        viewModel.resultLive.observe(this, Observer {
            binding.dataTextView.text = it
        })

        binding.sendButton.setOnClickListener {
            viewModel.save(binding.dataEditText.text.toString())

        }


    }
}