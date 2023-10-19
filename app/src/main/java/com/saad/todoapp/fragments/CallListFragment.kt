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
import com.saad.todoapp.adapters.CallListRecyclerAdapter
import com.saad.todoapp.databinding.FragmentCallListBinding
import com.saad.todoapp.models.CallModel
import com.saad.todoapp.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CallListFragment : Fragment() {
    private lateinit var binding: FragmentCallListBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var callList: List<CallModel>
    private lateinit var adapter: CallListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_call_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        val recyclerView =
//            binding.recyclerViewCall.findViewById<RecyclerView>(R.id.recycle_reuse_layout)
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        adapter = CallListRecyclerAdapter(emptyList())
//

        viewModel.getCallData().observe(viewLifecycleOwner) {
            if (it.body() != null) {
                Log.i("DatafromApiCall", "${it.body()}")
            }
        }


//        recyclerView.adapter = adapter
    }

}