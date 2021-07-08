package com.skillbox.collections

fun main() {
    // Коллекция массив содержащее три имени
    val array = arrayOf("Сегизмунд", "Василий", "Али-Баба") + arrayOf("Новый пользователь")
    for (user in array) {
        println(user)
}
    array.forEach { println(it) }
    array.forEachIndexed { index, user -> println("Index = $index, Element = $user") }

    val firstElement = array[0]
    val lastElement = array[array.lastIndex]

    array[0] = "Супер Сегизмунд" // Замена "0" элемента массива

    array.forEach { println(it) }

    val emptyArray = emptyArray<String>()

    val largeArray = Array( size = 100 ) {index -> "User $index"}
    largeArray.forEach {println(it)}

}