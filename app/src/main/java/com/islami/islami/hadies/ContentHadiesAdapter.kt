package com.islami.islami.hadies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBindings
import com.islami.islami.R
import com.islami.islami.databinding.ItemHadiesContentBinding

class ContentHadiesAdapter(private val hadiesName: String? , private val  hadiesCintent: String?) : Adapter<ContentHadiesAdapter.ViewHoder>() {

    class ViewHoder(val viewBinding: ItemHadiesContentBinding) : ViewHolder(viewBinding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {
        val viewBinding = ItemHadiesContentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHoder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
            holder.viewBinding.hadiesName.text = hadiesName
            holder.viewBinding.hadiesContent.text = hadiesCintent
    }


    override fun getItemCount(): Int {
        return 1
    }
}