package com.skillbox.ClassesAndInheritance;

import java.text.DecimalFormat

open class Room(val area: Double) // Класс Room открытый для наследования. Конструктор содержит неизменяемый параметр «площадь».
{
    protected open val title: String = "Обычная комната" // Открытое неизменяемое свойство title строкового типа — «Обычная комната».

    fun getDescription(){ // функция getDescription, которая выводит информацию о комнате
        val dec = DecimalFormat("#.0")// всеравно не считае правильно площадь
        val newArea = dec.format(area)// всеравно не считае правильно площадь
        println("Комната $title, площадь $area м.кв.") // информация о комнате, которая выводится: "комната, площадь комнаты"
    }

}