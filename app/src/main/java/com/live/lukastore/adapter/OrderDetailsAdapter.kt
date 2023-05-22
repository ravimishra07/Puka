package com.live.lukastore.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.live.lukastore.OrderListeners
import com.live.lukastore.databinding.ColorOptionRowItemBinding
import com.live.lukastore.databinding.OrderDetailRowBinding
import com.live.lukastore.databinding.OrderRowBinding
import com.live.lukastore.model.HomeItem
import com.live.lukastore.model.OrderDetailsItem
import com.live.lukastore.util.randomColor
import com.live.lukastore.util.setColoredCard
import com.live.lukastore.util.toPixel
import kotlin.random.Random

class OrderDetailsAdapter(private val items: List<OrderDetailsItem>,val listener: OrderListeners) :
    RecyclerView.Adapter<OrderDetailsAdapter.OrderDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderDetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = OrderDetailRowBinding.inflate(inflater, parent, false)
        return OrderDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderDetailViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class OrderDetailViewHolder(private val binding: OrderDetailRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: OrderDetailsItem) {
            binding.apply {
                tvItemTitle.text = item.itemTitle
                tvItemPrice.text = item.itemPrice
                tvItemQuantity.text = "Qty: ${item.ItemCount}"
            }
        }
    }
}