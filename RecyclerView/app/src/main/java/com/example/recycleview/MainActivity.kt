package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    var countryNameList = ArrayList<String>()
    var details = ArrayList<String>()
    var imageList = ArrayList<Int>()

    lateinit var adapter : ContriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        countryNameList.add("United Kingdom")
        countryNameList.add("Germany")
        countryNameList.add("USA")

        details.add("This is the United Kingdom flag")
        details.add("This is the Germany flag")
        details.add("This is the USA flag")

        imageList.add(R.drawable.uk)
        imageList.add(R.drawable.germany)
        imageList.add(R.drawable.usa)

        adapter = ContriesAdapter(countryNameList,details,imageList,this@MainActivity)
        recyclerView.adapter = adapter
    }
}