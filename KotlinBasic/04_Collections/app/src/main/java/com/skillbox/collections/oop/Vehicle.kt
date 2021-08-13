package com.skillbox.collections.oop

open class Vehicle(
    val maxSpeed: Int
    ) {
    var currentSpeed: Int = 0// Текущая скорость, изменяемое свойство, поэтому переменная "var"

    get() {
            println("currentSpeed get")
            return field
            }
        private set(value) {
            println("currentSpeed set $value")
            field = value
        }
    var fuelCount: Int = 0
        protected set
    val isStoped: Boolean
    get() = currentSpeed == 0
   // constructor(wheelCount: Int, doorCount: Int, bodySize: Triple <Int, Int, Int>): this (wheelCount, doorCount, bodySize.first, bodySize.second, bodySize.third) {
   // println("Car second init")
    //}

    open fun accelerate(speed: Int) {
        val needFuel = speed / 2

        if(fuelCount >= needFuel) {
            currentSpeed += speed
            useFuel(needFuel)
        }else{
            println("Car has no fuel")
        }
    }
    fun decelerate(speed: Int) {
        currentSpeed  = maxOf(0, currentSpeed-speed)
    }
    open protected fun useFuel(fuelCount: Int) {
        this.fuelCount -=fuelCount
    }
    fun refuel(fuelCount: Int){
        if(currentSpeed == 0) {
        this.fuelCount +=fuelCount
    } else {
        println("you can refuel with currentSpeed != 0 ")
        }


    }
    }
