package com.saad.todoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saad.todoapp.R
import com.saad.todoapp.room.SellListEntity


class MyAdapter(private var data: List<SellListEntity>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNameValue: TextView = itemView.findViewById(R.id.textViewNameValue)
        val textViewPriceValue: TextView = itemView.findViewById(R.id.textViewNumberValue)
        val textViewQuantityValue: TextView = itemView.findViewById(R.id.textViewQuantityValue)
        val textViewTypeValue: TextView = itemView.findViewById(R.id.textViewTypeValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.sell_list_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = data[position]
        holder.textViewNameValue.text = currentItem.name
        holder.textViewPriceValue.text = currentItem.price
        holder.textViewQuantityValue.text = currentItem.quantity
        holder.textViewTypeValue.text = currentItem.type
    }

    override fun getItemCount() = data.size

    fun updateList(list: List<SellListEntity>) {
        data = list
        notifyDataSetChanged()
    }
}