package com.skillbox.fragments_2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.github.javafaker.Faker
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayoutMediator
import com.skillbox.fragments_2.databinding.FragmentViewPagerBinding
import kotlin.math.abs
import kotlin.random.Random
import kotlin.random.nextInt

class ViewPagerFragment() : Fragment(R.layout.fragment_view_pager) {

    private lateinit var viewPagerFragmentBinding: FragmentViewPagerBinding

//    lateinit var viewPager: ViewPager2
//    lateinit var tabLayout: TabLayout

    private val faker = Faker()

    val LOG_TAG: String = "myLogs"

    // Переменная которая будет хранить данные экранов которые надо отобразить в списке ArticleData

    private val articles: List<ArticleData> = listOf(
        ArticleData(
            textRes = R.string.onboarding_text_1,
            bgColorRes = R.color.one,
            drawbleRes = R.drawable.one
        ),
        ArticleData(
            textRes = R.string.onboarding_text_2,
            bgColorRes = R.color.two,
            drawbleRes = R.drawable.two
        ),
        ArticleData(
            textRes = R.string.onboarding_text_3,
            bgColorRes = R.color.three,
            drawbleRes = R.drawable.three
        ),
        ArticleData(
            textRes = R.string.onboarding_text_4,
            bgColorRes = R.color.four,
            drawbleRes = R.drawable.four
        ),
        ArticleData(
            textRes = R.string.onboarding_text_5,
            bgColorRes = R.color.five,
            drawbleRes = R.drawable.five
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewPagerFragmentBinding = FragmentViewPagerBinding.inflate(inflater, container, false)
//        Log.d(LOG_TAG, "MainFragment: onCreateView")
        return viewPagerFragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = viewPagerFragmentBinding.viewPager
        val tabLayout = viewPagerFragmentBinding.tabLayout

        // Преобразуем список обьектов хранящихся в дата классе ArticleData во фрагменты через адаптер

        val adapter = ArticleAdapter(articles, this)

        viewPager.adapter = adapter
        // Свяжем tabLayout и viewPager, через класс TabLayoutMediator

        // Внутрь передаем tabLayout, viewPager и конфигурацию, для конфигурации вкладки по ее позиции.
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = faker.superhero().name()
//                " ${
//                when (position) {
//                    0 -> "один"
//                    1 -> "Два"
//                    2 -> "Три"
//                    3 -> "Четыре"
//
//                    else -> {
//                        "Пять"
//                    }
//                }
//            }"
            // Используем метод attach() для связывания viewPager и tabLayout
        }.attach()

        // Установим индикатор перелистывания
        val wormDotsIndicator = viewPagerFragmentBinding.wormDotsIndicator
        val viewPager2 = viewPagerFragmentBinding.viewPager
        viewPager2.adapter = adapter
        wormDotsIndicator.setViewPager2(viewPager2)


        // Колбак отслеживающий перелистывание
        viewPagerFragmentBinding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d(LOG_TAG, "Открыта страница ${position + 1}")
            }
        })

        viewPagerFragmentBinding.viewPager.setPageTransformer(object : ViewPager2.PageTransformer {
            override fun transformPage(page: View, position: Float) {

//                page.translationX = -position*page.width
//                page.pivotX = 0f
//                page.pivotY = (page.width.toFloat()/2)
                page.cameraDistance = 20000F

                when {
                    // страница невидима когда розиции страниц < -1 и > 1
                    position < -1 || position > 1 -> {
                        // alpha - показатель видимости
                        page.alpha = 0f
                    }

                    // трансформация для страниц слева
                    // при приближении страници к нулевой позиции, она будет становиться видимой
                    position <= 0 -> {
                        page.alpha = 1f
                        page.pivotX = page.width.toFloat()
                        page.rotationY = 90 * abs(position)
                    }
                    // трансформация для страниц справа
                    position <= 1 -> {
                        page.alpha = 1f
                        page.pivotX = 0f
                        page.rotationY = -90 * abs(position)
                    }
                }
            }
        })
    }

    // Функция генерации бейджей
    fun generateBadge() {

        // Рандомный индекс из числа доступных
        val indexRandom = Random.nextInt(articles.indices)
//        val indexRandom = Random.nextInt(0..(screens.size-1))
        Log.d(LOG_TAG, "Добавили 1 в Tab ${indexRandom + 1}")

        // Установим бейдж в рандомно выбраннцю вкладку
        viewPagerFragmentBinding.tabLayout.getTabAt(indexRandom)?.orCreateBadge?.apply {
            //  Если число бейджей больше 1, то добавляется 1
            if (number >= 1) {
                badgeGravity = BadgeDrawable.TOP_END
                number++
            } else {
                // если 0 то добавляется первый
                number = 1
                badgeGravity = BadgeDrawable.TOP_END
            }

            // Удаление бейджа после перехода на вкладку
            viewPagerFragmentBinding.viewPager.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    viewPagerFragmentBinding.tabLayout.getTabAt(position)?.removeBadge()
                }
            })
        }
    }

    companion object {

        fun newViewPagerFragment(text: String): ViewPagerFragment {
//            val fragment = MainFragment()
//            val args = Bundle().apply {
//                putString(Constants.KEY_MAIN_FRAGMENT, text)
//            }
//            fragment.arguments = args
//            return fragment
            return ViewPagerFragment().withArguments {
                putString(Constants.KEY_VIEW_PAGER_FRAGMENT, text)
            }
        }


    }
}




