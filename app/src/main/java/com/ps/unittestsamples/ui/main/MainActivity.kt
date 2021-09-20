package com.ps.unittestsamples.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ps.unittestsamples.R
import com.ps.unittestsamples.ui.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var dispatcher: CoroutineDispatcher

    private val viewModel: MainViewModel by viewModels()

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