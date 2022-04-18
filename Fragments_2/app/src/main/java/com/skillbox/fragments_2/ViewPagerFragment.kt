package com.skillbox.fragments_2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.github.javafaker.Faker
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.skillbox.fragments_2.databinding.FragmentViewPagerBinding
import kotlin.math.abs
import kotlin.random.Random
import kotlin.random.nextInt

class ViewPagerFragment() : Fragment(R.layout.fragment_view_pager), TagSelectListener {

    private lateinit var viewPagerFragmentBinding: FragmentViewPagerBinding

    lateinit var viewPager: ViewPager2
    lateinit var tabLayout: TabLayout
    lateinit var toolbar: Toolbar
    lateinit var dialog: DialogFragment

    private val faker = Faker()

    val LOG_TAG: String = "myLogs"

    // Переменная которая будет хранить данные экранов которые надо отобразить
//    private var articles: List<ArticleData> = listOf(
//        ArticleData(
//            textRes = R.string.onboarding_text_1,
//            bgColorRes = R.color.one,
//            drawbleRes = R.drawable.one,
//            tags = listOf(ArticleTag.equipment)
//        ),
//        ArticleData(
//            textRes = R.string.onboarding_text_2,
//            bgColorRes = R.color.two,
//            drawbleRes = R.drawable.two,
//            tags = listOf(ArticleTag.equipment, ArticleTag.intelligence)
//        ),
//        ArticleData(
//            textRes = R.string.onboarding_text_3,
//            bgColorRes = R.color.three,
//            drawbleRes = R.drawable.three,
//            tags = listOf(ArticleTag.strength, ArticleTag.speed)
//        ),
//        ArticleData(
//            textRes = R.string.onboarding_text_4,
//            bgColorRes = R.color.four,
//            drawbleRes = R.drawable.four,
//            tags = listOf(ArticleTag.strength, ArticleTag.speed, ArticleTag.equipment, ArticleTag.intelligence)
//        ),
//        ArticleData(
//            textRes = R.string.onboarding_text_5,
//            bgColorRes = R.color.five,
//            drawbleRes = R.drawable.five,
//            tags = listOf(ArticleTag.equipment, ArticleTag.speed, ArticleTag.intelligence)
//        )
//    )

    // Преобразуем список обьектов хранящихся в дата классе ArticleData во фрагменты через адаптер
    lateinit var adapter: ArticleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewPagerFragmentBinding = FragmentViewPagerBinding.inflate(inflater, container, false)
//        Log.d(LOG_TAG, "MainFragment: onCreateView")

        createVewPager(ArticleObject.articles)

        return viewPagerFragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Прикрепляем меню к тулбару

        val toolbar = viewPagerFragmentBinding.toolbarView

//         меню в тулбар добавил в разметке fragment_view_pager, там же добавил цвет кнопки
//         toolbar.inflateMenu(R.menu.menu)

        // Слушатель для кнопки фильтрации открывающей диалог фрагмент
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.filtration -> {
                    showDialogFragment()
                    true
                }
                else -> false
            }
        }
    }

    // Функция для обновления ViewPagerFragment по переданным тегам
    override fun onTagSelected(checkedTags: BooleanArray) {
//      Отфильтрованный список статей
//      Проверяем содержит ли список articles элемент списка filteredArticleTags,
//      если условие соблюдается элемент сохраняется в newArticles
//        val filteredArticleTags: List<ArticleData> = filteredArticleTags.toList()
        val filteredArticleTags: MutableList<ArticleTag> = emptyList<ArticleTag>().toMutableList()

        ArticleTag.values().forEachIndexed { index, articleTag ->
            //выбранный тег добавляем в список отфильтрованных тегов
            if (checkedTags[index]) {
                filteredArticleTags += articleTag
            }
        }
        Log.d(LOG_TAG, "Список статей для отрисовки viewPager до фильтрации ${ArticleObject.articles}")

// Первичный список статей фильтруем для viewPager
        val newArticles = ArticleObject.articles.filter { article ->
            filteredArticleTags.any { articleTag ->
                article.tags.contains(articleTag)
            }
        }
        Log.d(LOG_TAG, "Список статей для отрисовки viewPager после фильтрации ${newArticles}")
//        articles = newArticles
// запускаем функцию создания вьюпейджера с отфильтрованными тегами
        createVewPager(newArticles)

    }

    // Функции viewPager

    fun createVewPager(articles: List<ArticleData>) {
        val viewPager = viewPagerFragmentBinding.viewPager
        val tabLayout = viewPagerFragmentBinding.tabLayout

        // Преобразуем список обьектов хранящихся в дата классе ArticleData во фрагменты через адаптер

        Log.d(LOG_TAG, "Список статей для отрисовки viewPager $articles")

        adapter = ArticleAdapter(articles, this)

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
        viewPagerFragmentBinding.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d(LOG_TAG, "Открыта страница ${position + 1}")
            }

        })

        // Установим трансформацию перелистывания
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
        val indexRandom = Random.nextInt(ArticleObject.articles.indices)
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
// ???????????????????????????????????????????????????????????????
// Не знаю как запустить диалог фрагмент с сохраненными аргументами
    // Фунция для показа диалога фильтрации
    private fun showDialogFragment() {
    if (Constants.KEY_CHECKED_TAG != null) {
        DialogFragment()
            .show(childFragmentManager, "Dialog Fragment")
    } else {
        DialogFragment.newIntent(checkedTags = BooleanArray(Constants.KEY_CHECKED_TAG))
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


//fun showMultiChoiceDialog() {
//    val tegItems = ArticleTag()
//}
//    val dialogListener = DialogInterface.OnCancelListener { which->
//        when (which) {
//            DialogInterface.BUTTON_POSITIVE -> "Positive"
//            DialogInterface.BUTTON_NEGATIVE -> "2"
//        }
//    }
//    val dialog = AlertDialog.Builder(requireContext())
//        .setCancelable(false)
//        .setIcon(R.drawable.filter_list)
//        .setMultiChoiceItems(ArticleTag)
////    (tegItems, checkboxes){ _, which, isChecked ->}
//        .setTitle("Веберите тег")
//        .setPositiveButton("Применить", dialogListener)
//        .setNegativeButton("Отменить", dialogListener)


}






