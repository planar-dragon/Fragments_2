package com.skillbox.collections.oop

class Car (
    val wheelCount: Int,
    val doorCount: Int,
    maxSpeed: Int
        ): Vehicle(maxSpeed) {

    var isDoorOpen: Boolean = false
        private set

    fun openDoor() {
        if (!isDoorOpen) {
            println("Door is Opened")
        }
        isDoorOpen = true
    }

    fun closeDoor() {
        if (isDoorOpen) {
            println("Door is Closed")
        }
        isDoorOpen = false

    }

    override fun accelerate(speed: Int) {
        if (isDoorOpen){
            println("you cant accelerate withe opened door")
        } else {
            super.accelerate(speed)
        }
    }

    fun accelerate(speed: Int, force: Boolean) {
        if (force) {
            if (isDoorOpen) println("warning, accelerate with opened door")
            super.accelerate(speed)
        } else {
            accelerate(speed)
        }
    }

    }
