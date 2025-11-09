package lessons.lesson18.homework
import java.io.ByteArrayInputStream
import java.io.InputStream

// Задача 3. Создай абстрактный класс для программируемого оборудования (с имплементацией соответствующего интерфейса и реализацией методов) и
// наследуй его от абстрактного класса включаемого оборудования.

abstract class ProgrammableDevice : PowerableDevice(), Programmable {

    private var currentProgram: String? = null

    override fun programAction(action: String) {
        currentProgram = action
        println("[$brand] Programmed action: \"$action\".")
    }

    override fun execute() {
        if (!isEnabled) {
            println("[$brand] Device is OFF. Turn it on before executing a program.")
            return
        }

        if (currentProgram == null) {
            println("[$brand] No program selected.")
        } else {
            println("[$brand] Executing program: \"$currentProgram\"...")
        }
    }
}
