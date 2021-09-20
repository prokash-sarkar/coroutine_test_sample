package com.ps.unittestsamples.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ps.unittestsamples.R
import com.ps.unittestsamples.ui.main.viewmodel.HelloWorldViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
Created by Prokash Sarkar on Sun, September 19, 2021
Copyright (c) 2021 prokashsarkar.com. All rights reserved.
 **/
@AndroidEntryPoint
class HelloWordFragment : Fragment() {

    @Inject
    lateinit var dispatcher: CoroutineDispatcher

    private val viewModel: HelloWorldViewModel by viewModels()

    lateinit var tvHelloWorld: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.hello_world_fragment, container, false)

        tvHelloWorld = view.findViewById(R.id.text_hello)

        lifecycleScope.launch(dispatcher) {
            // Some IO operations
        }

        viewModel.userData.observe(viewLifecycleOwner, {
            tvHelloWorld.text = it
        })

        viewModel.getUserData()

        return view
    }

}