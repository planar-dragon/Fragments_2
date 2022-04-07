package com.skillbox.fragments_2

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ArticleAdapter(
    // свойство содержащее в себе список
    private val articles: List<ArticleData>,
    fragment: Fragment
): FragmentStateAdapter(fragment) {

    // Определяет сколько элементов может быть - колличество страниц
    // В данном слечае вернет колличество элементов в списке screens
    override fun getItemCount(): Int {
        Log.d("viewPager","OnBoardingAdapter: getItemCount")
        return articles.size
    }
    // Создает фрагмент для вью Паджера по надобности
    override fun createFragment(position: Int): Fragment {
        Log.d("viewPager","OnBoardingAdapter: createFragment $position")
        // Переменная которая сохраняет элемент по позиции списка
        val screen: ArticleData = articles[position]
        // Возвращаем создание фрагмента с переданными из переменной аргументов
        return ArticleFragment.newInstance(
            textRes = screen.textRes,
            bgColorRes = screen.bgColorRes,
            drawbleRes = screen.drawbleRes
        )
    }
}