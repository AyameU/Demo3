package com.ayameulrich.demo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayameulrich.demo3.databinding.ActivityCardViewBinding

class CardViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardViewBinding
    private lateinit var cardViewAdapter: CardViewAdapter
    private var cardList: MutableList<Card> = mutableListOf<Card>()
    private var counter: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.AddCardBtn.setOnClickListener() {
            addCard()
        }

        binding.MainActivityBtn.setOnClickListener {
            startActivity(Intent(this@CardViewActivity, MainActivity::class.java))
        }

        val recyclerView = binding.recyclerView
        cardViewAdapter = CardViewAdapter(this@CardViewActivity, cardList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = cardViewAdapter
    }

    private fun addCard() {
        val card = Card (
            "Card Name ${counter}",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            R.drawable.lucacalderoneunsplash
        )
        cardList.add(card)
        cardViewAdapter.notifyDataSetChanged()
        counter++
    }
}