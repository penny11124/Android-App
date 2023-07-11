package com.example.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class ContriesAdapter(
    var countryNameList: ArrayList<String>,
    var details: ArrayList<String>,
    var imageList: ArrayList<Int>,//show Toast Message
    var context: Context
) : RecyclerView.Adapter<ContriesAdapter.CountryViewHolder>() {
    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { //represent card design

        var textViewCountryName : TextView = itemView.findViewById(R.id.textViewCountryName)
        var textViewDetails : TextView = itemView.findViewById(R.id.textViewDetails)
        var imageView : CircleImageView = itemView.findViewById(R.id.imageView)
    }

    //define the card design we have made, determine which design will be displayed in RecyclerView
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContriesAdapter.CountryViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_design,parent,false)
        return CountryViewHolder(view)
    }

    //specify what should be done when the design we created is connected to RecyclerView (show out on the screen)
    override fun onBindViewHolder(holder: ContriesAdapter.CountryViewHolder, position: Int) {
        holder.textViewCountryName.text = countryNameList.get(position)
        holder.textViewDetails.text = details.get(position)
        holder.imageView.setImageResource(imageList.get(position))
    }

    //specify the amount of data that will be displayed in RecyclerView
    override fun getItemCount(): Int {
        return countryNameList.size
    }
}
