package com.skillbox.function
import kotlin.math.sqrt

fun main() {

    val solutionSum = solveEquation(a = 52, b = -505, c = 425)
    println(solutionSum)
}
fun square(b: Double) = b * b

fun solveEquation(a: Int, b: Int, c: Int): Double {
    //Для нахождения корней квадратного уравнения необходимо найти дискриминант по формуле:
    val discriminant = square(b.toDouble()) - (4 * a * c)
    // Если D>0, то уравнение имеет два корня, которые находятся по формулам:
    val x1 = ((-b) + sqrt(discriminant)) / (2 * a)
    val x2 = ((-b) - sqrt(discriminant)) / (2 * a)

    // Если D<0, то уравнение не имеет корней.
    if (discriminant < 0) {
    println("Уравнение не имеет корней")
    } else {
    println(x1)
    println(x2)
    }
    //сумму корней
    return (x1 + x2)
}