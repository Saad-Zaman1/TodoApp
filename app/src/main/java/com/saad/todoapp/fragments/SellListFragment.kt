package com.saad.todoapp.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saad.todoapp.R
import com.saad.todoapp.adapters.MyAdapter
import com.saad.todoapp.databinding.BottomSheetLayoutBinding
import com.saad.todoapp.databinding.FragmentSellListBinding
import com.saad.todoapp.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SellListFragment : Fragment() {
    private lateinit var binding: FragmentSellListBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: MyAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sell_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView =
            binding.recyclerView.findViewById<RecyclerView>(R.id.recycle_reuse_layout)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = MyAdapter(emptyList())
        viewModel.getSellItem().observe(viewLifecycleOwner) {
            Log.i("DataFromDB", it.toString())
            adapter.updateList(it)
        }
        recyclerView.adapter = adapter

        binding.fab.setOnClickListener {
            showBottomSheet()
        }
    }

    private fun showBottomSheet() {
        val dialog = Dialog(requireContext())

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val bindingDialog: BottomSheetLayoutBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.bottom_sheet_layout,
            null,
            false
        )
        dialog.setContentView(bindingDialog.root)
        bindingDialog.viewModel = viewModel
        bindingDialog.lifecycleOwner = this

        dialog.show()
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)
    }
}