package com.example.catfactskt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catfactskt.databinding.FactRowBinding

class MyAdapter: RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.fact_row,parent,false)
        return MyViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.facts.setText("Ala ma kota")
        holder.binding.factsLength.setText("11")
    }

    override fun getItemCount(): Int {
        return 2
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val binding = FactRowBinding.bind(view)
}