package com.skillbox.ClassesAndInheritance

// Класс Спальня

class BedRoom(area: Double): Room(area) { // Наследник класса Room - bedRoom
    override val title: String = "Спальня" // Переназначение (override) неизменяемого строкового свойства "title" из "Обычная комната" в "Спальня"
}