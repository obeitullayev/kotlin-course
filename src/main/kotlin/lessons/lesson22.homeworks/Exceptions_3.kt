package lessons.lesson22.homeworks

import kotlin.IndexOutOfBoundsException

// 12 Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий IndexOutOfBoundsException тип в качестве аргумента.
// Напиши код, который спровоцирует выброс IndexOutOfBoundsException, перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.

class NewSecondException(e: IndexOutOfBoundsException):RuntimeException(e)

fun throwIndexOutOfBoundsException(){
    try {
        val list = listOf(1,2,3,4)[6]
    } catch (e:IndexOutOfBoundsException){
        println("error: ${e.message}");
        throw NewSecondException(e)
    }
}

fun main() {
    throwIndexOutOfBoundsException()
}