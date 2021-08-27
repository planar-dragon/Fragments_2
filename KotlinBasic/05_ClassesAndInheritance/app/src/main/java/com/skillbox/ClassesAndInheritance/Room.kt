package com.skillbox.ClassesAndInheritance;

open class Room(val area: Double) // Класс Room открытый для наследования. Конструктор содержит неизменяемый параметр «площадь».
{
    protected open val title: String = "Обычная комната" // Открытое неизменяемое свойство title строкового типа — «Обычная комната».

    fun getDescription(){ // функция getDescription, которая выводит информацию о комнате
        println("Комната $title, площадь $area") // информация о комнате, которая выводится: "комната, площадь комнаты"
    }
}