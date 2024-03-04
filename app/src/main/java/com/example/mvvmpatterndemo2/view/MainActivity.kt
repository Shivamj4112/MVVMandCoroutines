package com.example.mvvmpatterndemo2.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpatterndemo2.R
import com.example.mvvmpatterndemo2.databinding.ActivityMainBinding
import com.example.mvvmpatterndemo2.viewModel.CalculatorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var calculatorViewModel: CalculatorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculatorViewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]

        binding.btSum.setOnClickListener {

            val num1 = binding.etNum1.text.toString().toIntOrNull() ?: 0
            val num2 = binding.etNum1.text.toString().toIntOrNull() ?: 0

            val result = calculatorViewModel.calculateSum(num1, num2)
            binding.tvResult.text = "${result.result}"
        }

        binding.btCoroutines.setOnClickListener {
            startActivity(Intent(this@MainActivity,CoroutinesActivity::class.java))
        }

    }
}