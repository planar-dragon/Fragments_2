package com.skillbox.recursion

fun main() {

    val string: String = "string" //тип String не позволяет нуллабельного значения
    val nullableString: String? = "string2" //знак ? означает что тип String нуллабельный

    val length: Int = string.length
    val nullableLenght: Int? = nullableString?.length

    nullableString?.reversed()
        ?.find{it == '4'}
        ?.isDigit()

    println("String length is ${nullableString?.length ?: "incorrect"}")
    }

