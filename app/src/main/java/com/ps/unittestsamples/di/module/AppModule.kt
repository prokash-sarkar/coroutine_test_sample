package com.ps.unittestsamples.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/**
Created by Prokash Sarkar on Sun, September 19, 2021
Copyright (c) 2021 prokashsarkar.com. All rights reserved.
 **/

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Singleton
    @Provides
    internal fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO

}