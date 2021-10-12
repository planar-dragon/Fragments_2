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
        var NationalCurrency = Currency.RUBEL
    }

//    3. Extension-свойство, расширяющее функционал валюты.
//    Свойство должно иметь тип Boolean и определять, является ли валюта национальной.

    val Currency.isNationalCurrency: Boolean
        get() = this == NationalCurrency // При создании Extension-свойства, необходимо создать геттер

//    4. Создайте глобальный объект CurrencyConverter.
//    Внутри него в качестве статических переменных объявите курсы каждой валюты относительно доллара.

    object CurrencyConverter {
        val rubelToUSD: Double = 0.014
        val dollarToUSD: Double = 1.0
        val euroToUSD: Double = 1.17
    }

//     5. Для enum класса Wallets создайте extension метод convertToUSD, конвертирующий любое значение валюты в доллары.
//     Метод должен принимать количество валюты, а возвращать относительное значение в долларах.

    fun Currency.convertToUSD(currency: Currency): Double {
        var moneyInUSD = 0.0

        if (this == RUBEL) moneyInUSD = amountOfMoney * CurrencyConverter.rubelToUSD
        if (this == DOLLAR) moneyInUSD = amountOfMoney * CurrencyConverter.dollarToUSD
        if (this == EURO) moneyInUSD = amountOfMoney * CurrencyConverter.euroToUSD
            return moneyInUSD

    }



    }


