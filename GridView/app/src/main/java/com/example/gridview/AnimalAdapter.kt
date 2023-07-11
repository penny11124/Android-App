package com.example.gridview

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AnimalAdapter(
    var context: Context,
    var nameList: ArrayList<String>,
    var imageList: ArrayList<Int>
) : BaseAdapter() {

    //
    override fun getCount(): Int {
        return nameList.size
    }

    //get the data associated with a specify position in the data set
    //not use in this project
    override fun getItem(position: Int): Any? {
        return null
    }

    //get the raw ID associated with a specify position in the list
    //not use in this project
    override fun getItemId(position: Int): Long {
        return 0
    }

    //define special design that
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.custom_layout,parent,false)

        var animalName : TextView = view.findViewById(R.id.textView)
        var animalImage : ImageView = view.findViewById(R.id.imageView)

        animalName.text = nameList[position]
        animalImage.setImageResource(imageList[position])

        return  view
    }

}