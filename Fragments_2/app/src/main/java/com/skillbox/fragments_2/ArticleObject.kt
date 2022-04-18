package com.skillbox.fragments_2

object ArticleObject {
    var articles: List<ArticleData> = listOf(
        ArticleData(
            textRes = R.string.onboarding_text_1,
            bgColorRes = R.color.one,
            drawbleRes = R.drawable.one,
            tags = listOf(ArticleTag.equipment)
        ),
        ArticleData(
            textRes = R.string.onboarding_text_2,
            bgColorRes = R.color.two,
            drawbleRes = R.drawable.two,
            tags = listOf(ArticleTag.equipment, ArticleTag.intelligence)
        ),
        ArticleData(
            textRes = R.string.onboarding_text_3,
            bgColorRes = R.color.three,
            drawbleRes = R.drawable.three,
            tags = listOf(ArticleTag.strength, ArticleTag.speed)
        ),
        ArticleData(
            textRes = R.string.onboarding_text_4,
            bgColorRes = R.color.four,
            drawbleRes = R.drawable.four,
            tags = listOf(ArticleTag.strength, ArticleTag.speed, ArticleTag.equipment, ArticleTag.intelligence)
        ),
        ArticleData(
            textRes = R.string.onboarding_text_5,
            bgColorRes = R.color.five,
            drawbleRes = R.drawable.five,
            tags = listOf(ArticleTag.equipment, ArticleTag.speed, ArticleTag.intelligence)
        )
    )
}