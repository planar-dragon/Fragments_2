package com.skillbox.fragments_2

import androidx.annotation.StringRes


// класс перечисления для тегов статей.
enum class ArticleTag (@StringRes val nameTags: Int) {
    strength (R.string.strength),
    speed(R.string.speed),
    intelligence(R.string.intelligence),
    equipment(R.string.equipment)
}