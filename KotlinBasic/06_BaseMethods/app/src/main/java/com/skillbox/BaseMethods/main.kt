package com.skillbox.BaseMethods

fun main() {

    // Создаем два объекта класса Person с полностью одинаковыми параметрами(свойствами).
    val person1 = Person(182,79,"Сегизмунд")

    val person2 = Person(182, 79, "Сегизмунд")

    // Объявляем изменяемый set для хранения Person.
    val mutableSetPerson = mutableSetOf( // Добавляем два объекта внутрь.
        person1,
        person2
    )

    // Выводим количество итоговых элементов в сете.
    println("Колличество итоговых элементов в сете: ${mutableSetPerson.size}")

    // Сделаем так, чтобы в сете в итоге был один объект
    // Set хранит неповторяющиеся обьекты, поэтому повторения устраняются
    val mutableSetPersonToSet = mutableSetPerson.toSet()

    // Создаем и добавляем ещё один объект Person в сет, отличающийся от первых двух.
    val person3 = Person(180, 81,"Полифемус")
    mutableSetPerson.add(person3)

    // С помощью forEach выводим описание всех пользователей c их свойствами в консоль.
    mutableSetPerson.forEach {
        println(it)}
    println("Колличество итоговых элементов в сете: ${mutableSetPerson.size}")

    // Для каждой персоны из сета покупаем несколько домашних животных,
    // проверьте, что в лог корректно выводится список домашних животных при обращении к полю pets.

    print("$person1 покупает ")
    person1.buyPet()
    print("$person3 покупает ")
    person3.buyPet()

    println("Персоны после покупки животных:")

    // Выводим описание всех пользователей после покупки.
    mutableSetPerson.forEach {
    println(it)}
}







