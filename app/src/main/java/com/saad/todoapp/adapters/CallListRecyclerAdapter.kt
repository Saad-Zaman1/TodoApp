package com.saad.todoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saad.todoapp.R
import com.saad.todoapp.models.CallModel


class CallListRecyclerAdapter(private var data: List<CallModel>) :
    RecyclerView.Adapter<CallListRecyclerAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNameValue: TextView = itemView.findViewById(R.id.textViewNameValue)
        val textViewNumberValue: TextView = itemView.findViewById(R.id.textViewNumberValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.call_list_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = data[position]

        holder.textViewNameValue.text = currentItem.name
        holder.textViewNumberValue.text = currentItem.number

    }

    override fun getItemCount(): Int {

        return data.size
    }

    fun updateList(list: List<CallModel>) {
        data = list
        notifyDataSetChanged()
//        Log.i("DataFromApiRecycler", "${data.size}")
//        Handler(Looper.getMainLooper()).post {
//            notifyDataSetChanged()
//        }

    }
}