package com.skillbox.ExtensionsObjectsEnums

//    1. Объявите enum class популярных валют — рубли, доллары, евро.

enum class Currency(
    var amountOfMoney: Double // свойство класса - колличество денег
) {
    RUBEL(2500.0), // — рубли
    DOLLAR(50.0), // —  доллары
    EURO(102.0); // — евро

//    2. Внутри класса enum создайте companion object, в котором объявите переменную «национальная валюта».
//    Значение может быть любым.

    companion object {
        var NationalCurrency = RUBEL
    }

//    3. Extension-свойство, расширяющее функционал валюты.
//    Свойство должно иметь тип Boolean и определять, является ли валюта национальной.

    val isNationalCurrency: Boolean
        get() = this == NationalCurrency // При создании Extension-свойства, необходимо создать геттер

//    4. Создайте глобальный объект CurrencyConverter.
//    Внутри него в качестве статических переменных объявите курсы каждой валюты относительно доллара.

    object CurrencyConverter {
        const val rubelToUSD: Double = 0.014
        const val dollarToUSD:
                Double = 1.0
        const val euroToUSD: Double = 1.17
    }


}


