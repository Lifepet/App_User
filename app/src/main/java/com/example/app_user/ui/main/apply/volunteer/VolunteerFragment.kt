package com.example.app_user.ui.main.apply.volunteer

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
import com.example.app_user.adapter.VolunteerAdapter
import com.example.app_user.model.VolunteerModel
import com.example.app_user.ui.detail_volunteer.DetailVolunteerActivity
import com.example.app_user.util.RecyclerItemClickListener
import org.jetbrains.anko.find

class VolunteerFragment : Fragment() {

    companion object {
        fun newInstance() = VolunteerFragment()
    }

    private lateinit var viewModel: VolunteerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.volunteer_fragment, container, false) as ViewGroup
        val recycler_Volunteer = layout.find<RecyclerView>(R.id.view_volunteer)
        val volunteerModel = ArrayList<VolunteerModel>()
        recycler_Volunteer.setHasFixedSize(true)
        val volunteerAdapter = VolunteerAdapter(activity!!, volunteerModel)
        recycler_Volunteer.layoutManager = LinearLayoutManager(context)
        recycler_Volunteer.adapter = volunteerAdapter
        volunteerModel.add(VolunteerModel("사랑이 이동봉사 하실분?", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        volunteerModel.add(VolunteerModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        volunteerModel.add(VolunteerModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        volunteerModel.add(VolunteerModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        volunteerModel.add(VolunteerModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        recycler_Volunteer.addOnItemTouchListener(
            RecyclerItemClickListener(context!!, recycler_Volunteer,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        startActivity(Intent(context, DetailVolunteerActivity::class.java))
                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                    }
                })
        )
        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VolunteerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}