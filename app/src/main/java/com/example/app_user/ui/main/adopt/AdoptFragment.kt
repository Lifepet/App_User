package com.example.app_user.ui.main.adopt

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.app_user.R
import com.example.app_user.adapter.AdoptAdapter
import com.example.app_user.model.AdoptModel
import com.example.app_user.ui.detail_adopt.DetailAdoptActivity
import com.example.app_user.util.RecyclerItemClickListener
import com.example.app_user.util.getToken
import org.jetbrains.anko.find

class AdoptFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.adopt_fragment, container, false) as ViewGroup
        val recycler_Adopt = layout.find<RecyclerView>(R.id.view_adopt)
        val adoptModel = ArrayList<AdoptModel>()
        recycler_Adopt.setHasFixedSize(true)
        val adoptAdapter = AdoptAdapter(activity!!, adoptModel)
        recycler_Adopt.layoutManager = LinearLayoutManager(context)
        recycler_Adopt.adapter = adoptAdapter
        adoptModel.add(AdoptModel("사랑이를 키워주세요", "사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        adoptModel.add(AdoptModel("사랑이를 키워주세요", "사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        adoptModel.add(AdoptModel("사랑이를 키워주세요", "사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        adoptModel.add(AdoptModel("사랑이를 키워주세요", "사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        adoptModel.add(AdoptModel("사랑이를 키워주세요", "사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        recycler_Adopt.addOnItemTouchListener(
            RecyclerItemClickListener(context!!, recycler_Adopt,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        startActivity(Intent(context, DetailAdoptActivity::class.java))
                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                    }
                })
        )
        return layout
    }


}
