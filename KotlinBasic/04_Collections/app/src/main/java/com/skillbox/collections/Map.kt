package com.skillbox.collections

fun main() {

    val pairl = Pair ("key", "value") // Конструктор пары, в который передаем два значения пары: Ключ и Значение
    val pairl2 = 1 to 2
    // Инфиксная функция принимает значения и делает то же самое что и создание пары из конструктора (создает пару из конструктора)

    println("first = ${pairl.first}, second = ${pairl.second}") // Обращение к первому значению пары
    println(pairl2)

    val map = mapOf( // Коллекция "map" - телефонный справочник, содержащий ключ и значение
        "Name1" to "+79090956155",
        "Name1" to "+79090956999",
        "Name1" to "+79090956888", //Перезапись значения "name1"
        "Name2" to "+79090956156",
        "Name3" to "+79090956157"
    )
    println(map["Name1"]) //Распечатка значения из отображения(Map) по вводимому ключу
    println(map["Name4"]) //Если ключа нет, то выводится значение "null"

    val mutableMap = map.toMutableMap() // Превращение "map" в изменяемый
    val mutableMap2 = mutableMapOf("1" to "2") // Изменяемый "map"
    mutableMap["Name1"] = "12312321"  // добавление значения
    mutableMap["Name"] = "12312321"  // добавление значения
    mutableMap.put("key", "value") // добавление ключа и значения
    mutableMap.remove("key") // удаление значения по ключу

    mutableMap.toMap() // Перевод изменяемой коллекции в неизменяемую

    val sortedMap = sortedMapOf( // TreeMap хранит ключи в натуральном порядке
        "2" to "22",
        "3" to "33",
        "4" to "44",
        "1" to "11"
        )

    val hashMap = hashMapOf( // HashMap не гаранитрует порядок
        "2" to "22",
        "3" to "33",
        "4" to "44",
        "1" to "11"
        )

    println(sortedMap)

    println(hashMap.keys)   // получить доступ к ключам
    println(hashMap.values) // получить доступ к значениям

    for (key in hashMap.keys) {// Итерация по "map"
        println("key = $key, value = ${hashMap[key]}")

        hashMap.forEach { (key, value) ->
            key
            value
        }
        // Метод "forEach" принимает лямбду, на вход которой передается обьект типа "map entry"( Пара: ключ, значение)
    }}















