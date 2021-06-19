package com.skillbox.lesson1_9

fun main() {
    val firstName: String = "Rinat"

    val lastName: String = "Rakhmatullin"

    var height: Int = 182

    var weight: Float = 82.2F

    var isChild: Boolean = height < 150 || weight < 40

    var info = "My name is ${firstName} and lastname is ${lastName}. My height is ${height} cm and weight is ${weight} kg. I'm ${if(isChild) "child" else "adult"}."

    println(info)

    weight = 102.8F
    isChild = height < 150 || weight < 40
    info = "My name is ${firstName} and lastname is ${lastName}. My height is ${height} cm and weight is ${weight} kg. I'm ${if(isChild) "child" else "adult"}."

    println(info)




}