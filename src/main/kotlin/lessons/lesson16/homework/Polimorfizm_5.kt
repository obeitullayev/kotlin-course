package lessons.lesson16.homework

/*
Класс “Логгер”: представляет из себя инструмент для вывода информации в консоль с разным префиксами уровня логирования (INFO, WARNING, ERROR, DEBUG)
Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO
Выполнить перегрузку метода log, который:
Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом на красном фоне.
Принимает список сообщений и все их выводит с уровнем INFO
Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR
Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.
*/

object LogLevel {
    const val INFO = "INFO"
    const val WARNING = "WARNING"
    const val ERROR = "ERROR"
    const val DEBUG = "DEBUG"
}

open class Logger {
    val logLevel = listOf("INFO", "WARNING", "ERROR", "DEBUG")

    open fun log(message: String) {
        println("${Colors.CYAN}[INFO]${Colors.RESET} $message")
    }

    open fun log(level: String, message: String) {
        when (level) {
            LogLevel.INFO -> println("${Colors.CYAN}[INFO]${Colors.RESET} $message")
            LogLevel.WARNING -> println("${Colors.YELLOW}[WARNING]${Colors.RESET} $message")
            LogLevel.ERROR -> println("${Background.RED}${Colors.WHITE}[ERROR]${Colors.RESET} $message")
            LogLevel.DEBUG -> println("${Colors.PURPLE}[DEBUG]${Colors.RESET} $message")
        }
    }

    open fun log(messages: List<String>) {
        for (msg in messages) {
            println("${Colors.CYAN}[INFO]${Colors.RESET} $msg")
        }
    }

    open fun log(e: Exception) {
        println("${Background.RED}${Colors.WHITE}[ERROR]${Colors.RESET} ${e.message}")
    }
}

fun main() {
    val logger = Logger()

    logger.log("Приложение запущено.") // INFO
    logger.log(LogLevel.WARNING, "Низкий заряд батареи!") // WARNING
    logger.log(LogLevel.ERROR, "Файл не найден!") // ERROR
    logger.log(LogLevel.DEBUG, "Загрузка модуля завершена.") // DEBUG

    logger.log(listOf("Первое сообщение", "Второе сообщение", "Третье сообщение"))

    try {
        throw Exception("Что-то пошло не так.")
    } catch (e: Exception) {
        logger.log(e)
    }
}