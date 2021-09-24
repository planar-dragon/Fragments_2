package com.skillbox.ExtensionsObjectsEnums

    // Объявите enum class популярных валют — рубли, доллары, евро.

enum class Currency() {
    RUBEL, // — рубли
    DOLLAR, // —  доллары
    EURO; // — евро

    // Внутри класса enum создайте companion object, в котором объявите переменную «национальная валюта». Значение может быть любым.

companion object { //внутри компаньоны
        var nationalCurrency = "National currency"

    }
}

