package com.saad.todoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saad.todoapp.databinding.CallListViewBinding
import com.saad.todoapp.models.CallModel


class CallListRecyclerAdapter(private val callList: List<CallModel>) :
    RecyclerView.Adapter<CallListRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: CallListViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CallModel) {
            binding.textViewNameValue.text = item.name
            binding.textViewNumberValue.text = item.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CallListViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return callList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = callList[position]
        val callList = CallModel(item.id, item.name, item.number)
        holder.bind(callList)
    }

}
