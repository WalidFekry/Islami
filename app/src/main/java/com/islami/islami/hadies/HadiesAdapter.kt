package com.islami.islami.hadies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.islami.islami.R

class HadiesAdapter(private val list: MutableList<Hadies>) : Adapter<HadiesAdapter.ViewHoder>() {

    class ViewHoder(itemView: View) : ViewHolder(itemView){
        val nameOfHadies:TextView = itemView.findViewById(R.id.hadies_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hadies,parent,false)
        return ViewHoder(view)
    }

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
        holder.nameOfHadies.text = list.get(position).title
        holder.itemView.setOnClickListener {
            if (onItemHadiesClick != null){
                onItemHadiesClick?.onClick(position,list)
            }
        }
    }


    var onItemHadiesClick: OnItemClickLister? = null


    interface OnItemClickLister {
        fun onClick(pos:Int ,list:MutableList<Hadies>)
    }



    override fun getItemCount(): Int {
         return list.size
    }
}