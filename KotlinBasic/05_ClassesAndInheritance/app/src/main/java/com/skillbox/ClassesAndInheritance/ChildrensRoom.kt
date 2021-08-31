package com.skillbox.ClassesAndInheritance

// Класс Детской комнаты

class ChildrensRoom(area: Double, titleRoom: String):Room(area) {
    public override var title: String = "Детская комната"

    fun main(args: Array<String>) {
        val titleRoom = ChildrensRoom(10.6)
        println(titleRoom.title)
    }

    override fun toString(): String {
        return super.toString()
    }
}