package com.live.lukastore.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.live.lukastore.OrderListeners
import com.live.lukastore.databinding.ColorOptionRowItemBinding
import com.live.lukastore.databinding.OrderRowBinding
import com.live.lukastore.model.HomeItem
import com.live.lukastore.model.OrderItem
import com.live.lukastore.util.formatTimestampToDate
import com.live.lukastore.util.randomColor
import com.live.lukastore.util.setColoredCard
import com.live.lukastore.util.toPixel
import kotlin.random.Random

class OrderAdapter(private val items: List<OrderItem>,val listener: OrderListeners) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = OrderRowBinding.inflate(inflater, parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class OrderViewHolder(private val binding: OrderRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: OrderItem) {
            binding.apply {
                orderId.text = item.orderId.toString()
                dateLabel.text = formatTimestampToDate(item.dateLabel)
                orderStatusLabel.text = item.orderStatus
                itemCountLabel.text =  "Item: ${item.orderItemCount}"
                itemView.setOnClickListener{
                    listener.onItemClicked(layoutPosition)
                }
            }
        }
    }
}