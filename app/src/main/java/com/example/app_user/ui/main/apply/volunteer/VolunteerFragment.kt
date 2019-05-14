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
import com.example.app_user.ui.detailVolunteer.DetailVolunteerActivity
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

        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VolunteerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}