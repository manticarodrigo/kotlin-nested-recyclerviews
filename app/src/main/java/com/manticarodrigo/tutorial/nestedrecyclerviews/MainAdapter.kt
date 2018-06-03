package com.manticarodrigo.tutorial.nestedrecyclerviews

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import java.text.SimpleDateFormat


class MainAdapter(val locationList: ArrayList<HashMap<String, String>>): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    val byDates = locationList.groupBy { it["time"] }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        // Update date label
        val sdf = SimpleDateFormat("MM/dd/yyyy")
        val dateList = byDates.values.toMutableList()
        holder.date?.text = sdf.format(dateList[position][0].get("time")?.toLong())
        // Create vertical Layout Manager
        holder.rv?.layoutManager = LinearLayoutManager(holder.rv.context, LinearLayout.VERTICAL, false)
        // Access RecyclerView Adapter and load the data
        var adapter = MainLocationAdapter(dateList[position] as ArrayList<HashMap<String, String>>)
        holder.rv?.adapter = adapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_dates, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return byDates.count()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val date = itemView.findViewById<TextView>(R.id.locationDate)
        val rv = itemView.findViewById<RecyclerView>(R.id.locationList)
    }

}