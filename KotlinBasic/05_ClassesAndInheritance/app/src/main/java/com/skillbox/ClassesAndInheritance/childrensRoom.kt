package com.skillbox.ClassesAndInheritance

// Класс Детской комнаты

class childrensRoom(area: Double, titleRoom: String):Room(area) { // Наследник класса Room - childrensRoom, где свойство title изменяемое
    override var title: String = titleRoom // Переназначение (override) изменяемого строкового свойства "title" в "titleRoom"
}