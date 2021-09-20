package com.ps.unittestsamples.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineDispatcher

/**
Created by Prokash Sarkar on Mon, September 20, 2021
Copyright (c) 2021 prokashsarkar.com. All rights reserved.
 **/
class MyViewModelFactory(
    private val dispatcher: CoroutineDispatcher
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(dispatcher) as T
            }
            modelClass.isAssignableFrom(HelloWorldViewModel::class.java) -> {
                HelloWorldViewModel(dispatcher) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}