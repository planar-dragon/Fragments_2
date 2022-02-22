package com.skillbox.Fragments_1_18_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.skillbox.Fragments_1_18_10.databinding.FragmentMainBinding

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
