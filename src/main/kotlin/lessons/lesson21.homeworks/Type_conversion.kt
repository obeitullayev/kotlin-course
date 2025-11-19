package lessons.lesson21.homeworks

import kotlin.math.absoluteValue
import kotlin.math.pow

// 1 Напишите функцию analyzeDataType, принимающую параметр типа Any. Функция должна определить тип аргумента и вывести соответствующее сообщение:
//Для строки: "Это строка: [значение]".
//Для любого числа: "Это число: [значение]".
//Для списка: "Это список, количество элементов: [количество]".
//Для словаря: "Это словарь, количество пар: [количество]".
//Для остальных типов: "Неизвестный тип данных".
//Используйте оператор is для проверки типов.

fun analyzeDataType(data: Any) {
    when (data) {
        is String -> {
            println("Это строка: $data")
        }

        is Number -> {
            println("Это число: $data")
        }

        is List<*> -> {
            println("Это список, количество элементов: ${data.size}")
        }

        is Map<*, *> -> {
            println("Это словарь, количество пар: ${data.size}")
        }

        else -> {
            println("Неизвестный тип данных")
        }
    }
}

// 2 Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка, если аргумент можно безопасно привести к типу List.
// В случае неудачного приведения функция должна возвращать -1. Используйте as? для безопасного приведения типа.

fun safeCastToList(data: Any): Int {
    val sizeActions = data
    return (data as? List<*>)?.size ?: -1
}

// 3 Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки, если аргумент можно привести к типу String.
// В случае, если аргумент равен null или не является строкой, функция должна возвращать 0.

fun getStringLengthOrZero(data: Any?): Int {
    return (data as? String )?.length ?: 0
}

// 4 Создайте функцию-расширение класса Any toSquare.
// Функция гарантированно вызывается у числа (в виде числа или строки, например 4 или 4.2 или “4.2”) и должна вернуть квадрат этого числа.
// Если придёт число, его нужно возвести в квадрат, если придёт строка, то его нужно преобразовать в число через функцию toDouble() и возвести в квадрат.

fun Any.toSquare(): Double {
    val number =when (this){
        is Number -> this.toDouble()
        is String -> this.toDouble()
        else -> throw IllegalArgumentException("Не является числом или строкой, представляющей число")
    }
    return number.pow(2)
}

// 5 Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех целочисленных (Int) и вещественных (Double) значений в списке.
// Все остальные типы должны быть проигнорированы.

fun sumIntOrDoubleValues(data: List<Any>): Double {
    var sum=0.0
    for (el in data){
        sum += when (el){
            is Int -> el.toDouble()
            is Double -> el
            else -> 0.0
        }}
    return sum
}

// 6 Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к типу List<*>.
// Если приведение успешно, функция должна напечатать все строки из списка, если элемент не является строкой то вывести предупреждение об этом.
// Если приведение неудачно, должно быть выведено сообщение об ошибке, не прерывая выполнение программы.

fun tryCastToListAndPrint(data: Any) {
    val list = data as? List<*>

    if (list == null) {
        println("Ошибка: аргумент не является списком.")
        return
    }

    for (element in list) {
        when (element) {
            is String -> println(element)
            else -> println("Предупреждение: элемент '$element' не является строкой.")
        }
    }
}

fun main(){
    analyzeDataType("Привет")
    analyzeDataType(123)
    analyzeDataType(listOf(1, 2, 3))
    analyzeDataType(mapOf("a" to 1, "b" to 2))
    analyzeDataType(3.14)
    analyzeDataType(true)
    println(4.toSquare())        // 16.0
    println(4.2.toSquare())      // 17.64
    println("4.2".toSquare())    // 17.64
    println("10".toSquare())     // 100.0
    val list = listOf(1, 2.5, "hello", 3, true, 4.4)
    println(sumIntOrDoubleValues(list))
    tryCastToListAndPrint(listOf("Привет", 123, "Мир"))
    tryCastToListAndPrint("не список")
}