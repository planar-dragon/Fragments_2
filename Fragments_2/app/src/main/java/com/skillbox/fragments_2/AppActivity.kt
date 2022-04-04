package com.skillbox.fragments_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.github.javafaker.Faker
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.skillbox.fragments_2.databinding.ActivityAppBinding
import com.skillbox.fragments_2.databinding.AppActivityBinding
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlin.math.abs
import kotlin.random.Random
import kotlin.random.nextInt

class AppActivity : AppCompatActivity(R.layout.app_activity) {

        private lateinit var appActivityBinding: AppActivityBinding

        val LOG_TAG: String = "myLogs"

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            appActivityBinding = AppActivityBinding.inflate(layoutInflater)

            setContentView(appActivityBinding.root)

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

//проверяем есть ли сохраненное состояние если его нет, запускается фрагмент логин

            if (savedInstanceState == null) {
                Log.d(LOG_TAG, "Приложение запущено в первый раз, сохранений нет")

                supportFragmentManager.beginTransaction()
                    .replace(R.id.containerFragment, ViewPagerFragment())
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.containerFragment,
                        ViewPagerFragment.newViewPagerFragment(Constants.KEY_VIEW_PAGER_FRAGMENT)
                    )
                    .commit()
            }
            Log.d(LOG_TAG, "ViewPagerFragment: beginTransaction")

        }

    fun collbackGenerateBadge() {
        ViewPagerFragment().generateBadge()
    }

//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityAppBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val viewPager = binding.viewPager
//        val tabLayout = binding.tabLayout
//
//        // Преобразуем список обьектов хранящихся в дата классе ArticleData во фрагменты через адаптер
//
//        val adapter = ArticleAdapter(articles, this)
//
//        viewPager.adapter = adapter
//        // Свяжем tabLayout и viewPager, через класс TabLayoutMediator
//
//        // Внутрь передаем tabLayout, viewPager и конфигурацию, для конфигурации вкладки по ее позиции.
//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            tab.text = faker.superhero().name()
////                " ${
////                when (position) {
////                    0 -> "один"
////                    1 -> "Два"
////                    2 -> "Три"
////                    3 -> "Четыре"
////
////                    else -> {
////                        "Пять"
////                    }
////                }
////            }"
//            // Используем метод attach() для связывания viewPager и tabLayout
//        }.attach()
//
//
//        // Установим индикатор перелистывания
//        val wormDotsIndicator = findViewById<WormDotsIndicator>(R.id.wormDotsIndicator)
//        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
//        viewPager2.adapter = adapter
//        wormDotsIndicator.setViewPager2(viewPager2)
//
//        // Колбак отслеживающий перелистывание
//        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                Log.d(LOG_TAG, "Открыта страница ${position + 1}")
//            }
//        })
//
//        binding.viewPager.setPageTransformer(object : ViewPager2.PageTransformer {
//            override fun transformPage(page: View, position: Float) {
//
////                page.translationX = -position*page.width
////                page.pivotX = 0f
////                page.pivotY = (page.width.toFloat()/2)
//                page.cameraDistance = 20000F
//
//                when {
//                    // страница невидима когда розиции страниц < -1 и > 1
//                    position < -1 || position > 1 -> {
//                        // alpha - показатель видимости
//                        page.alpha = 0f
//                    }
//
//                    // трансформация для страниц слева
//                    // при приближении страници к нулевой позиции, она будет становиться видимой
//                    position <= 0 -> {
//                        page.alpha = 1f
//                        page.pivotX = page.width.toFloat()
//                        page.rotationY = 90 * abs(position)
//                    }
//                    // трансформация для страниц справа
//                    position <= 1 -> {
//                        page.alpha = 1f
//                        page.pivotX = 0f
//                        page.rotationY = -90 * abs(position)
//                    }
//                }
//            }
//        })
//    }
//


    fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

}

