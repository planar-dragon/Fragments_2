package com.skillbox.function
import kotlin.math.sqrt

fun main() {

    val solutionSum = solveEquation(a = 52, b = -5005, c = 425)
    println(solutionSum)
}
fun square(b: Double) = b * b

fun solveEquation(a: Int, b: Int, c: Int): Double {
    //Для нахождения корней квадратного уравнения необходимо найти дискриминант по формуле:
    val discriminant = square(b.toDouble()) - (4 * a * c)

    // Если D>0, то уравнение имеет два корня, которые находятся по формулам:
    if (discriminant > 0) {
        val x1 = ((-b) + sqrt(discriminant)) / (2 * a)
        val x2 = ((-b) - sqrt(discriminant)) / (2 * a)
    println(x1)
    println(x2)

    //сумму корней
    return x1 + x2

    // Если D<0, то уравнение не имеет корней.
    } else {
    println("Уравнение не имеет корней")
    }

    return discriminant
    }