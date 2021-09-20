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
class MainViewModel constructor(
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _isSessionValid = MutableLiveData<Boolean>()
    val isSessionValid: LiveData<Boolean> by lazy { _isSessionValid }

    fun getUserData() {
        viewModelScope.launch(dispatcher) {
            _isSessionValid.postValue(true)
        }
    }

}