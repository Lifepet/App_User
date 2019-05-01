package com.example.app_user.ui.main.declaration.report

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.app_user.R
import com.example.app_user.adapter.ReportAdapter
import com.example.app_user.model.ReportModel
import com.example.app_user.ui.detail_report.DetailReportActivity
import com.example.app_user.util.RecyclerItemClickListener
import org.jetbrains.anko.find

class ReportFragment : Fragment() {

    companion object {
        fun newInstance() = ReportFragment()
    }

    private lateinit var viewModel: ReportViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.report_fragment, container, false) as ViewGroup
        val recycler_Report = layout.find<RecyclerView>(R.id.view_report)
        val reportModel = ArrayList<ReportModel>()
        recycler_Report.setHasFixedSize(true)
        val reportAdapter = ReportAdapter(activity!!, reportModel)
        recycler_Report.layoutManager = LinearLayoutManager(context)
        recycler_Report.adapter = reportAdapter
        reportModel.add(ReportModel("여기 개 한마리가 있어영", "장소: 신설동","사랑이 입양해주실분 구해요~~", "손예섬", "2019/4/15"))
        reportModel.add(ReportModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "손예섬", "2019/4/15"))
        reportModel.add(ReportModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "손예섬", "2019/4/15"))
        reportModel.add(ReportModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "손예섬", "2019/4/15"))
        reportModel.add(ReportModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "손예섬", "2019/4/15"))
        recycler_Report.addOnItemTouchListener(
            RecyclerItemClickListener(context!!, recycler_Report,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        startActivity(Intent(context, DetailReportActivity::class.java))
                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                    }
                })
        )
        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ReportViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
