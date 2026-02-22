package lessons.lesson07.homeworks


//Напишите цикл for, который выводит числа от 1 до 5.
fun example1() {
    for (i in 1..5){
        println(i)
    }
}

//Напишите цикл for, который выводит четные числа от 1 до 10.
fun example2() {
    for (i in 1..10){
        if (i%2==0)
            println(i)
    }
}

//Создайте цикл for, который выводит числа от 5 до 1.
fun example3() {
    for (i in 5 downTo 1){
        println(i)
    }
}

//Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
fun example4() {
    for (i in  10 downTo 1 step 2){
        println(i)
    }
}

//Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
fun example5() {
    for (i in  1..9 step 2){
            println(i)
    }
}

//Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
fun example6() {
    for (i in  1..20 step 3){
        println(i)
    }
}

//Создайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
val size: Int = 10

fun example7() {
    for (i in  3 until size step 2){
        println(i)
    }
}

//Создайте цикл while, который выводит квадраты чисел от 1 до 5.
fun example8() {
    var counter =0
    while (counter++<5) {
        println(counter*counter)
    }
}

//Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
fun example9() {
    var counter =10
    while (counter>5) {
        counter--
    }
    println(counter)
}

//Используйте цикл do while, чтобы вывести числа от 5 до 1.
fun example10() {
    var counter: Int = 5
    do {
        println(counter)
    } while (counter-->1)
}

//оздайте цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5.
fun example11() {
    var counter: Int = 5
    do {
        println(counter)
    } while (counter++<10)
}

//Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.
fun example12() {
    for (i in 1..10){
        println(i)
        if (i==6) break
    }
}

//Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10.
fun example13() {
    var counter =0
    while (true){
        println(counter++)
        if (counter==10) break
    }
}

//В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа.
fun example14() {
    for(i in 1..10){
        if (i%2==0) continue
        println(i)
    }
}

//Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
fun example15() {
    var counter =0
    while (counter++<10){
        if (counter%3==0) continue
        println(counter)
    }
}

fun main() {
    example1()
    example2()
    example3()
    example4()
    example5()
    example6()
    example7()
    example8()
    example9()
    example10()
    example11()
    example12()
    example13()
    example14()
    example15()
}
