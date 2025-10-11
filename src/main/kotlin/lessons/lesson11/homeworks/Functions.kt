package lessons.lesson11.homeworks
//Задачи на сигнатуру метода
//Напишите сигнатуру метода в которую входит модификатор доступа, название функции, список аргументов с типами и возвращаемое значение.
// В теле метода можешь сделать возврат объекта нужного типа если это требуется для устранения ошибок.

//1 Не принимает аргументов и не возвращает значения.
public fun emptyFunc(){}

//2 Принимает два целых числа и возвращает их сумму.
public fun getSum(x: Int, y: Int): Int{
    return x+y
}

//3 Принимает строку и ничего не возвращает.
public fun setString(x: String){
}

//4 Принимает список целых чисел и возвращает среднее значение типа Double.
val avgList= listOf(1,2,3,4)
public fun getAverage(x: List<Int>): Double{
    return x.average()
}

//5 Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun getStringLength(x: String?): Int?{
    return x?.length
}

//6 Не принимает аргументов и возвращает nullable вещественное число.
public fun getNullTemp(): Float?{
    val sensorAvailable = false

    return if (sensorAvailable) {
        36.6f
    } else {
        null
    }
}

//7 Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле
private fun setNullList(x: List<Int>?){
}

//8 Принимает целое число и возвращает nullable строку.
public fun getNullString(x: Int): String?{
    val variable=true

    return if (variable) {
        "true"
    }  else {
        null
    }
}

//9 Не принимает аргументов и возвращает список nullable строк.
public fun getNullListString(): List<String>?{
    val variable=true

    return if (variable) {
        listOf("1","2","3")
    }  else {
        null
    }
}

//10 Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
public fun getListString(x: String?, y: Int?): Boolean?{
    val variable=true

    return if (variable) {
        true
    }  else {
        null
    }
}

// Задачи на написание кода
//Напишите валидную сигнатуру метода а так же рабочий код для задач.
//
//11 Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
public fun multiplyByTwo(x: Int): Int= x*2

//12 Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
public fun isEven(x: Int): Boolean= x%2==0

//13 Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n.
// Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.

public fun printNumbersUntil(n: Int){
    if (n<1) return
    for (i in 1..n) println(i)
}

//14 Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке.
// Если отрицательных чисел нет, функция должна вернуть null.
public fun findFirstNegative(x: List<Int>): Int?{
    for (i in x){
        if (i<0) {
            return i}
    }
    return null
}

//15 Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку.
// Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
public fun processList(x: List<String?>){
    for (i in x){
        if (i is String) {
            println(i)
        } else {
            return
        }
    }
}

fun main(){
    getSum(1,2)
    getAverage(avgList)
    getStringLength("test")
    getNullTemp()
    getNullString(1)
    getNullListString()
    getListString("test", 1)
    multiplyByTwo(1)
    isEven(1)
    printNumbersUntil(-1)
    findFirstNegative(listOf(1,2,3))
    processList(listOf("Kotlin", null, "Java"))
}