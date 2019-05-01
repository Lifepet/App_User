package com.example.app_user.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.app_user.R
import com.example.app_user.model.LostModel
import com.example.app_user.model.ReportModel
import org.jetbrains.anko.find

class ReportAdapter(internal var context: Context, internal var reportModel: ArrayList<ReportModel>) :
    RecyclerView.Adapter<ReportAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_declaration, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(reportModel[i])
    }

    override fun getItemCount(): Int {
        return reportModel.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text_Title = itemView.find<TextView>(R.id.text_title)
        val text_Gps=itemView.find<TextView>(R.id.text_gps)
        val text_Content = itemView.find<TextView>(R.id.text_content)
        val text_Date = itemView.find<TextView>(R.id.text_date)
        val text_Writer = itemView.find<TextView>(R.id.text_writer)
        fun bind(reportModel: ReportModel) {
            text_Title.text = reportModel.text_Title
            text_Gps.text=reportModel.text_Gps
            text_Content.text = reportModel.text_Content
            text_Date.text = reportModel.text_Date
            text_Writer.text = reportModel.text_Writer
        }
    }
}