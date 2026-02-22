package lessons.lesson09.homeworks

import lessons.lesson05.homeworks.count

//Работа с массивами Array
//1 Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
val arr: Array<Int> = arrayOf(1, 2, 3, 4, 5)

//2 Создайте пустой массив строк размером 10 элементов.
val arr2 = Array(10) {""}

//3 Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
fun ex(){
    val arr= DoubleArray(5)
    for (i in arr.indices){
        arr[i]=(i*2).toDouble()
        println(arr[i])
    }
}

//4 Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
fun ex2(){
    val arr = arrayOfNulls<Int>(5)
    for (i in arr.indices){
        arr[i]=(i*3)
        println(arr[i])
    }
}

//5 Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
fun ex3(){
    val arr= arrayOfNulls<String>(3)
    for (i in arr.indices){
        if (i > 0) {
            arr[i]="str"}
        println(arr[i])
    }
}

//6 Создайте массив целых чисел и скопируйте его в новый массив в цикле.
fun ex4(){
    val arr: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val arr2= arrayOfNulls<Int>(5)
    for (i in arr.indices){
        arr2[i]=arr[i]
        println(arr2[i])
    }
}

//7 Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
fun ex5(){
    val arr: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val arr2: Array<Int> = arrayOf(5,6,7,8,9,10)
    val arr3= IntArray(5)
    for (i in arr.indices){
        arr3[i]=arr2[i]-arr[i]
        println(arr3[i])
    }
}

//8 Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
fun ex6(){
    val arr: Array<Int> = arrayOf(1, 2, 3, 4, 4, 5)
    var index=0
    var found=-1
    while (index < arr.size ){
        if (arr[index] == 5) {
            found=index
            break
        }
        index++
    }
    println(found)
}

//9 Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль.
// Напротив каждого элемента должно быть написано “чётное” или “нечётное”.

fun ex7(){
    val arr: Array<Int> = arrayOf(1, 2, 3, 4, 6, 5)
    var index=0
    while (index < arr.size ){
        if (arr[index]%2 == 0) {
            println("${arr[index]} = чётное")
        }
        else println("${arr[index]} = нечётное")
        index++
    }
}

//10 Создай функцию, которая принимает массив строк и строку для поиска.
// Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
fun ex8(arr: Array<String>, search: String){
    val res= arr.contains(search)
    if (res) {println(search)}
    else println("not found")
}

//Работа со списками List
//1 Создайте пустой неизменяемый список целых чисел.
val list: List<Int> = emptyList()

//2 Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
val list2: List<String> = listOf("Hello", "World", "Kotlin")

//3 Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
var list3: MutableList<Int> = mutableListOf(1,2,3,4,5)

//4 Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
fun ex9(list: MutableList<Int>, arr: Array<Int>){
    var count = 0
    while (count < arr.size){
        list.add(arr[count])
        count++
    }
    println(list)
}

//5 Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
val list4: MutableList<String> = mutableListOf("Hello", "World", "Kotlin")
fun ex10(list: MutableList<String>, del: String){
    list.remove(del)
    println(list)
}

//6 Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
fun ex11(){
    val list: List<Int> = listOf(1,2,3,4,5)
    for (i in list){
        println(i)
    }
}

//7 Создайте список строк и получите из него второй элемент, используя его индекс.
fun ex12(){
    val list: List<String> = listOf("Hello", "World", "Kotlin")
    println(list[1])
}

//8 Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое значение).
fun ex13(list: MutableList<Int>, num: Int){
    list[2]=55
    println(list)
}

//9 Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
fun ex14(){
    val list: List<String> = listOf("Hello", "World", "Kotlin")
    val list2: List<String> = listOf("Hello1", "World1", "Kotlin1")
    val newlist: MutableList<String> = mutableListOf()
    var count=0
    while (count<list.size) {
        newlist.add(list[count])
        newlist.add(list2[count])
        count++
    }
    println(newlist)
}

//10 Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
fun ex15(list: MutableList<Int>){
    var max=list[0];
    var min=list[0];
    var count=1
    while (count<list.size) {
        if (list[count] > max) {
            max = list[count];
        }
        if (list[count]<min){
            min = list[count];
        }
        count++
    }
    println(max)
    println(min)
}

//11 Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
fun ex16(list: MutableList<Int>) {
    val list2: MutableList<Int> = mutableListOf()
    for (index in list.indices) {
        if (list[index] % 2 == 0) {
            list2.add(list[index])
        }
    }
    println(list2)
}

//Работа с Множествами Set
//1 Создайте пустое неизменяемое множество целых чисел.
val set: Set<Int> = setOf()

//2 Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
val set2: Set<Int> = setOf(1,2,3)

//3 Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
val set3: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")

//4 Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
fun ex17(set: MutableSet<String>, list: List<String>) {
    for (i in list.indices){
        set.add(list[i])
    }
    println(set)
}

//5 Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
fun ex18( el: Int ) {
    val set: MutableSet<Int> = mutableSetOf(1,2,3,4)
    set.remove(el)
    println(set)
}

//6 Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
fun ex19( set: Set<Int> ) {
    for (i in set){
        println(i)
    }
}

//7 Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка.
// Нужно вернуть булево значение true если строка есть. Реши задачу через цикл.
fun ex20(set: Set<String>, search: String){
    var res = false
    for (i in set){
        if (i == search){res = true}
    }
    println(res)
}

//8 Создайте множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
fun ex21(){
    val set: Set<String> = setOf("Kotlin", "Java", "Scala")
    val list: MutableList<String> = mutableListOf()
    for (i in set){
        list.add(i)
    }
    println(list)
}

fun main(){
    ex()
    ex2()
    ex3()
    ex4()
    ex5()
    ex6()
    ex7()
    ex8(arrayOf("1", "2", "3", "4", "4", "5"), "5")
    ex9(list3, arr)
    ex10(list4, "Hello")
    ex11()
    ex12()
    ex13(list3, 44)
    ex14()
    ex15(list3)
    ex16(list3)
    ex17(set3, list2)
    ex18( 2)
    ex19(set2)
    ex20(set3, "Java")
    ex21()
}