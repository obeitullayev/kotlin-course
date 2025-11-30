package lessons.lesson23.homeworks

// 2 Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа. Сделай проверку, что входящее число больше нуля. Подсказка: для парсинга символа в число можно использовать функцию digitToInt()
//Создай аналогичную анонимную функцию.
//Создай аналогичное лямбда выражение с указанием типа.
//Создай лямбда выражение без указания типа.
//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.

// 1
fun sum(number: Number ): Int{
    return number.toString().sumOf { it.digitToInt() }
}

// 2
val sumAnonym = fun (number: Number): Int{
    return number.toString().sumOf { it.digitToInt() }
}

// 3
val sumLambda : (number: Number) -> Int =
    {
        number ->
        number.toString().sumOf { it.digitToInt() }
    }

// 4
val sumLambdaSimple = {
    number: Number ->
    number.toString().sumOf { it.digitToInt() }
}

fun main() {
    println(sum(2343242223))
    println(sumAnonym(2343242223))
    println(sumLambda(2343242223))
    println(sumLambdaSimple(2343242223))
}