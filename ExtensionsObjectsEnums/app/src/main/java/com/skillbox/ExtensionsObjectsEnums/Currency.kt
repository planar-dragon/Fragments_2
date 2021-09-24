package com.skillbox.ExtensionsObjectsEnums

    // Объявите enum class популярных валют — рубли, доллары, евро.

enum class Currency(
    val amountOfMoney: Double // свойство класса - колличество денег
) {
    RUBEL(0.0), // — рубли
    DOLLAR(0.0), // —  доллары
    EURO(0.0); // — евро

    // Внутри класса enum создайте companion object, в котором объявите переменную «национальная валюта».
    // Значение может быть любым.

    companion object { //внутри компаньоны
        var nationalCurrency = Currency.RUBEL
    }

    // Extension-свойство, расширяющее функционал валюты.
    // Свойство должно иметь тип Boolean и определять, является ли валюта национальной.

    val Currency.isNationalCurrency: Boolean
        get() = this == Currency.nationalCurrency // При создании Экстеншон свойства, необходимо создать геттер

    // Создайте глобальный объект CurrencyConverter.
    // Внутри него в качестве статических переменных объявите курсы каждой валюты относительно доллара.

    object conversionToDollar {
        val rubel: Double = 0.014
        val dollar: Double = 1.0
        val euro: Double = 1.17
    }

    // Для enum класса валют создайте extension метод convertToUSD, конвертирующий любое значение валюты в доллары.
    // Метод должен принимать количество валюты, а возвращать относительное значение в долларах.

    fun Currency.convertToUSD(amountOfMoney: Double): Double { // в обычный метод добавляем Класс который ходим расширить (Int.основное название функции)
        if (amountOfMoney = Currency.DOLLAR)
            return this

    }
    }
}

