package com.skillbox.ClassesAndInheritance

// Класс Детской комнаты

class ChildrensRoom(area: Double, override var title: String):Room(area) { // Наследник класса Room - childrensRoom, где свойство title изменяемое
    var titleRoom = title // Переназначение (override) изменяемого строкового свойства "title" в "titleRoom"
}