package com.skillbox.fragments_2

import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.android.parcel.Parcelize

// Класс выступает в качестве хранения данных для фрагмента ArticleFragment
@Parcelize
data class ArticleData(
    @StringRes val textRes: Int,
    @ColorRes val bgColorRes: Int,
    @DrawableRes val drawbleRes: Int,
    val tags: List<ArticleTag>
): Parcelable
