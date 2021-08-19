package com.skillbox.ClassesAndInheritance;

open class Room(val area: Double)
{
    open val title: String = "Обычная комната"

    fun getDescription(){
        println("$title, площадь $area")
    }
}