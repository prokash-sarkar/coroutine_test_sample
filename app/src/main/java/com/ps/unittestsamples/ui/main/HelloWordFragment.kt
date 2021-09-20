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
import com.ps.unittestsamples.ui.main.viewmodel.MyViewModelFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
Created by Prokash Sarkar on Sun, September 19, 2021
Copyright (c) 2021 prokashsarkar.com. All rights reserved.
 **/
class HelloWordFragment : Fragment() {

    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    private val viewModel: HelloWorldViewModel by viewModels {
        MyViewModelFactory(dispatcher)
    }

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