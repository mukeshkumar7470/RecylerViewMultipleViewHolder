package com.mukesh.recylerviewmultipleviewholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        val datas = ArrayList<DataModel>()
        // data for Header Layout
        datas.add(
            DataModel.HeaderData(
                title = "Heading",
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
            )
        )

        // data for Sub Item Layout
        for (i in 1..20) {
            datas.add(
                DataModel.ItemsViewModel(
                    name = "PANDIYAN $i", email = "TEST$i@GMAIL.COM"
                )
            )
        }
        datas.add(
            DataModel.HeaderData(
                title = "Mukesh",
                description = "Mukesh  text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
            )
        )

        val adapter = CustomAdapter(mList = datas)

        recyclerview.adapter = adapter
    }
}