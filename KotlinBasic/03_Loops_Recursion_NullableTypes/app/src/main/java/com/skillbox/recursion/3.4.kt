package com.skillbox.recursion

fun main() {
    print("Сколько N чисел вы хотите ввести: ")
    val n = readLine()?.toIntOrNull()
    if (n != null) {
        firstNumbers(n)
    } else {
        println("Вы ввели не число!")
           }
    }

fun firstNumbers(n: Int) {
    var u = 1
    var positiveNumbers = 0 //Положительные числа
    var sumEntNumbers = 0 //Сумма введеных чисел

    while (u <= n) {
        print("Введите число №$u: ")
        val secondNumbers: Int = readLine()?.toIntOrNull() ?: continue
        u++
        if (secondNumbers > 0)
        positiveNumbers++
        sumEntNumbers += secondNumbers
    }
    println("Количество положительных чисел = $positiveNumbers")
    println("Сумма всех введенных чисел = $sumEntNumbers")
}





