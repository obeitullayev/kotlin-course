package lessons.lesson18.homework
import java.io.InputStream

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

//Холодильник
abstract class Refrigerator1:
    Powerable,
    Openable,
    TemperatureRegulatable,
    AutomaticShutdown,
    LightEmitting,
    SoundEmitting,
    Programmable{

    abstract val brand: String
    abstract val capacity: Int
    abstract override val maxTemperature: Int
    abstract val doorsCount: Int
}

// Стиральная машина
abstract class WashingMachine1:
    Powerable,
    Openable,
    TemperatureRegulatable,
    AutomaticShutdown,
    LightEmitting,
    SoundEmitting,
    Programmable,
    WaterConnection,
    Drainable,
    Timable,
    Cleanable {

    abstract val brand: String
    abstract val capacity: Int
    abstract override val maxTemperature: Int
    abstract override val sensorType: String
    abstract override val maxSensoredValue: Int
}

// Умная лампа
abstract class SmartLamp:
    Powerable,
    TemperatureRegulatable,
    AutomaticShutdown,
    LightEmitting,
    Programmable,
    Timable{

    abstract override val sensorType: String
    abstract override val maxSensoredValue: Int
}

// Электронные часы
abstract class SmartWatch:
    Powerable,
    TemperatureRegulatable,
    Programmable,
    Timable,
    BatteryOperated,
    Rechargeable,
    SoundEmitting{

    abstract val brand: String
    abstract val model: String
}

// Робот-пылесос
abstract class SmartCleaner:
    Powerable,
    Programmable,
    Timable,
    BatteryOperated,
    Rechargeable,
    SoundEmitting,
    Movable,
    Mechanical,
    LightEmitting,
    AutomaticShutdown,
    WaterContainer{

    abstract val brand: String
    abstract override val capacity: Int
    abstract override val sensorType: String
    abstract override val maxSensoredValue: Int
}

// Механические часы
abstract class MechanicalWatch :
    Mechanical,
    Timable {
    abstract val brand: String
    abstract val model: String
    abstract val mechanismType: String
}

//Фонарик
abstract class Flashlight : Powerable, LightEmitting, BatteryOperated {
    abstract val brightness: Int
    abstract val batteryType: String
}


//Кофемашина
abstract class CoffeeMachine :
    Powerable,
    WaterContainer,
    WaterConnection,
    TemperatureRegulatable,
    Drainable,
    Programmable,
    Cleanable {

    abstract val brand: String
    abstract val model: String
    abstract val pressure: Int
    abstract override val capacity: Int
    abstract override val maxTemperature: Int
}

//Умная колонка
abstract class SmartSpeaker :
    Powerable,
    SoundEmitting,
    Programmable,
    Cleanable,
    Rechargeable {

    abstract val brand: String
    abstract val model: String
    abstract val maxVolume: Int
}


