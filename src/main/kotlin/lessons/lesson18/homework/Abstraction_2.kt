package lessons.lesson18.homework
import java.io.ByteArrayInputStream
import java.io.InputStream

// Задача 2. Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс с реализацией методов
// (достаточно println с выполняемым действием).

abstract class PowerableDevice :
    Powerable,
    LightEmitting,
    SoundEmitting {

    abstract val brand: String
    abstract var isEnabled: Boolean

    override fun powerOn() {
        println("[$brand] ${this::class.simpleName} powered on.")
        isEnabled = true
        val fakeSound = ByteArrayInputStream("startup sound".toByteArray())
        playSound(fakeSound)
        emitLight()
    }

    override fun powerOff() {
        println("[$brand] ${this::class.simpleName} powered off.")
        isEnabled = false
        completeLiteEmission()
        mute()
    }

    override fun playSound(stream: InputStream) {
        if (isEnabled) {
            println("[$brand] Default: playing startup sound...")
        }
    }

    override fun emitLight() {
        if (isEnabled) {
            println("[$brand] Default: interface light ON.")
        }
    }

    abstract override fun completeLiteEmission()
    abstract override fun setVolume(volume: Int)
    abstract override fun mute()
}
