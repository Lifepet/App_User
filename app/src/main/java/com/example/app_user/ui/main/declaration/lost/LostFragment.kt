package com.example.app_user.ui.main.declaration.lost

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
import com.example.app_user.adapter.LostAdapter
import com.example.app_user.model.LostModel
import com.example.app_user.ui.detailLost.DetailLostActivity
import com.example.app_user.util.RecyclerItemClickListener
import org.jetbrains.anko.find

class LostFragment : Fragment() {

    companion object {
        fun newInstance() = LostFragment()
    }

    private lateinit var viewModel: LostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.lost_fragment, container, false) as ViewGroup
        val recycler_Lost = layout.find<RecyclerView>(R.id.view_lost)
        val lostModel = ArrayList<LostModel>()
        recycler_Lost.setHasFixedSize(true)
        val lostAdapter = LostAdapter(activity!!, lostModel)
        recycler_Lost.layoutManager = LinearLayoutManager(context)
        recycler_Lost.adapter = lostAdapter
        lostModel.add(LostModel("사랑이 잃어버렸어영 ㅜㅜㅜㅜ", "장소: 죽동","사랑이 입양해주실분 구해요~~", "손예섬", "2019/4/15"))
        lostModel.add(LostModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "손예섬", "2019/4/15"))
        lostModel.add(LostModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "손예섬", "2019/4/15"))
        lostModel.add(LostModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "손예섬", "2019/4/15"))
        lostModel.add(LostModel("사랑이를 키워주세요", "봉사날:그러게","사랑이 입양해주실분 구해요~~", "손예섬", "2019/4/15"))
        recycler_Lost.addOnItemTouchListener(
            RecyclerItemClickListener(context!!, recycler_Lost,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        startActivity(Intent(context, DetailLostActivity::class.java))
                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                    }
                })
        )
        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LostViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
