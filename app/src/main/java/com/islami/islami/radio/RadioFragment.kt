package com.islami.islami.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.islami.islami.databinding.HadiesFragmentBinding
import com.islami.islami.databinding.RadioFragmentBinding

class RadioFragment: Fragment() {
    lateinit var viewBindings: RadioFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBindings = RadioFragmentBinding.inflate(inflater, container, false)
        return viewBindings.root
    }
}