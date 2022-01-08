package com.monothon.echofriendly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.monothon.echofriendly.databinding.ActivityMainBinding
import com.monothon.echofriendly.viewmodel.EchoViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this)[EchoViewModel::class.java]
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        subscribeUI()

        binding.testButton.setOnClickListener {
            viewModel.test()
        }
    }

    private fun subscribeUI() {
        viewModel.testString.observe(this) {
            Log.d("ellie", "testString = $it")
        }
    }
}