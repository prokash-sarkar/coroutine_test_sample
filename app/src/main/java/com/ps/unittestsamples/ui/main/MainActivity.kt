package com.ps.unittestsamples.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ps.unittestsamples.R
import com.ps.unittestsamples.ui.main.viewmodel.MainViewModel
import com.ps.unittestsamples.ui.main.viewmodel.MyViewModelFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    private val viewModel: MainViewModel by viewModels {
        MyViewModelFactory(dispatcher)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch(dispatcher) {
            // Some IO operations
        }

        viewModel.isSessionValid.observe(this, {
            Toast.makeText(this, "Session Validity: $it", Toast.LENGTH_SHORT).show()
        })

        viewModel.getUserData()
    }

}