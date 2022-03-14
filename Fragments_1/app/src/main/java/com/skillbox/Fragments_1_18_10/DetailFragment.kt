package com.skillbox.Fragments_1_18_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.skillbox.Fragments_1_18_10.databinding.DetailFragmentBinding

class DetailFragment: Fragment(R.layout.detail_fragment) {

    private var detalFragmentBinding: DetailFragmentBinding? = null

    private val binding get() = detalFragmentBinding!!

    companion object{
        private const val KEY_TEXT = "key_text"

        fun newInstance(text: String): DetailFragment{
            val fragment = DetailFragment()
            val args = Bundle().apply {
                putString(KEY_TEXT, text)
            }
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detalFragmentBinding = DetailFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        detalFragmentBinding.textView = requireArguments().getString(KEY_TEXT)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        detalFragmentBinding = null
    }




}