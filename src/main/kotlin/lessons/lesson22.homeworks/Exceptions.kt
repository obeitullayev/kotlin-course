package lessons.lesson22.homeworks

import lessons.lesson21.homeworks.toSquare
import kotlin.math.pow

// 1 Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
// NullPointerException
// IndexOutOfBoundsException
// ClassCastException
// IllegalArgumentException
// NumberFormatException
// IllegalStateException
// OutOfMemoryError
// StackOverflowError
// 9 Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок:

// NullPointerException
fun nullPointer(){
         try{
            val s: String? = null
            println(s!!.length)
        } catch(e: NullPointerException){
    }
    return
}

//IndexOutOfBoundsException
fun indexOut(){
    try{
        val s: String = "s"
        println(s[2])
    } catch(e: IndexOutOfBoundsException){
    }
    return
}

//ClassCastException
fun classCast(){
    try {
        val s: String = "s"
        s as Int
    } catch (e: ClassCastException){
   }
    return
}

//IllegalArgumentException
fun illegalArgument(s: String){
    try {
        require(s.isNotEmpty())
        println(s)
    } catch (e: IllegalArgumentException){ }
    return
}

//NumberFormatException

fun numberFormat(){
    try {
        val s: String = "s"
        s.toDouble()
    }catch (e: NumberFormatException){}
}

//IllegalStateException
fun illegalState(){
    try {
        val list = emptyList<Int>()
        if (list.isEmpty()) {
            throw IllegalStateException("List is empty")
        }
        list.first()
    }catch (e: IllegalStateException){}
}

//OutOfMemoryError
fun outOfMemory(){
    try {
        val list = emptyList<Int>()
        if (list.isNullOrEmpty()) {
            throw OutOfMemoryError()
        }
    }catch (e: OutOfMemoryError){}
}

//StackOverflowError
fun stackOverflow(n: Int = 0) {
    try {
        stackOverflow(n + 1)
    } catch (e: StackOverflowError) { }
}

// 10 Напиши функцию, которая принимает nullable аргумент типа Any и в блоке try/catch выполни набор действий с этим аргументом
// которые могут потенциально вызвать одно из исключений в этом же порядке:
//
//NullPointerException
//IndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//NumberFormatException
//IllegalStateException

// В блоке catch перехватывай исключение с общим типом Throwable а внутри через when определи тип исключения и выведи сообщение с названием исключения.
// Сразу после when выброси перехваченное исключение через throw, чтобы прекратить работу программы.
// Если аргумент функции не вызвал исключение, то выведи текст, сообщающий что переданный аргумент фантастически хорош!

fun  getterException(value: Any?){
    try {
        val nonNull = value!!

        // 2. IndexOutOfBoundsException
        val elem = value.toString()[2]

        // 3. ClassCastException
        val casted = value as String

        // 4. IllegalArgumentException
        require(casted.isNotEmpty())

        // 5. NumberFormatException
        val number = casted.toInt()

        // 6. IllegalStateException
        check(number != 42)

        println("аргумент фантастически хорош!")

    } catch (e: Exception){
        when (e){
            is NullPointerException -> {println("Произошёл NullPointerException"); throw e}
            is IndexOutOfBoundsException -> {println("Произошёл IndexOutOfBoundsException"); throw e}
            is ClassCastException -> {println("Произошёл ClassCastException"); throw e}
            is IllegalArgumentException -> {println("Произошёл IllegalArgumentException"); throw e}
            is NumberFormatException -> {println("Произошёл NumberFormatException"); throw e}
            is IllegalStateException -> {println("Произошёл IllegalStateException"); throw e}
        }
    }
}



// 4 Создайте функцию-расширение класса Any toSquare.
// Функция гарантированно вызывается у числа (в виде числа или строки, например 4 или 4.2 или “4.2”) и должна вернуть квадрат этого числа.
// Если придёт число, его нужно возвести в квадрат, если придёт строка, то его нужно преобразовать в число через функцию toDouble() и возвести в квадрат.


// 5 Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех целочисленных (Int) и вещественных (Double) значений в списке.
// Все остальные типы должны быть проигнорированы.


// 6 Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к типу List<*>.
// Если приведение успешно, функция должна напечатать все строки из списка, если элемент не является строкой то вывести предупреждение об этом.
// Если приведение неудачно, должно быть выведено сообщение об ошибке, не прерывая выполнение программы.


fun main(){
    nullPointer()
    indexOut()
    classCast()
    illegalArgument("")
    numberFormat()
    illegalState()
    outOfMemory()
    stackOverflow()
    getterException("132")
}