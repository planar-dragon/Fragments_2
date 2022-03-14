package com.skillbox.Fragments_1_18_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.skillbox.Fragments_1_18_10.databinding.MainFragmentBinding

class MainFragment( ) : Fragment(R.layout.main_fragment) {

    private var mainFragmentBinding: MainFragmentBinding? = null

    private val binding get() = mainFragmentBinding!!

    companion object {

        fun newMainFragment(text: String): MainFragment {
//            val fragment = MainFragment()
//            val args = Bundle().apply {
//                putString(Constants.KEY_MAIN_FRAGMENT, text)
//            }
//            fragment.arguments = args
//            return fragment
            return MainFragment().withArguments {
                putString(Constants.KEY_MAIN_FRAGMENT, text)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.beginTransaction()
            .replace(R.id.parent_container, ListFragment())
            .commit()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        mainFragmentBinding = null
    }
}