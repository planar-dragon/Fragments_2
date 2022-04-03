package com.skillbox.fragments_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.github.javafaker.Faker
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.skillbox.fragments_2.databinding.ActivityAppBinding
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlin.math.abs
import kotlin.random.Random
import kotlin.random.nextInt

class AppActivity : AppCompatActivity(R.layout.activity_app) {

    private lateinit var binding: ActivityAppBinding

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

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
        val wormDotsIndicator = findViewById<WormDotsIndicator>(R.id.wormDotsIndicator)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
        viewPager2.adapter = adapter
        wormDotsIndicator.setViewPager2(viewPager2)

        // Колбак отслеживающий перелистывание
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d(LOG_TAG, "Открыта страница ${position + 1}")
            }
        })

        binding.viewPager.setPageTransformer(object : ViewPager2.PageTransformer {
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
        binding.tabLayout.getTabAt(indexRandom)?.orCreateBadge?.apply {
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
            binding.viewPager.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.tabLayout.getTabAt(position)?.removeBadge()
                }
            })
        }

    }

    fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

}

