package com.skillbox.fragments_2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.skillbox.fragments_2.databinding.FragmentArticleBinding

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private lateinit var articleFragmentBinding: FragmentArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("viewPager", "ArticleFragment: onCreate =")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        articleFragmentBinding = FragmentArticleBinding.inflate(inflater, container, false)
        return articleFragmentBinding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articleFragmentBinding.buttonGenerate.setOnClickListener {
            (activity as AppActivity).collbackGenerateBadge()
        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Поместим ресурсы в разметку
        requireView().setBackgroundResource(requireArguments().getInt(Constants.KEY_COLOR))
        articleFragmentBinding.textView.setText(requireArguments().getInt(Constants.KEY_TEXT))
        articleFragmentBinding.imageView.setImageResource(requireArguments().getInt(Constants.KEY_DRAWBLE))

    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        // Поместим ресурсы в разметку
//        requireView().setBackgroundResource(requireArguments().getInt(Constants.KEY_COLOR))
//        articleFragmentBinding.textView.setText(requireArguments().getInt(Constants.KEY_TEXT))
//        articleFragmentBinding.imageView.setImageResource(requireArguments().getInt(Constants.KEY_DRAWBLE))
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("viewPager", "ArticleFragment: onDestroy = ")
    }

    // Новая инстанция фрагмента, принимающая на вход три аргумента
    companion object {
        fun newInstance(
            // Анотации нужны, чтоб можно было передавать правильный ресурс
            @StringRes textRes: Int,
            @ColorRes bgColorRes: Int,
            @DrawableRes drawbleRes: Int,
            tags: List<ArticleTag>
        ): ArticleFragment {
            return ArticleFragment().withArguments {
                putInt(Constants.KEY_TEXT, textRes)
                putInt(Constants.KEY_COLOR, bgColorRes)
                putParcelableArrayList(Constants.KEY_ARTICLE_TAGS, tags as ArrayList<ArticleTag>)
            }
        }

//            val fragment = MainFragment()
//            val args = Bundle().apply {
//                putString(Constants.KEY_MAIN_FRAGMENT, text)
//            }
//            fragment.arguments = args
//            return fragment
//        return MainFragment().withArguments {
//            putString(Constants.KEY_MAIN_FRAGMENT, text)
//        }
    }

}