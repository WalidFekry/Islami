package com.islami.islami.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.islami.islami.R
import com.islami.islami.databinding.ActivitySuraContentBinding
import com.islami.islami.databinding.SebhaFragmentBinding

class SebhaFragment : Fragment() {
    var counter:Int = 0
    var changeTasbeh:Int = 0
    lateinit var viewBinding: SebhaFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = SebhaFragmentBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.sebhaCounter.setOnClickListener {
            viewBinding.sebhaBody.rotation = viewBinding.sebhaBody.rotation+1
            counter++
            viewBinding.sebhaCounter.text = counter.toString()
            changeTasbeh()
        }
    }

    private fun changeTasbeh() {
        if (counter == 33 && changeTasbeh ==0){
            viewBinding.sebhaTasbeh.text="الحمد لله"
            counter = 0
            changeTasbeh = 1
        }else if (counter == 33 && changeTasbeh == 1){
            viewBinding.sebhaTasbeh.text="الله أكبر"
            counter = 0
            changeTasbeh = 2
        }else if (counter == 33){
            viewBinding.sebhaTasbeh.text="سبحان الله"
            counter = 0
            changeTasbeh = 0
        }
    }

}