package com.ayameulrich.demo3

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.RecyclerView
import com.ayameulrich.demo3.databinding.CardBinding

internal class CardViewAdapter(var context: Context, private var cardList: MutableList<Card>) :
    RecyclerView.Adapter<CardViewAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(cardBinding: CardBinding) : RecyclerView.ViewHolder(cardBinding.root) {
        private var binding = cardBinding

        fun bind(context: Context, card: Card) {
            binding.cardImage.setImageResource(card.image)
            binding.cardName.text = card.name
            binding.cardDesc.text = card.description
            binding.cardView.setOnClickListener {
                Toast.makeText(
                    context,
                    "You clicked ${card.name}!",
                    Toast.LENGTH_LONG)
                    .show()
            }
            binding.fbIcon.setOnClickListener{
                Toast.makeText(
                    context,
                    "${card.name} Facebook!",
                    Toast.LENGTH_LONG)
                    .show()
            }
            binding.tIcon.setOnClickListener{
                Toast.makeText(
                    context,
                    "${card.name} Twitter!",
                    Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CardBinding.inflate(LayoutInflater
            .from(context), parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val card = cardList[position]
        holder.bind(context, card)
    }
    override fun getItemCount(): Int {
        return cardList.size
    }
}