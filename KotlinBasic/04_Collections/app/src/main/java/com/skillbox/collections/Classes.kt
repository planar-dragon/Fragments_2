package com.skillbox.collections

import com.skillbox.collections.oop.Car
import com.skillbox.collections.oop.Vehicle

fun main() {
    val tesla = Car(wheelCount = 4, doorCount = 2, maxSpeed = 150)

    with(tesla){     //замена вызова методов tesla.
        refuel(100)
        openDoor()
        accelerate(100)
        accelerate(100, force = true)
        decelerate(50)


        }
    val vehicle: Vehicle = tesla

    println("vehicle is car = ${vehicle is Car}")
    println("tesla is vehicle = ${tesla is Vehicle}")
    println("vehicle is car = ${ Vehicle(maxSpeed = 100) is Car}")
    
    val newCar: Car = vehicle




}