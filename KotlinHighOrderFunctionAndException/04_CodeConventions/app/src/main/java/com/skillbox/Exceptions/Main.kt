package com.skillbox.Exceptions

import kotlin.random.Random
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

fun main() {

//6. Реализуйте тестовые испытания — создайте колесо, попробуйте задать три разных значения — допустимое, нормальное и отрицательное.
    val wheel = Wheel()

//7. Добавьте обработчик исключений. В зависимости от типа ошибки выведите в консоль результаты испытаний
//        — произошла ли накачка колеса и можно ли его эксплуатировать.
    try {
        val checkedPressureValue: Double =
            Random.nextDouble(-5.0, 15.0) // создаем произвольное значение давления — допустимое, нормальное и отрицательное
        // для удобства округляем давления
        val checkedPressureValueFormat3 = String.format("%.2f", checkedPressureValue)
        println("Накачано давление в колесе = $checkedPressureValueFormat3 атмосферы")

        wheel.setPressure(checkedPressureValue) // проверяем правильное ли давление
        wheel.check(checkedPressureValue)// проверяем какое давление


    } catch (t: Wheel.IncorrectPressure) {
        println("Где-то ошибка - ${t.message}")

    } catch (t: Wheel.TooHighPressure) {
        println("Опастно для эксплуатации - ${t.message}")

    } catch (t: Wheel.TooLowPressure) {
        println("Опастно для эксплуатации - ${t.message}")

    } catch (t: Wheel.NormalPressure) {
        println("Все хорошо - ${t.message}")

    } finally {
        println("Испытание завершено!")
    }
}