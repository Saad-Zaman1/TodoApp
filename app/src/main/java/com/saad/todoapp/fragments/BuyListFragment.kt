package com.saad.todoapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.saad.todoapp.R
import com.saad.todoapp.databinding.FragmentBuyListBinding
import com.saad.todoapp.room.SellListEntity
import com.saad.todoapp.viewmodels.MainViewModel


class BuyListFragment : Fragment() {
    private lateinit var binding: FragmentBuyListBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var callList: List<SellListEntity>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_buy_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val recyclerView =
//            binding.recyclerViewBuy.findViewById<RecyclerView>(R.id.recycle_reuse_layout)
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        val adapter = MyAdapter(emptyList())


        viewModel.getBuyData().observe(viewLifecycleOwner) {
            if (it.body() != null) {
                Log.i("Datafromlivedata", "${it.body()}")
            }
        }

//        recyclerView.adapter = adapter

    }

}