package com.skillbox.BaseMethods

class Person ( // Создаем класс Person со свойствами height (рост), weight (вес), name (имя).
    val height: Int, // height (рост)
    val weight: Int, // weight (вес)
    val name: String // name (имя)
)
{
    // Добавляем в класс Person поле(свойство) pets, которое хранит hashSet домашних животных типа Animal.
    val pets: HashSet<Animal> = hashSetOf()

    // Добавьте метод buyPet(), который создаёт объект класса Animal,
    // проинициализированный случайными значениями полей, и добавляет его в pets.
    fun buyPet(){
    val animalKind = listOf("Собака","Кошка","Хомяк","Крыса","Рыба","Змея","Ящерица")
    }

    //  Метод автоматической генерацией кода equals и hashCode
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (height != other.height) return false
        if (weight != other.weight) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = height.hashCode()
        result = 31 * result + weight.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    // Реализуем метод toString в классе Person, для возврата тектового представления обьекта.
    override fun toString(): String {
        return "Персонаж: имя = $name, рост = $weight, вес = $height"

    }
}