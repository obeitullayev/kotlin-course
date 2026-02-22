package lessons.lesson19.homeworks

import org.jetbrains.annotations.Nullable

// 1 Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент, если он существует, иначе возвращать null.
// Например, у списка из четырёх элементов - среднего элемента нет.

fun <T > getMiddleElement(list: List<T>): T? {
    if (list.size%2==0){
        return null
    } else {
        val el= (list.size/2).toInt()
        println((list.elementAt(el)))
        return (list.elementAt(el))
    }
}

// 2 Напиши класс ListHolder, который будет хранить список элементов типа T и иметь метод для добавления нового элемента и получения всех элементов в виде неизменяемого списка.

class ListHolder<T>
    (val elements: MutableList<T> = mutableListOf()){
    fun addElement(el: T): List<T>{
        elements.add(el)
        println(elements)
        return elements.toList()
    }
}

// 3 Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
//  1 элементов одного типа в элементы другого типа
//  2 списка элементов одного типа в список элементов другого типа
interface Mapper<T, R> {
      fun map(item: T):R
      fun mapList(items: List<T>):List<R>
}

// 4 Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>.
// Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов.
// Метод преобразования списков с аналогичной механикой.

class PhrasesToListOfStrings:Mapper<String,List<String>>{
    override fun map(item: String): List<String>{
        val result = item.split(" ")
        println(result)
        return result
    }

    override fun mapList(items: List<String>): List<List<String>>{
        val result = items.map { it.split(" ") }
        println(result)
        return result
    }
}

// 5 Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками и возвращает словарь, в котором ключ и значения поменялись местами.

fun <T, R> transposition(mapper: Map<T,R>):Map<R,T>{
    val newMap = mapper.map { it.value to it.key }
    println(newMap.toMap())
    return newMap.toMap()
}

// 6 Напиши интерфейс Validator с дженериком с функцией валидации, которая будет принимать элемент с типом дженерика и возвращать булево значение.
interface Validator<T> {
    fun validate(item: T): Boolean
}

// 7 Создай класс StringValidator и имплементируй интерфейс Validator с типом String?.
// Реализуй проверку, что строка не является null, не пустая и не состоит из одних пробелов.

class StringValidator: Validator<String?> {
    override fun validate(item: String?): Boolean {
        return !item.isNullOrBlank()
    }
}

// 8 Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int. Реализуй проверку, что число чётное.
class OddValidator: Validator<Int> {
    override fun validate(item: Int) = item % 2 == 0
}

// 9 Создай класс ListValidator с дженериком, ограниченным типом Number, имплементируй интерфейс Validator типизированный по типу List с nullable типом дженерика класса
//Реализуй проверку:
//Ни один элемент списка не является null
//Ни один элемент приведённый к типу Double не равен 0.0

class ListValidator <T: Number>: Validator<List<T?>> {
    override fun validate(item: List<T?>): Boolean {
        return item.all { it != null && it.toDouble() != 0.0 }
    }
}

fun main(){
    getMiddleElement(listOf(1,2,3,4,5,6,7))
    val list = ListHolder<String>()
    list.addElement("1")
    list.addElement("2")
    list.addElement("2")
    val mapper = PhrasesToListOfStrings()
    val single = mapper.map("Hello world from Kotlin")
    val list2 = mapper.mapList(listOf("Hello world", "Kotlin is fun"))
    transposition(mapOf(1 to 2, 3 to 4))
}