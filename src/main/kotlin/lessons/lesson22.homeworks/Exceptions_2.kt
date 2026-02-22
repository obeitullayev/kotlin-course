package lessons.lesson22.homeworks

// 11 Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст. Выброси это исключение в main

class NewException (message: String):AssertionError(message)

fun main() {
    val exception = NewException("test")
    throw exception
}