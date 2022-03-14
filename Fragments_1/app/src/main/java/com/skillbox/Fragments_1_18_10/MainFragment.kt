package com.skillbox.Fragments_1_18_10

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.skillbox.Fragments_1_18_10.databinding.MainFragmentBinding

class MainFragment() : Fragment(R.layout.main_fragment), ItemSelectListener {

    private lateinit var mainFragmentBinding: MainFragmentBinding

    val LOG_TAG: String = "myLogs"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
        Log.d(LOG_TAG, "MainFragment: onCreateView")
        return mainFragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.parent_container, ListFragment.newListFragment(text = Constants.KEY_LIST))
            .commit()
        Log.d(LOG_TAG, "MainFragment: onViewCreated")
    }

    override fun onItemSelected(text: String) {

        childFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.parent_container, DetailFragment.newDetailFragment(text))
            .commit()
        Log.d(LOG_TAG, "MainFragment: Обращение к родительскому фрагменту MainFragment")

    }

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
}