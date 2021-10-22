package com.skillbox.Generics

//Задание 2. Класс очереди, которая хранит объекты любого типа в порядке очереди
//
//Напишите класс Queue<T>, который представляет из себя очередь. Есть два метода:
//enqueue(item: T) — item становится в конец очереди;
//dequeue(): T? — достаёт из очереди первый объект, если очередь пуста - возвращается null.

class Queue<T>(defaultValue: T) {

    var queueItemT = mutableListOf<T>() // Изменяемая переменная очереди (queue)

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
}