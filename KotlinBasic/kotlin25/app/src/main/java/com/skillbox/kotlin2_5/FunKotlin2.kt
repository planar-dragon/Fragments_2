package com.skillbox.kotlin2_5

import kotlin.random.Random

fun main() {

    hasChildAccess(height =  110, weight = 50, age = 20)
    val any = functionReturnsAny()
    functionWithAnyParam(param = "String")
    functionWithAnyParam(param = "v")
    functionWithAnyParam(param = "3")
}
fun multiply(a: Int = 100, b: Int): Int = a * b

fun hasChildAccess(height: Int, weight: Int, age: Int): Boolean {
    return height > 150 && weight > 30 && age > 10
}

fun functionReturnsAny(): Any {
    return if (Random.nextBoolean()) {
        23455456
     } else {
    "15644351"
}

}
fun functionWithAnyParam(param: Any) {

}