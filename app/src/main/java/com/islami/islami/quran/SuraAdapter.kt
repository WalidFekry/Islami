package com.islami.islami.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.islami.islami.R

class SuraAdapter(private val list: List<String>) : Adapter<SuraAdapter.ViewHoder>() {

    class ViewHoder(itemView: View) : ViewHolder(itemView) {
        val suraContent: TextView = itemView.findViewById(R.id.sura_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura, parent, false)
        return ViewHoder(view)
    }

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
        if (list.get(position)!= null){
            holder.suraContent.text = list.get(position)+"(${position.plus(1)})"
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }
}