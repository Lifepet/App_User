package com.example.app_user.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.app_user.databinding.ItemLostCommentBinding
import com.example.app_user.databinding.ItemReportCommentBinding
import com.example.app_user.model.LostCommentModel
import com.example.app_user.model.ReportCommentModel
import com.example.app_user.ui.detailLost.DetailLostViewModel
import com.example.app_user.ui.detailReport.DetailReportViewModel

class ReportCommentAdapter(val viewModel: DetailReportViewModel) :
    RecyclerView.Adapter<ReportCommentAdapter.ViewHolder>() {

    var item = arrayListOf<ReportCommentModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = ItemReportCommentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind()
    }

    override fun getItemCount(): Int = item.size

    inner class ViewHolder(val binding: ItemReportCommentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.reportCommentModel = item[adapterPosition]
            binding.vm = viewModel
            binding.index = adapterPosition
        }
    }
}