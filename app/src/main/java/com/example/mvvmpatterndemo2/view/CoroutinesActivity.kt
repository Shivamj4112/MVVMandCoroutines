package com.example.mvvmpatterndemo2.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmpatterndemo2.R
import com.example.mvvmpatterndemo2.databinding.ActivityCoroutinesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class CoroutinesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoroutinesBinding
    private var counter: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCoroutinesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            btStartCounting.setOnClickListener {
                tvCounter.text = (++counter).toString()
            }

            btWithoutCoroutines.setOnClickListener {
                Toast.makeText(this@CoroutinesActivity, "Download Started", Toast.LENGTH_SHORT).show()

                for (i in 1..10000000){
                        Log.d("Demo Testing", "WithoutCoroutines: ----------  $i in ${Thread.currentThread().name}")
                }
                
            }

            btWithCoroutines.setOnClickListener {

                Toast.makeText(this@CoroutinesActivity, "Download Started", Toast.LENGTH_SHORT).show()
                CoroutineScope(Dispatchers.IO).launch {
                    for (i in 1..10000000){
                        Log.d("Demo Testing", "WithoutCoroutines: ----------  $i in ${Thread.currentThread().name}")
//                        tvWithCoroutines.text = "Downloading :- $i"

                    }

                }

            }


        }


    }
}