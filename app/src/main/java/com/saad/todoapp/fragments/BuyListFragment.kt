package com.saad.todoapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saad.todoapp.R
import com.saad.todoapp.adapters.MyAdapter
import com.saad.todoapp.databinding.FragmentBuyListBinding
import com.saad.todoapp.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BuyListFragment : Fragment() {
    private lateinit var binding: FragmentBuyListBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_buy_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MyAdapter(emptyList())
        viewModel.buysData.observe(viewLifecycleOwner) {
            Log.i("DatafromapiBuynew", "$it")
            adapter = MyAdapter(it)
            val recyclerView =
                binding.recyclerViewBuy.findViewById<RecyclerView>(R.id.recycle_reuse_layout)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }

    }

}