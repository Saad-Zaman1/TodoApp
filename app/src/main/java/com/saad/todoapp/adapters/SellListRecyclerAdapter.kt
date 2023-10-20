package com.saad.todoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saad.todoapp.databinding.SellListViewBinding
import com.saad.todoapp.room.SellListEntity


class MyAdapter(private var data: List<SellListEntity>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: SellListViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SellListEntity) {
            binding.textViewNameValue.text = item.name
            binding.textViewNumberValue.text = item.price
            binding.textViewQuantityValue.text = item.quantity
            binding.textViewTypeValue.text = item.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =
            LayoutInflater.from(parent.context)
        val binding = SellListViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = data[position]
        holder.bind(currentItem)
    }

    fun updateList(list: List<SellListEntity>) {
        data = list
        notifyDataSetChanged()
    }
}