package com.mukesh.recylerviewmultipleviewholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //Tutorial I follow: https://medium.com/@loveandroid/recylerview-with-multiple-viewholder-android-80198c5edde3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        val dataItem = ArrayList<DataModel>()

        // data for Header Layout
        dataItem.add(
            DataModel.HeaderData(
                title = "Heading",
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
            )
        )

        // data for Sub Item Layout
        for (i in 1..20) {
            dataItem.add(
                DataModel.ItemsViewModel(
                    name = "PANDIYAN $i", email = "TEST$i@GMAIL.COM"
                )
            )
        }

        val adapter = CustomAdapter(mList = dataItem)
        recyclerview.adapter = adapter
    }
}