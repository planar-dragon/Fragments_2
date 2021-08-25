package com.skillbox.ClassesAndInheritance

// Класс Санузел

class bathRoom(area: Double): Room(area) { // Наследник класса Room - bathRoom
    override val title: String = "Санузел" // Переназначение (override) неизменяемого строкового свойства "title" из "Обычная комната" в "Санузел"
}