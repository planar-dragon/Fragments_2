package com.skillbox.Fragments_1_18_10

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.javafaker.Faker
import com.skillbox.Fragments_1_18_10.databinding.DetailFragmentBinding

class DetailFragment : Fragment()
//    , ItemSelectListener
    , BackPressedListener {

    private lateinit var detalFragmentBinding: DetailFragmentBinding

    val LOG_TAG: String = "myLogs"

// Переменная для вытаскивания текста из кнопки из константы.
    val nameText: String
        get() = requireArguments().getString(Constants.KEY_DETAL) as String
// Рандомный текст который берется из библиотеки Faker
    val description = Faker.instance().lorem().paragraph(10)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detalFragmentBinding = DetailFragmentBinding.inflate(inflater, container, false)
        detalFragmentBinding.nameText.text = nameText
        detalFragmentBinding.descriptionTextView.text = description
        Log.d(LOG_TAG, "DetailFragment onCreateView")
        return detalFragmentBinding.root
    }

// Реализуем переназначение кнопки назад во фрагменте
    override fun onBackPressed() {
    }

    companion object {

        fun newDetailFragment(text: String): DetailFragment {
// текст переданный на вход из кнопки через аргумент сохраняется в константу
            return DetailFragment().withArguments {
                putString(Constants.KEY_DETAL, text)
            }
        }
    }

//    override fun onResume() {
//        super.onResume()
//        requireView().isFocusableInTouchMode = true
//        requireView().requestFocus()
//        requireView().setOnKeyListener { v, keyCode, event ->
//            if (event.action === KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
//                parentFragmentManager.popBackStack()
//                true
//            } else false
//        }
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
        val count = childFragmentManager.backStackEntryCount
        Log.d(LOG_TAG, "Сохранено в BackStack $count")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(LOG_TAG, "DetailFragment: onDetach")
    }
}