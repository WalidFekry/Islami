package com.islami.islami.hadies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.islami.islami.Constants.Constants
import com.islami.islami.databinding.ActivityHadiesContentBinding
import com.islami.islami.databinding.ActivitySuraContentBinding

class HadiesContent : AppCompatActivity() {
    lateinit var binding: ActivityHadiesContentBinding
    lateinit var adapter: ContentHadiesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadiesContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViews()
    }

    private fun setUpViews() {
        val hadiesName: String? = intent.getStringExtra(Constants().hadiesName)
        val hadiesContent: String? = intent.getStringExtra(Constants().hadiesContent)
        adapter = ContentHadiesAdapter(hadiesName,hadiesContent)
        Log.d("dasd", "setUpViews: $hadiesContent , $hadiesName")
        binding.content.recHadiesContent.adapter = adapter
        binding.backIv.setOnClickListener {
            finish()
        }
    }

}
