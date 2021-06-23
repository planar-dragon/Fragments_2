package com.skillbox.recursion

fun main() {
    print("Сколько N чисел вы хотите ввести: ")
    val n = readLine()?.toIntOrNull() ?: return

    var u = 1
    var positiveNumbers = 0 //Положительные числа
    var sumEntNumbers = 0 //Сумма введеных чисел

    while (u <= n) {
        print("Введите число №$u: ")
        val Numbers: Int? = readLine()?.toIntOrNull()

        if (Numbers != null && Numbers > 0) {
            u++
            positiveNumbers++
            sumEntNumbers += Numbers

        } else println("Вы ввели не отрицательное число или не число!")
    }
    println("Количество положительных чисел = $positiveNumbers")
    println("Сумма всех введенных чисел = $sumEntNumbers")
}





