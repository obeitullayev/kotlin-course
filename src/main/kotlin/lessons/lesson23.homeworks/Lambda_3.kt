package lessons.lesson23.homeworks

import kotlin.IndexOutOfBoundsException

// Создай функцию-расширение списка чисел, которая будет возвращать множество дубликатов чисел (встречающихся в списке более одного раза).
//Создай аналогичную анонимную функцию.
//Создай аналогичное лямбда выражение с указанием типа.
//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.

// 1
fun List<Int>.double(): Set<Int>{
    return this.groupBy { it }
        .filter { it.value.size > 1 }
        .keys
}

// 2
val doubleAnonym = fun List<Int>.():  Set<Int>{
    return this.groupBy { it }
        .filter { it.value.size > 1 }
        .keys
}

// 3
val doubleLambda : List<Int>.() -> Set<Int> =
    {
         this.groupBy { it }
             .filter { it.value.size > 1 }
             .keys
}

fun main() {
    val list = listOf(1,2,3,4,5,1, 5)
    println(list.double())
    println(list.doubleAnonym())
    println(list.doubleLambda())
}