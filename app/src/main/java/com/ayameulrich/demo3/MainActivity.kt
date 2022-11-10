package com.ayameulrich.demo3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayameulrich.demo3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null
    private val itemsList = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter
    private var count: Int = 0
    
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

        binding!!.AddItemBtn.setOnClickListener() {
            addItem()
        }

        val recyclerView = binding!!.recyclerView
        customAdapter = CustomAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
    }

    private fun addItem() {
        itemsList.add("Item ${count}")
        customAdapter.notifyDataSetChanged()
        count++
    }
}