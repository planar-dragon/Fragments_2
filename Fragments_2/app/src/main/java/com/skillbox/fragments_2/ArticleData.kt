package com.skillbox.fragments_2

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// Класс выступает в качестве хранения данных для фрагмента ArticleFragment

data class ArticleData(
    @StringRes val textRes: Int,
    @ColorRes val bgColorRes: Int,
    @DrawableRes val drawbleRes: Int,
    val tags: List<ArticleTag>
)
