package com.skillbox.ClassesAndInheritance

fun main() {
    val user1 = User("name1", "lastname1") //обьект дата класса с аргументами(свойствами) name1 и lastname1
    user1.innerState = "state1"
    val user2 = User("name1", "lastname1")
    user2.innerState = "state2"
    println(user1 == user2) // Сравниваются аргументы обьектов конструктора но не переменная созданная в теле класса
    val user3 = user1.copy(lastname = "copiedLastName") // Создание копии обьекта, в которой можно изменить его свойства
    // так делается если не нужно создавать обьект класса путем вызова конструктора
    println("user3 inner state = ${user3.innerState}") // свойства которые не определены в основном конструкторе не копируются

    println(user1)

    // val user5 = User ("name5", "lastname5")
    // println("name = ${user5.name}")
    // println("lastname = ${user5.lastname}")

    val (name, lastname) = User("name5", "lastname5")// ввод двух переменных и инициализировали их как свойства класса User
    println("name = ${name}") //деструктивное определение
    println("lastname = ${lastname}")

    //val user5 = User ("name5", "lastname5") //Создали обьект user5
    //val name = user5.component1() // обьявили две переменные, компонент1 передает 1 свойство из конструктора
    //val lastname = user5.component2()
    //println("name = ${name}")
    //println("lastname = ${lastname}")

    val users = listOf(
            user1,
            user2,
            user3
    )
    //users.forEach { (name, lastname) -> println("$name $lastname") }
    users.forEach { (name) -> println("$name") }

    val map = mapOf(
            1 to "1",
            2 to "2"
    )

    for ((key, value) in map) {
        key
        value

    }
}
