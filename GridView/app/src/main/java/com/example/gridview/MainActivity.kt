package com.example.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var gridView : GridView
    var nameList = ArrayList<String>()
    var imageList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.gridView)
        fillArrays()
        val adapter = AnimalAdapter(this,nameList,imageList)

        gridView.adapter = adapter

        gridView.setOnItemClickListener { adapterView, view, position, id ->
            Toast.makeText(applicationContext,"You selected the ${nameList[position]}",Toast.LENGTH_SHORT).show()
        }
    }

    fun fillArrays() {
        nameList.add("Butterfly")
        nameList.add("Cat")
        nameList.add("Flower")
        nameList.add("Hippo")
        nameList.add("Monkey")
        nameList.add("Mushroom")
        nameList.add("Panda")
        nameList.add("Rabbit")
        nameList.add("Raccoon")

        imageList.add(R.drawable.butterfly)
        imageList.add(R.drawable.cat)
        imageList.add(R.drawable.flower)
        imageList.add(R.drawable.hippo)
        imageList.add(R.drawable.monkey)
        imageList.add(R.drawable.mushroom)
        imageList.add(R.drawable.panda)
        imageList.add(R.drawable.rabbit)
        imageList.add(R.drawable.raccoon)
    }
}