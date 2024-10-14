package com.islami.islami

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.islami.islami.databinding.ActivityMainBinding
import com.islami.islami.hadies.HadiesFragment
import com.islami.islami.quran.QuranFragment
import com.islami.islami.radio.RadioFragment
import com.islami.islami.sebha.SebhaFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickNavHome()
    }

    private fun onClickNavHome() {
        binding.includeHome.navHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_quran -> {
                    showFragment(QuranFragment())
                }
                R.id.nav_hadies -> {
                    showFragment(HadiesFragment())
                }
                R.id.nav_radio -> {
                    showFragment(RadioFragment())
                }
                R.id.nav_sebha -> {
                    showFragment(SebhaFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
        binding.includeHome.navHome.selectedItemId = R.id.nav_quran
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.home_fragment, fragment)
            .addToBackStack("").commit()
    }
}
