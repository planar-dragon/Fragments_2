package com.skillbox.ExtensionsObjectsEnums

// Класс Сумма денег с полями(свойствами): валюта, сумма денег

data class AmountOfMoney (
    val currency: String, // валюта
    val amountOfMoney: Double, // сумма денег
)