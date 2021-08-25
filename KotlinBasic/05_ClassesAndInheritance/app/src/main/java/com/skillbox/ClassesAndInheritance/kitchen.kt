package com.skillbox.ClassesAndInheritance

// Класс Кухня

class kitchen(area:Double): Room(area) { // Наследник класса Room - kitchen
    override val title: String = "Кухня" // Переназначение (override) неизменяемого строкового свойства "title" из "Обычная комната" в "Кухня"
}