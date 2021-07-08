package com.skillbox.collections

fun main() {
    val immutableSet = setOf(1, 2, 3, 3, 2, 1, 4, 5, 6, 7) // ножество элементов
    println(immutableSet)
    val unionSet = setOf(1, 2, 3).union(setOf(1, 4, 5)) // Обединение множеств, остаются неповторяющиеся элементы
    println(unionSet)

    val substractSet = setOf(1, 2, 3).subtract(setOf(1, 2, 4))    //вычитание элементов второй коллекции из первой
    //элемента "4" не было из за этого он проигнорировался
    println(substractSet)

    val intersectSet = setOf(1, 2, 4).intersect(setOf(4, 5, 5))// Пересечение - выводит элементы которые есть в обоих коллекциях
    println(intersectSet)

    val naturalOrderSet = sortedSetOf(1, 4, -1, 2, 5, 2)// Сортированное множество по натуральному порядку по возрастанию
    println(naturalOrderSet.descendingSet()) // Команда на распечатку нового сета с обратным порядком всех хранимых чисел

    mutableSetOf(1, 2, 3).add(34) // Изменяемый сет, в который можно обавлять элементы

    val hashSet = hashSetOf(1, 2, 3) // По умолчанию ХэшСет изменяемый, в него можно..
    hashSet.add(1) // Добавление элемента в сет
    hashSet.remove(1) // Удаление элемента из сеты

    hashSet.contains(1)// Проверка, содержит ли сет какой либо элемент
    println(1 in hashSet)// Возврат True если сет содержит выбранный элемент "1"

}