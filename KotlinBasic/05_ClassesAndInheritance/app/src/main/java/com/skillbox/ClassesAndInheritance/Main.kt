package com.skillbox.ClassesAndInheritance

fun main(){
    val ordinaryRoom = Room(16.0) // Экземпляр класса Room "Обычная комната", площадь 16,0
    ordinaryRoom.getDescription()

    val bedRoom = bedRoom(12.8) // Экземпляр класса Room "Спальня", площадь 12,8
    bedRoom.getDescription()

    val livingRoom = livingRoom(27.0) // Экземпляр класса Room "Гостиная", площадь 27,0
    livingRoom.getDescription()

    val kitchen = kitchen(11.2) // Экземпляр класса Room "Кузня", площадь 11,2
    kitchen.getDescription()

    val bathRoom = bathRoom(2.4) // Экземпляр класса Room "Санузел", площадь 2,4
    bathRoom.getDescription()

    val childrensRoom = childrensRoom(10.6, "Детская комната") // Экземпляр класса Room "Детская комната", площадь 10,6
    childrensRoom.getDescription()
    childrensRoom.title = "Вторая спальня" // Второе назначение комнаты
    childrensRoom.getDescription()

    val freeRoom = freeRoom(7.6, "Свободная комната") // Экземпляр класса Room "Обычная комната", площадь 7,6
    freeRoom.getDescription()
    freeRoom.title = "Игровая" // Второе назначение комнаты
    freeRoom.getDescription()

    val home = listOf( // Список "home", включающий все комнаты
        Room(16.0),
        bedRoom(12.8),
        livingRoom(27.0),
        kitchen(2.4),
        bathRoom(11.2),
        childrensRoom(10.6, "Детская комната"),
        freeRoom(7.6, "Игровая")
    )

    home.forEach { // метод .forEach, который выведет все элементы списка "home" построчно
        println("В доме ${it.title} и ее площадь ${it.area} кв.м.") // Шаблон строки вывода, где it.элемент списка
    }















}

fun println(any: Any?, function: () -> Double) {

}
