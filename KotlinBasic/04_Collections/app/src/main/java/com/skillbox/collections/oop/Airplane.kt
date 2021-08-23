package com.skillbox.collections.oop

class Airplane(maxSpeed: Int): Vehicle(maxSpeed) {
    override fun getTitle(): String = "Airplane"
}