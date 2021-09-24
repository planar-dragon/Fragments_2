package com.skillbox.ExtensionsObjectsEnums

fun main() {
    Currency.RUBEL.isNationalCurrency
    Currency.DOLLAR
    Currency.EURO

    // Создайте глобальный объект CurrencyConverter.
    // Внутри него в качестве статических переменных объявите курсы каждой валюты относительно доллара.

    var CurrencyConverter = conversionToDollar(10.0, 1.0, 50.0)

}
    // Extension-свойство, расширяющее функционал валюты.
    // Свойство должно иметь тип Boolean и определять, является ли валюта национальной.
    val Currency.isNationalCurrency: Boolean
        get() = this == "National currency" // При создании Экстеншон свойства, необходимо создать геттер
    private fun Int?.orDefault(defaultValue: Int): Int{
        return this ?: defaultValue

    // Extension-метод convertToUSD, конвертирующий любое значение валюты в доллары.
    // Метод должен принимать количество валюты, а возвращать относительное значение в долларах.

    fun convertToUSD(currency: Currency): conversionToDollar { // в обычный метод добавляем Класс который ходим расширить (Int.основное название функции)
        return when (currency) { // и на выходе выдает цвет инверсии если соблюдено условие when
            Currency.RUBEL -> conversionToDollar.DOLLAR
            Currency.DOLLAR -> conversionToDollar.DOLLAR
            Currency.EURO -> conversionToDollar.DOLLAR
        }
    }
