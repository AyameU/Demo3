package com.ayameulrich.demo3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayameulrich.demo3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Start layoutInflating.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // Application code starts here
        binding!!.tvTextView.text = "Hello! Welcome to layout inflation"

        binding!!.btnBtn.setOnClickListener() {
            binding!!.tvTextView.text = "you pressed the Hello button! Hi!"
        }

    }
}