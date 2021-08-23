 package com.skillbox.collections

import com.skillbox.collections.oop.Car
import com.skillbox.collections.oop.Vehicle

fun main() {
    val vehicle: Vehicle = Car(wheelCount = 4, doorCount = 4, maxSpeed = 100)
    println{vehicle.getTitle()}




}