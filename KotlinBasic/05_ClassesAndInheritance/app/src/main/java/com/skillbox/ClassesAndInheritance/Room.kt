package com.skillbox.ClassesAndInheritance;

open class Room(val area: Double) // Класс Room открытый для наследования. Конструктор содержит неизменяемый параметр «площадь».
{
    open val title: String = "Обычная комната" // Открытое неизменяемое свойство title строкового типа — «Обычная комната».

    fun getDescription(){ // функцию getDescription
        println("$title, площадь $area") // информацию о комнате, которая выводится: комната, площадь комнаты
    }
}