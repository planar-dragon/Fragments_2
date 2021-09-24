package com.skillbox.BaseMethods

class Person( // Создаем класс Person со свойствами height (рост), weight (вес), name (имя).
    val height: Int, // height (рост)
    val weight: Int, // weight (вес)
    val name: String // name (имя)
) {
    // Добавляем в класс Person поле(свойство) pets, которое хранит hashSet домашних животных типа Animal.
    val pets: HashSet<Animal> = hashSetOf()

    // Добавьте метод buyPet(), который создаёт объект класса Animal,
    // проинициализированный случайными значениями полей, и добавляет его в pets.
    fun buyPet() {
        // переменная списка домашних животных
        val animalName = listOf("Собака","Кошка","Хомяк","Крыса","Рыба","Змея","Ящерица","Утка","Гусь","Пони")
        // объект класса Animal, проинициализированный случайными значениями полей
        val animalKind = Animal((1 until 100).random(), (1 until 100).random(), animalName.random())
        // val animalKind = Animal(Random.nextInt(0,100), Random.nextInt(0,100), animalName.random())
        // val animalKind = Animal(energy.add((0..99).random()), weight.add((0..99).random()), animalName.random())

        // добавляем созданный обьект Animal в список pets.
        pets.add(animalKind)
        pets.forEach {
            println(it)

        }

    }

    //  Метод автоматической генерацией кода equals и hashCode
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (height != other.height) return false
        if (weight != other.weight) return false
        if (name != other.name) return false
        if (pets != other.pets) return false

        return true
    }

    override fun hashCode(): Int {
        var result = height
        result = 31 * result + weight
        result = 31 * result + name.hashCode()
        result = 31 * result + pets.hashCode()
        return result
    }

    // Реализуем метод toString в классе Person, для возврата тектового представления обьекта.
    override fun toString(): String {
        return "Персона: имя = $name, рост = $weight, вес = $height. Имеет животное $pets"

    }
}