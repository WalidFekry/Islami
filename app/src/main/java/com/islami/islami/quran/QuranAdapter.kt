package com.islami.islami.quran

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.islami.islami.R

class QuranAdapter(private val list:List<String>) : Adapter<QuranAdapter.ViewHoder>() {

    class ViewHoder(itemView: View) : ViewHolder(itemView){
        val suraName:TextView = itemView.findViewById(R.id.txt8)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quran,parent,false)
        return ViewHoder(view)
    }

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
        holder.suraName.text = list.get(position)
        holder.itemView.setOnClickListener {
            if (onItemSuraClick != null){
                onItemSuraClick?.onClick(position,list)
            }
        }
    }


    var onItemSuraClick: OnItemClickLister? = null


    interface OnItemClickLister {
        fun onClick(pos:Int,list:List<String>)
    }



    override fun getItemCount(): Int {
         return list.size
    }
}