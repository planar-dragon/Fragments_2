package com.skillbox.ClassesAndInheritance

// Класс Гостиная

class livingRoom(area: Double): Room(area) { // Наследник класса Room - livingRoom
    override val title: String = "Гостиная" // Переназначение (override) неизменяемого строкового свойства "title" из "Обычная комната" в "Гостиную"
}