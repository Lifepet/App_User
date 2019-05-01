package com.example.app_user.ui.main.apply.protect

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
import com.example.app_user.adapter.AdoptAdapter
import com.example.app_user.adapter.ProtectAdapter
import com.example.app_user.model.AdoptModel
import com.example.app_user.model.ProtectModel
import com.example.app_user.ui.detail_adopt.AdoptDetailActivity
import com.example.app_user.util.RecyclerItemClickListener
import org.jetbrains.anko.find

class ProtectFragment : Fragment() {

    companion object {
        fun newInstance() = ProtectFragment()
    }

    private lateinit var viewModel: ProtectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.protect_fragment, container, false) as ViewGroup
        val recycler_Protect = layout.find<RecyclerView>(R.id.view_protect)
        val protectModel = ArrayList<ProtectModel>()
        recycler_Protect.setHasFixedSize(true)
        val adoptAdapter = ProtectAdapter(activity!!, protectModel)
        recycler_Protect.layoutManager = LinearLayoutManager(context)
        recycler_Protect.adapter = adoptAdapter
        protectModel.add(ProtectModel("사랑이 임시보호 하실분?", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        protectModel.add(ProtectModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        protectModel.add(ProtectModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        protectModel.add(ProtectModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        protectModel.add(ProtectModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "류수영", "2019/4/15"))
        recycler_Protect.addOnItemTouchListener(
            RecyclerItemClickListener(context!!, recycler_Protect,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        startActivity(Intent(context, AdoptDetailActivity::class.java))
                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                    }
                })
        )
        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProtectViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
