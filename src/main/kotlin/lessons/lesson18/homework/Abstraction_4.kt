package lessons.lesson18.homework
import java.io.ByteArrayInputStream
import java.io.InputStream

// Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться и с наследованием
// от программируемого оборудования. Также имплементируй интерфейсы.

abstract class TemperatureOpenableDevice : ProgrammableDevice(),
    TemperatureRegulatable,
    Openable {

    abstract var currentTemperature: Int
    abstract override val maxTemperature: Int

    override fun setTemperature(temp: Int) {
        if (temp > maxTemperature) {
            println("[$brand] Cannot set temperature to $temp°C — maximum is $maxTemperature°C.")
        } else {
            currentTemperature = temp
            println("[$brand] Temperature set to $currentTemperature°C.")
        }
    }

    override fun open() {
        println("[$brand] Device is now OPEN.")
    }

    override fun close() {
        println("[$brand] Device is now CLOSED.")
    }
}
