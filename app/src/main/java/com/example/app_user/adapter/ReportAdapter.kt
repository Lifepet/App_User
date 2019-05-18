package com.example.app_user.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.app_user.R
import com.example.app_user.databinding.ItemProtectBinding
import com.example.app_user.databinding.ItemReportBinding
import com.example.app_user.model.LostModel
import com.example.app_user.model.ProtectModel
import com.example.app_user.model.ReportModel
import com.example.app_user.ui.main.declaration.report.ReportViewModel
import org.jetbrains.anko.find

class ReportAdapter(val viewModel: ReportViewModel) :
    RecyclerView.Adapter<ReportAdapter.ViewHolder>() {

    var item = arrayListOf<ReportModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = ItemReportBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind()
    }

    override fun getItemCount(): Int = item.size

    inner class ViewHolder(val binding: ItemReportBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.reportModel = item[adapterPosition]
            binding.index = adapterPosition
            binding.vm = viewModel
        }
    }
}