package com.sanjoo.todoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sanjoo.todoapplication.data.ItemInfoModel

class UIListed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uilisted)

        val rvHorizontal=findViewById<RecyclerView>(R.id.rv_horizontal)
        rvHorizontal.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val infoItem=ArrayList<ItemInfoModel>()

        infoItem.add(ItemInfoModel(R.drawable.software,"123","Todays clicks"))
        infoItem.add(ItemInfoModel(R.drawable.pin,"Ahmedabad","Top Locations"))
        infoItem.add(ItemInfoModel(R.drawable.red_globe,"Instagram","Top search"))


        val adapter=InfoAdapter(infoItem)
        rvHorizontal.adapter=adapter
    }
}