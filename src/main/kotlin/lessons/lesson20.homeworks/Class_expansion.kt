package lessons.lesson20.homeworks

import org.jetbrains.annotations.Nullable
import kotlin.math.absoluteValue

// 1 Определите функцию-расширение для массива чисел, которая не принимает аргументов и возвращает пару из чисел - первое и последнее.
// Если массив был пуст то вернуть пару из null значений.

fun <T> Array<T?>.getArrayEdgeElements(): List<T?> {
    if (this.isEmpty()){
        return listOf(null,null)
    } else {
        return listOf(this[0], this[this.size-1])
    }
}

// 2 Создайте функцию-расширение для изменяемого списка элементов:
//с дженериком T ограниченным интерфейсом Comparable<T>
//которая принимает булево значение
//возвращает этот же список только в виде неизменяемого
//сам изменяемый список при этом должен стать отсортированным по возрастанию, если в функцию передано true и по убыванию,
// если false (используем функции sort() и sortDescending()

fun <T: Comparable<T>> MutableList<T>.getBoolToSort(boolean: Boolean): List<T> {
    if (boolean){
        this.sort()
    } else {
        this.sortDescending()
    }
    return this.toList()
}

// 3 Создайте функцию-расширение для nullable словаря с дженериком:
//Ключ является дженериком
//Значение является списком из дженериков
//Принимает целое число
//Возвращает nullable словарь из ключей изначального словаря приведённых к строке через toString()
//Значений из nullable дженерика, взятых из изначального ключа-списка по индексу из аргумента, если такого индекса нет - значением будет null

fun <T, V> Map<T, List<V>>?.extractByIndex(index: Int): Map<String, V?>? {
    return this?.map { (key, list) ->
        val value = list.getOrNull(index)
        key.toString() to value
    }?.toMap()
}

// 4 Реализуйте метод расширения within для класса Number, который проверяет, что текущее число отклоняется от эталонного не более допустимого значения.
// Метод принимает два параметра: other — число для сравнения и deviation — максимально допустимое отклонение. Метод должен возвращать true, если разница
// между текущим числом и числом для сравнения не превышает заданное отклонение.
// Протестируйте функцию на разных типах чисел. Для получения отклонения, у разницы чисел нужно вызвать свойство absoluteValue.

fun Number.within(other: Number, deviation: Number): Boolean {
    val diff = (this.toDouble() - other.toDouble()).absoluteValue
    return diff <= deviation.toDouble()
}


// 5 Реализуйте для класса String два метода расширения: encrypt и decrypt.
// Метод encrypt должен сдвигать каждый символ исходной строки на заданное число позиций вперед по таблице Unicode, а метод decrypt — на то же число позиций назад.
// Оба метода принимают один параметр base типа Int, который определяет величину сдвига. Протестируйте вашу реализацию, убедившись, что после шифрования и последующей
// расшифровки строка возвращается к исходному состоянию.

fun String.encrypt(base: Int): String {
    return this.map { char ->
        (char.code + base).toChar()
    }.joinToString("")
}

fun String.decrypt(base: Int): String {
    return this.map { char ->
        (char.code - base).toChar()
    }.joinToString("")
}

// 6 Многие уже знают любимую игру в Твиттере - собирание разных слов из букв через ответы (но мы то знаем что слово только одно, но не будем его называть).
// Напиши метод расширения строки, который будет принимать список имён пользователей и выводить в консоли исходную строку побуквенно в верхнем регистре в столбик:
// имя автора и букву под ним.

fun String.printByLetters(users: List<String>) {
    this.uppercase().forEachIndexed { index, char ->
        println(users.getOrNull(index) ?: "Unknown")
        println(char)
        println()
    }
}

fun main(){
    val list: Array<Int?> = arrayOf(1,2,3,4)
    val isEmpty = list.getArrayEdgeElements() // true
    println(isEmpty)
    val map: Map<Int, List<String>> = mapOf(
        1 to listOf("A", "B", "C"),
        2 to listOf("X"),
        3 to emptyList()
    )
    val result = map.extractByIndex(1)
    println(result)
    val original = "Hello, Привет! 123"
    val base = 5

    val encrypted = original.encrypt(base)
    val decrypted = encrypted.decrypt(base)

    println("Original:  $original")
    println("Encrypted: $encrypted")
    println("Decrypted: $decrypted")

    println("Restored correctly: ${original == decrypted}")

    val word = "Kotlin"
    val authors = listOf("Alice", "Bob", "Charlie")

    word.printByLetters(authors)
}