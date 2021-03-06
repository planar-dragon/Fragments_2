package com.skillbox.Generics

//Задание 2. Класс очереди, которая хранит объекты любого типа в порядке очереди
//
//Напишите класс Queue<T>, который представляет из себя очередь. Есть два метода:
//enqueue(item: T) — item становится в конец очереди;
//dequeue(): T? — достаёт из очереди первый объект, если очередь пуста - возвращается null.


//8.5 Домашняя работа 2
//1. Используйте класс Queue из части 2 предыдущего домашнего задания.
//2. Добавьте метод «фильтр», который принимает функцию фильтрации элементов
// и возвращает новый объект очереди с отфильтрованными элементами.
//3. Используйте вызов функции filter с использованием лямбда-выражения и ссылки на функцию.


class Queue<T>(var queueItemT:MutableList<T> = mutableListOf<T>()) {
// Не понял почему надо было засунуть изменяемую переменную очереди (queue) в конструктор

//2. Добавьте метод «фильтр», который принимает функцию фильтрации элементов
// и возвращает новый объект очереди с отфильтрованными элементами.

    fun filterMethod(predicate: (T) -> Boolean): Queue<T> {
        val newQueue = Queue<T>()// Новый объект очереди
        for(item in queueItemT) // Итерация по коллекции очереди (queue)
            if (predicate(item)) newQueue.enqueue(item)
//        println(newQueue)
        return newQueue
    }

    fun enqueue(item: T) {
        queueItemT.add(item) // добавляем item в конец очереди (переменная queue)
    }

    fun dequeue(): T? {
        if (queueItemT.isNotEmpty()) {
            val firstObject = queueItemT[0] // переменная в которую добавляется обьект 0 индекса
            queueItemT.removeAt(0) // и удаляется обьект 0 индекса
            return firstObject // возвращается взятый из очереди обьект 0 индекса
        }
        else return null // список пустой, тогда возвращаем null

    }

    override fun toString(): String {
        return "Результат фильтрации $queueItemT"
    }


}