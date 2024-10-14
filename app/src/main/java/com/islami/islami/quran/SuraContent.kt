package com.islami.islami.quran

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.islami.islami.Constants.Constants
import com.islami.islami.databinding.ActivitySuraContentBinding

class SuraContent : AppCompatActivity() {
    lateinit var binding: ActivitySuraContentBinding
    lateinit var adapter: SuraAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViews()
    }

    private fun setUpViews() {
        val suraId = intent.getIntExtra(Constants().suraId, 0) + 1
        val suraName = intent.getStringExtra(Constants().suraName)
        val suraList = readSura("$suraId.txt").trim().split("\n")
        adapter = SuraAdapter(suraList)
        binding.content.recSura.adapter = adapter
        binding.suraName.text = suraName
        binding.backIv.setOnClickListener {
            finish()
        }
    }


    private fun readSura(fileName: String): String {
        val suraList = application.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        return suraList
    }

}

