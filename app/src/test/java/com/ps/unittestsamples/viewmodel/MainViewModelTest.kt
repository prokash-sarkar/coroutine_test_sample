package com.ps.unittestsamples.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ps.unittestsamples.getOrAwaitValue
import com.ps.unittestsamples.ui.main.viewmodel.MainViewModel
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

/**
Created by Prokash Sarkar on Sun, September 19, 2021
Copyright (c) 2021 prokashsarkar.com. All rights reserved.
 **/
class MainViewModelTest {

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Test
    fun testUserData() = runBlockingTest {
        val viewModel = MainViewModel(testDispatcher)
        viewModel.getUserData()
        assertTrue("Wrong session information", viewModel.isSessionValid.getOrAwaitValue())
    }

}