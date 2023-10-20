package com.saad.todoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saad.todoapp.R
import com.saad.todoapp.adapters.CallListRecyclerAdapter
import com.saad.todoapp.databinding.FragmentCallListBinding
import com.saad.todoapp.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CallListFragment : Fragment() {
    private lateinit var binding: FragmentCallListBinding

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: CallListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_call_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.CallsData.observe(viewLifecycleOwner) {
            adapter = CallListRecyclerAdapter(it)
            val recyclerView =
                binding.recyclerViewCall.findViewById<RecyclerView>(R.id.recycle_reuse_layout)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())


        }
    }

}