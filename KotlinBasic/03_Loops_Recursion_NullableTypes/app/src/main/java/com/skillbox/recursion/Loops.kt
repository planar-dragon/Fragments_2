package com.skillbox.recursion

fun main() {
    print("Введите число: ")
    val n = readLine()?.toIntOrNull() ?: return

    println("Вы ввели число: $n") //показывает какое число ввели
// показывает сумму чисел с помощью функции while
    println("Сумма с помощью While = ${calculateSumByWhile(n)}")
// показывает сумму чисел с помощью функции while и Return
    println("Сумма с помощью While и Return = ${calculateSumByWhileInfiniteReturn(n)}")
// показывает сумму чисел с помощью функции while и Break
    println("Сумма с помощью While и Break = ${calculateSumByWhileInfiniteBreak(n)}")
//
    printEventNumbers(n)

}
fun calculateSumByWhile(n: Int): Long {
    var sum: Long = 0 //промежуточная сумма
    var currentNumber: Int = 0 //текущее число

    while (currentNumber <= n) { //суммируются до тех пор пока с текущее число не превысит "n"
        sum += currentNumber //к сумме плюсуется текущее число, += упрощенный знак
        currentNumber++ //текущее число растет на 1, ++ упрощенное число = "+1"
    }
    return sum //возврат суммы из функции
}

fun calculateSumByWhileInfiniteReturn(n: Int): Long {
        var sum: Long = 0 //промежуточная сумма
        var currentNumber: Int = 0 //текущее число

        while (true) { //для определения бесконечного цикла, условие конструкции while изменить на "true"
            if(currentNumber > n) return sum //разрыв бесконечного цикла возвратомм суммы при превышении текущего числа число "n"

            sum += currentNumber
            currentNumber++
        }
    }
fun calculateSumByWhileInfiniteBreak(n: Int): Long {
    var sum: Long = 0 //промежуточная сумма
    var currentNumber: Int = 0 //текущее число

    while (true) { //для определения бесконечного цикла, условие конструкции while изменить на "true"
        if(currentNumber > n) break
 //оператор break выйдет из цикл при превышении текущего числа число "n" и перейдет к коду написаному далее.

        sum += currentNumber
        currentNumber++
    }
    return sum //возврат суммы из функции
}

fun printEventNumbers(n: Int) {
    var currentNumber: Int = 0 //текущее число
    while (currentNumber <= n) { //цикл печати чисел пока текущее число <= "n"
        val numberBefore = currentNumber //запоминает предыдущее число для печати
        currentNumber++
        if(numberBefore % 2 == 1) continue //начинается следущая операция, не завершая текущую
//проверка если сохраненное для печати число делится на два без остатка, оно отправляется для печати в консоль
        println(numberBefore)
    }
}
