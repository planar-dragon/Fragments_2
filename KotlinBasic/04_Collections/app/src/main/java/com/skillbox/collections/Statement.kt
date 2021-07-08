package com.skillbox.collections

import kotlin.random.Random

fun main() {

    calculateRandomInt()
        .takeIf { it > 4 }
        ?.let { print("Число более 4") }


}

fun calculateRandomInt() = Random.nextInt()


