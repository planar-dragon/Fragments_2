package com.skillbox.collections

fun main() {
    print("Сколько номеров вы хотите сохранить: ")
    val n: Int = readLine()?.toIntOrNull() ?: return
    val numberFiltr = phoneNumbers(n).filter { it.startsWith("+7") }

    println("Номера начинающиеся с +7: $numberFiltr")
    val unicNumber = numberFiltr.toSet()
    println("Колличество уникальных введенных номеров: ${unicNumber.size}")
    println("Сумма уникальных номеров: ${unicNumber.sumOf { it.length }}")
}

fun phoneNumbers(n: Int): List<String> { // функция которая содержит список типа String?
    var l = 1

    val mutableList = mutableListOf<String>() // создание пустого изменяемого списка типа String?
    println("Введите $n номеров телефона:")

    while (l <= n) {
        print("Введите телефон №$l: ")
        val number = readLine() ?: continue
        l++
        mutableList.add(number) // добавление телефонов в изменяемый список
    }

    println("Вы ввели номера: $mutableList")

    val phoneBookMap = mutableMapOf<String, String>() // создание пустого изменяемого множества типа String,String?

    for (userNumber in mutableList) { // Цикл где переменная userNumber это элементы списка mutableList?
    println("Введите имя человека с номером телефона ${userNumber}: ")
    val nameHuman = readLine()!!
    phoneBookMap[userNumber] = nameHuman // формат сохранения в phoneBookMap?
    }

    phoneBookMap.forEach { (userNumber, nameHuman) ->
    println("Человек: $nameHuman. Номер телефона: $userNumber")
    }

    return mutableList
}

