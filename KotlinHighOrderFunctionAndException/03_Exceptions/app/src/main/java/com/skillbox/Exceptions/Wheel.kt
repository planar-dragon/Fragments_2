package com.skillbox.Exceptions

//1. Создайте класс колеса Wheel.
//2. У колеса объявите переменную давления pressure типа double.
//        Будем считать, что это значение давления в атмосферах.
//        Начальное значение задайте равным нулю. Переменная должна быть публична для чтения, но закрыта для записи.
//3. Внутри класса Wheel объявите три класса исключений:
//        TooHighPressure — будет вызываться при слишком большом давлении;
//        TooLowPressure — будет вызываться при слишком малом давлении;
//        IncorrectPressure — будет вызываться при некорректном (отрицательном или слишком большом) значении давления.
//4. Для класса Wheel реализуйте метод setPressure (value).
//        Если подаваемое давление будет отрицательным или прeвышать 10 атмосфер, функция должна вызывать соответствующее исключение.
//5. Добавьте метод check, имитирующий проверку колеса.
//        Если значение давления в колесе не соответствует нормальному, необходимо вызывать соответствующее исключение.
//        Если всё нормально — не делать ничего.
//6. Реализуйте тестовые испытания — создайте колесо, попробуйте задать три разных значения — допустимое, нормальное и отрицательное.
//7. Добавьте обработчик исключений. В зависимости от типа ошибки выведите в консоль результаты испытаний
//        — произошла ли накачка колеса и можно ли его эксплуатировать.


//1. Создайте класс колеса Wheel.
class Wheel() {

//2. У колеса объявите переменную давления pressure типа double.
//Начальное значение задайте равным нулю. Переменная должна быть публична для чтения, но закрыта для записи.
    var pressure: Double = 0.0
        private set

//3. Внутри класса Wheel объявите три класса исключений:
    class TooHighPressure : Throwable(message = "Высокое давление!")

    class TooLowPressure: Throwable(message = "Низкое давление!")

    class IncorrectPressure: Throwable(message= "Неправильное давление, колесо ненакачано или взорвалось!" )

    class NormalPressure: Throwable(message = "Нормальное давление!")

// Так код длиннее - >>
//    class TooHighPressure : Throwable(){
//        override val message: String = "Высокое давление"}
//    class TooLowPressure: Throwable(){
//        override val message: String = "Низкое давление"}
//    class IncorrectPressure: Throwable() {
//        override val message: String = "Неправильное давление, колесо ненакачано или взорвалось!"}
//    class NormalPressure: Throwable() {
//        override val message: String = "Нормальное давление!"}

// 4. Для класса Wheel реализуйте метод setPressure (value).
    fun setPressure (value: Double) { // pressure - значение давления (pressure) в атмосферах
        if (value < 0 || value > 10) { // Если подаваемое давление будет отрицательным или прeвышать 10 атмосфер
            throw IncorrectPressure() // функция должна вызывать исключение IncorrectPressure
        } else println("Давление в реальных пределах!")
    }

// 5. Добавьте метод check, имитирующий проверку колеса.
    fun check (pressure: Double) {
        if (pressure in 2.51..10.0) {
            throw TooHighPressure()
        }

        if (pressure in 0.0..1.59) {
            throw TooLowPressure()
        }

        if (pressure in 1.6..2.5) {
            throw NormalPressure()
        }
    }
}