package com.skillbox.collections

fun main() {
    print("Сколько номеров вы хотите сохранить: ")
    val n: Int = readLine()?.toIntOrNull() ?: return
    val numberFiltr = phoneNumbers(n).filter { it.startsWith("+7") }
    println(numberFiltr)
    println("Колличество уникальных введенных номеров: ${numberFiltr.size}")
    println("Сумма уникальных номеров: ${numberFiltr.sumOf { it.length }}")
}
fun phoneNumbers(n: Int): List<String> {
    var l = 1

    val mutableList = mutableListOf<String>()
    println("Введите $n номеров телефона:")

    while (l <= n) {
        print("Введите телефон №$l: ")
        val number = readLine() ?: continue
        l++
        mutableList.add(number)
        }

    val phoneBookMap = mutableMapOf<String, String>()

    for (userNumber in mutableList) {
    println("Введите имя человека с номером телефона ${userNumber}: ")
    val nameHuman = readLine()!!
    phoneBookMap.forEach{println("Человек $nameHuman, номер $userNumber") }
    phoneBookMap[userNumber] = nameHuman

    }
    return mutableList
    }
