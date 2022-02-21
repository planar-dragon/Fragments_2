package com.skillbox.Intents_17_11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.skillbox.Intents_17_11.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingMainFragment = FragmentMainBinding.inflate(inflater)
        return bindingMainFragment.root
    }

    companion object {

        @JvmStatic
        fun newMainFragment() = MainFragment()
    }
}
