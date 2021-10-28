package com.skillbox.Generics

import kotlin.random.Random

//Задание 3. Sealed-class, описывающий абстрактный результат операции
//
//Создайте sealed-class Result, который параметризован двумя типами — типом успешного результата (T) и типом ошибки (R).
//Наследуйтесь от него двумя классами:
//Success<T, R> - data class, принимает в конструктор объект типа T;
//Error<T, R> - data class, принимает в конструктор объект типа R.
//Создайте функцию, которая возвращает объект типа Result<Int, String>. Сделайте так, чтобы результат функции можно было присвоить переменным со следующими типами:
//Result<Number, String>
//Result<Any, String>
//И нельзя было присвоить переменным со следующими типами:
//
//Result<Int, CharSequence>
//Result<Int, Any>
//то есть класс Result должен быть ковариантным по параметру T и инвариантным по параметру R.

sealed class Result<out T,  R> { // sealed-class Result, с параметрами двух типов: успешного результата (T) и типом ошибки (R)
// Параметр типа Т в исходящей позиции только того типа, типом или подтипом которого является.
// Параметр типа R - тип устанавливается на входящей позициии.

    data class Success<T, R>(val parameterSuccess: T) : Result<T, R>()

    data class Error<T, R>(val parameterError: R) : Result<T, R>()

    fun objectReturn(): Result<Int, String> {
// На выходе Int с типами старше, и только String, который должен прописываться во входящей позиции
        return if (Random.nextBoolean()) { // Вернем любой резудьтат дата класс Success или Error
            Success(0)

        } else Error("Неверно")

    }

//Проверяем чтобы результат функции можно было присвоить переменным со следующими типами:
//Result<Number, String>
//Result<Any, String>
//И нельзя было присвоить переменным со следующими типами:
//Result<Int, CharSequence>
//Result<Int, Any>

    var numberString:Result<Number, String> = objectReturn() // присваевается
    var anyString:Result<Any, String> = objectReturn()  // присваевается
//    var intCharSequence:Result<Int, CharSequence> = objectReturn() // выдает ошибку
//    var intAny:Result<Int, Any> = objectReturn() // выдает ошибку

}



