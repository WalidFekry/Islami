package com.islami.islami.hadies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.islami.islami.Constants.Constants
import com.islami.islami.databinding.HadiesFragmentBinding

class HadiesFragment : Fragment() {
    lateinit var viewBindings: HadiesFragmentBinding
    lateinit var adapter: HadiesAdapter
    var listOfHadies = mutableListOf<Hadies>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBindings = HadiesFragmentBinding.inflate(inflater, container, false)
        return viewBindings.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadies()
        adapter = HadiesAdapter(listOfHadies)
        viewBindings.recHadies.adapter = adapter
        adapter.onItemHadiesClick = object: HadiesAdapter.OnItemClickLister {
            override fun onClick(pos: Int, list: MutableList<Hadies>) {
                    val intent = Intent(context, HadiesContent::class.java)
                    intent.putExtra(Constants().hadiesName,list.get(pos).title)
                    intent.putExtra(Constants().hadiesContent,list.get(pos).content)
                    startActivity(intent)
            }
        }
    }

    private fun readHadies() {
        val allHadies = readFiles("hadies.txt")?.trim()?.split("#")
        allHadies?.forEach {
            val titleOfHadies = it.trim().substringBefore("\n")
            val contentOfHadies = it.trim().substringAfter("\n")
            listOfHadies.add(Hadies(titleOfHadies,contentOfHadies))
        }
    }

    private fun readFiles(fileName: String): String? {
        val suraList = activity?.assets?.open(fileName)?.bufferedReader().use {
            it?.readText()
        }
        return suraList
    }

}