package com.skillbox.ClassesAndInheritance

fun main(){
    val ordinaryRoom = Room(16.0) // Экземпляр класса Room "Обычная комната", площадь 16,0
    ordinaryRoom.getDescription()

    val bedRoom = BedRoom(12.8) // Экземпляр класса Room "Спальня", площадь 12,8
    bedRoom.getDescription()

    val livingRoom = LivingRoom(27.0) // Экземпляр класса Room "Гостиная", площадь 27,0
    livingRoom.getDescription()

    val kitchen = Kitchen(11.2) // Экземпляр класса Room "Кузня", площадь 11,2
    kitchen.getDescription()

    val bathRoom = BathRoom(2.4) // Экземпляр класса Room "Санузел", площадь 2,4
    bathRoom.getDescription()

    val childrensRoom = ChildrensRoom(10.6, "Детская комната") // Экземпляр класса Room "Детская комната", площадь 10,6
    childrensRoom.getDescription()
    childrensRoom.titleRoom = "Вторая спальня" // Второе назначение комнаты
    childrensRoom.getDescription()

    val freeRoom = FreeRoom(7.6, "Свободная комната") // Экземпляр класса Room "Обычная комната", площадь 7,6
    freeRoom.getDescription()
    freeRoom.titleRoom = "Игровая" // Второе назначение комнаты
    freeRoom.getDescription()

    val home = listOf( // Список "home", включающий все комнаты
        Room(16.0),
        BedRoom(12.8),
        LivingRoom(27.0),
        Kitchen(2.4),
        BathRoom(11.2),
        ChildrensRoom(10.6, "Детская комната"),
        FreeRoom(7.6, "Игровая")
    )

    home.forEach { // метод .forEach, который выведет все элементы списка "home" построчно
        println("В доме ${it.title} и ее площадь ${it.area} кв.м.") // Шаблон строки вывода, где it.элемент списка
    }

}
