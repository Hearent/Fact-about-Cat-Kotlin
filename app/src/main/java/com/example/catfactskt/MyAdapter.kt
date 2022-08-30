package com.example.catfactskt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catfactskt.databinding.FactRowBinding

class MyAdapter(val catFact: List<String>, val catFactLength: List<String>): RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.fact_row,parent,false)
        return MyViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.facts.setText(catFact.get(position))
        holder.binding.factsLength.setText(catFactLength.get(position))
    }

    override fun getItemCount(): Int {
        return catFact.size
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val binding = FactRowBinding.bind(view)
}