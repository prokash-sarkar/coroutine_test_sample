package com.ps.unittestsamples.suite

import com.ps.unittestsamples.viewmodel.HelloWorldViewModelTest
import com.ps.unittestsamples.viewmodel.MainViewModelTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
Created by Prokash Sarkar on Mon, September 20, 2021
Copyright (c) 2021 prokashsarkar.com. All rights reserved.
 **/
@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainViewModelTest::class,
    HelloWorldViewModelTest::class
)
class ViewModelTestSuite