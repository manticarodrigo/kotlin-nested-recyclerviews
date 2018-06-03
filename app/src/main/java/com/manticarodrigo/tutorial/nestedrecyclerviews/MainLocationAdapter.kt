package com.manticarodrigo.tutorial.nestedrecyclerviews

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainLocationAdapter(val locationList: ArrayList<HashMap<String, String>>): RecyclerView.Adapter<MainLocationAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: MainLocationAdapter.ViewHolder, position: Int) {
        val location = locationList[position]
        holder.locationName?.text = location.get("name")
        holder.locationAddress?.text = location.get("address")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainLocationAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_locations, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return locationList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val locationName = itemView.findViewById<TextView>(R.id.locationName)
        val locationAddress = itemView.findViewById<TextView>(R.id.locationAddress)
    }

}