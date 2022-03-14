package com.skillbox.Fragments_1_18_10

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.skillbox.Fragments_1_18_10.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

    private lateinit var detalFragmentBinding: DetailFragmentBinding

    val LOG_TAG: String = "myLogs"

    val descriptionText: String
        get() = requireArguments().getString(Constants.KEY_DETAL) as String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detalFragmentBinding = DetailFragmentBinding.inflate(inflater, container, false)
        detalFragmentBinding.descriptionTextView.text = descriptionText
        Log.d(LOG_TAG, "DetailFragment onCreateView")
        return detalFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        fun newDetailFragment(text: String): DetailFragment {

            return DetailFragment().withArguments {
                putString(Constants.KEY_DETAL, text)
            }
        }
    }

//    override fun onItemSelected(text: String) {
//        childFragmentManager.beginTransaction()
//            .replace(R.id.parent_container, newDetailFragment(text))
//            .addToBackStack(null)
//            .commit()
//        Log.d(LOG_TAG, "DetailFragment: onItemSelected")
//    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(LOG_TAG, "DetailFragment: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "DetailFragment: onCreate")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LOG_TAG, "DetailFragment: onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "DetailFragment: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(LOG_TAG, "DetailFragment: onDetach")
    }
}