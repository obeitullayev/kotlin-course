package lessons.lesson18.homework

// Задача 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью устанавливать температуру и открываться.
// Пусть это будет холодильник, стиральная машина, чайник, духовка. Добавь недостающие интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия).
// Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы) не имеет смысла при выключенном питании - добавь эту проверку.
//Создай объекты этих устройств и позапускай их с различными методами.


// Холодильник
class Refrigerator(override val brand: String) : TemperatureOpenableDevice() {

    override var isEnabled: Boolean = false
    override var currentTemperature: Int = 5
    override val maxTemperature: Int = 10

    override fun completeLiteEmission() {
        println("[$brand] Refrigerator interior light OFF.")
    }

    override fun setVolume(volume: Int) {
        println("[$brand] Beep volume set to $volume.")
    }

    override fun mute() {
        println("[$brand] Sound muted.")
    }
}

// Стиральная машина
class WashingMachine(override val brand: String) : TemperatureOpenableDevice() {

    override var isEnabled: Boolean = false
    override var currentTemperature: Int = 30
    override val maxTemperature: Int = 90

    override fun completeLiteEmission() {
        println("[$brand] Washing machine light OFF.")
    }

    override fun setVolume(volume: Int) {
        println("[$brand] Beep volume set to $volume.")
    }

    override fun mute() {
        println("[$brand] Sound muted.")
    }
}

// Чайник
class Kettle(override val brand: String) : TemperatureOpenableDevice() {

    override var isEnabled: Boolean = false
    override var currentTemperature: Int = 25
    override val maxTemperature: Int = 100

    override fun completeLiteEmission() {
        println("[$brand] Kettle light OFF.")
    }

    override fun setVolume(volume: Int) {
        println("[$brand] Beep volume set to $volume.")
    }

    override fun mute() {
        println("[$brand] Sound muted.")
    }
}

// Духовка
class Oven(override val brand: String) : TemperatureOpenableDevice() {

    override var isEnabled: Boolean = false
    override var currentTemperature: Int = 0
    override val maxTemperature: Int = 250

    override fun completeLiteEmission() {
        println("[$brand] Oven light OFF.")
    }

    override fun setVolume(volume: Int) {
        println("[$brand] Beep volume set to $volume.")
    }

    override fun mute() {
        println("[$brand] Sound muted.")
    }
}

fun main() {
    val fridge = Refrigerator("LG")
    val washer = WashingMachine("Bosch")
    val kettle = Kettle("Philips")
    val oven = Oven("Samsung")

    // Холодильник
    fridge.powerOn()
    fridge.open()
    fridge.setTemperature(7)
    fridge.programAction("Cooling program")
    fridge.execute()
    fridge.close()
    fridge.powerOff()

    println("--")

    // Стиральная машина
    washer.powerOn()
    washer.programAction("Cotton 60°C")
    washer.setTemperature(60)
    washer.execute()
    washer.powerOff()

    println("--")

    // Чайник
    kettle.powerOn()
    kettle.setTemperature(90)
    kettle.programAction("Boil water")
    kettle.execute()
    kettle.powerOff()

    println("--")

    // Духовка
    oven.powerOn()
    oven.setTemperature(200)
    oven.programAction("Bake cake")
    oven.execute()
    oven.powerOff()
}
