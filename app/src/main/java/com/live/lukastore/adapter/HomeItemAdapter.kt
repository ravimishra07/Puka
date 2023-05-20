package com.live.lukastore.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.live.lukastore.databinding.ColorOptionRowItemBinding
import com.live.lukastore.model.HomeItem
import com.live.lukastore.util.randomColor
import com.live.lukastore.util.setColoredCard
import com.live.lukastore.util.toPixel
import kotlin.random.Random

class HomeItemAdapter(private val items: List<HomeItem>) :
    RecyclerView.Adapter<HomeItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ColorOptionRowItemBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(private val binding: ColorOptionRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeItem) {
            binding.itemTitle.text = item.title
            val cardView = binding.root.setColoredCard(
                height = 60.toPixel(), cornerRadius = 30f,
                backgroundColor = Color.parseColor(item.backGroundColor)
            )
            binding.root.addView(cardView)
        }
    }
}