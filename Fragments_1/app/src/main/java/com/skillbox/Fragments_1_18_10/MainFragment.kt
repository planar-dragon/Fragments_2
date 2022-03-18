package com.skillbox.Fragments_1_18_10

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.skillbox.Fragments_1_18_10.databinding.MainFragmentBinding

class MainFragment() : Fragment(R.layout.main_fragment)
, ItemSelectListener
{

    private lateinit var mainFragmentBinding: MainFragmentBinding

    val LOG_TAG: String = "myLogs"

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
//        Log.d(LOG_TAG, "MainFragment: onCreateView")
        return mainFragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.beginTransaction()
            .replace(R.id.parent_container, ListFragment.newListFragment(Constants.KEY_LIST))
            .commit()
        Log.d(LOG_TAG, "ListFragment: beginTransaction")
    }

    // Переназначенная функция из интерфейса
    override fun onItemSelected(text: String) {

        childFragmentManager.beginTransaction()
            .setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_right)
            .addToBackStack(null)
            .replace(R.id.parent_container, DetailFragment.newDetailFragment(text))
            .commit()
        val count = childFragmentManager.backStackEntryCount
        Log.d(LOG_TAG, "Сохранено в BackStack $count")

    }



//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        Log.d(LOG_TAG, "MainFragment: onAttach")
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        Log.d(LOG_TAG, "MainFragment: onCreate")
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        Log.d(LOG_TAG, "MainFragment: onDestroyView")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(LOG_TAG, "MainFragment: onDestroy")
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        Log.d(LOG_TAG, "MainFragment: onDetach")
//    }

//    override fun onBackPressed() {
//
//    parentFragmentManager.popBackStack()
//
//    }
}
