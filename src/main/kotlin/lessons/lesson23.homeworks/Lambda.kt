package lessons.lesson23.homeworks

import kotlin.collections.isNotEmpty
import kotlin.text.isNotEmpty

// 1 Создай функцию, которая принимает список чисел и возвращает среднее арифметическое всех чётных чисел этого списка. С помощью require проверь, что список не пустой.
//Создай аналогичную анонимную функцию.
//Создай аналогичное лямбда выражение с указанием типа.
//Создай лямбда выражение без указания типа.
//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).

// 1
fun avg(list: List<Int>): Double{
    require(list.isNotEmpty())
    return list.filter { it % 2 == 0 }.average()
}

// 2
val avgAnonym = fun (list: List<Int>): Double{
    require(list.isNotEmpty())
    return list.filter { it % 2 == 0 }.average()
}

// 3
val avgLambda : (list: List<Int>) -> Double =
    {
        list ->
        require(list.isNotEmpty())
        list.filter { it % 2 == 0 }.average()
}

// 4
val avgLambdaSimple = {
        list: List<Int> ->
        require(list.isNotEmpty())
        list.filter { it % 2 == 0 }.average()
    }

fun main(){
    println(avg(listOf(1,2,3,4,5)))
    println(avgAnonym(listOf(1,2,3,4,5)))
    println(avgLambda(listOf(1,2,3,4,5)))
    println(avgLambdaSimple(listOf(1,2,3,4,5)))
}