package com.skillbox.Generics


//Задание 1. Функция, фильтрующая коллекцию целых и вещественных чисел по чётности
//

//Создайте generic-функцию, принимающую на вход список элементов типа T.
//Отфильтруйте список таким образом, чтобы в нём остались только чётные элементы.
//Верните из функции отфильтрованный список элементов типа T. Функция должна поддерживать списки любых типов, являющихся подтипами Number.
//Отфильтруйте и выведите в консоль списки целых чисел и вещественных чисел.


fun main() {
    val listOfElementsTInt: List<Int> = listOf(1,2,3,4,5) // список элементов типа T: Int (списки целых чисел)
    val listOfElementsTDouble: List<Double> = listOf(1.0,2.0,3.0,4.4,5.0) // список элементов типа T: Double (списки вещественных чисел)


// Выводим в консоль списки целых чисел и вещественных чисел.

    println("Список целых четных чисел: ${filterlistOfElementsT(listOfElementsTInt)}")
    println("Список четных вещественных чисел: ${filterlistOfElementsT(listOfElementsTDouble)}")

//8.5 Домашняя работа 2
//3. Используйте вызов функции filter с использованием лямбда-выражения и ссылки на функцию.

// обьединяем два имеющихся списка чисел
    val listOfElementsTAll = listOfElementsTInt + listOfElementsTDouble

    println("Список элементов двух типов чисел: ${listOfElementsTAll}")

// не понял что происходит в след строке, список который надо отфильтровать отправляем в класс Queue?
    val filterableQueue = Queue(listOfElementsTAll.toMutableList())

// вызов функции filter с использованием лямбда-выражения
    val lambdaFilter = filterableQueue.filterMethod { it -> it.toDouble()%2 == 0.0  }
println(lambdaFilter.toString())

// вызов функции filter с использованием ссылки на функцию
    val linkFilter = (filterableQueue::filterMethod)
println(linkFilter.toString())

}
// generic-функцию, принимающая на вход список элементов типа T (... tsT(list: List<T>):Li ...)
// Функция поддерживает списки элементов Т любых типов (... n <T:Number> fil ...), являющихся подтипами Number.

fun <T:Number> filterlistOfElementsT(list: List<T>):List<T> {

// Фильтруем список таким образом, чтобы в нём остались только чётные элементы.

    return list.filter { it.toDouble()%2 == 0.0 } // Возвращаем из функции список, с четными элементами типа T.

}


