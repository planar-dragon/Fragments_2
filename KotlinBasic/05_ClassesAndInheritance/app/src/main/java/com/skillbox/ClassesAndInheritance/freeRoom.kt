package com.skillbox.ClassesAndInheritance

// Класс комнаты свободного назначения

class freeRoom(area:Double, titleRoom: String):Room(area) { // Наследник класса Room - freeRoom, где свойство title изменяемое
    override var title: String = titleRoom // Переназначение (override) изменяемого строкового свойства "title" в "titleRoom"
}
