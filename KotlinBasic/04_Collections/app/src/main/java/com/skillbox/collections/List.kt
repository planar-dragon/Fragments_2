package com.skillbox.collections

fun main(){
    val mutableList = mutableListOf("1","2","3") // "immutableList" Неизменяемый список
    // "mutableListOf" функция делающая список Изменяемым
    println(mutableList)

    mutableList[0]

    mutableList.forEach { println(it) }

    val emptyList = emptyList<String>()
    // Создание пустого неизменяемого списка "emptyList"
    // <String> Обобщенный тип массива
    mutableList[0] = "1.2" // Изменение первого элемента списка
    println(mutableList)  // Распечатка элементов измененного списка

    mutableList.removeAt(0) //Удаление первого элемента

    mutableList.add("4") // Добавление четвертого элемента
    mutableList.add(1, "new 1") // Изменение второго элемента

    println(mutableList)

    mutableList.addAll(listOf("10","20"))// Добавление элементов из другого списка
    println(mutableList)
}