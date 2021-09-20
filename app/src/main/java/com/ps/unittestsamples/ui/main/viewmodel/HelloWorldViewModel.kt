package com.ps.unittestsamples.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

/**
Created by Prokash Sarkar on Sun, September 19, 2021
Copyright (c) 2021 prokashsarkar.com. All rights reserved.
 **/
class HelloWorldViewModel constructor(
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _userData = MutableLiveData<String>()
    val userData: LiveData<String> by lazy { _userData }

    fun getUserData() {
        viewModelScope.launch(dispatcher) {
            _userData.postValue("SOME_TEST_USER_DATA")
        }
    }

}