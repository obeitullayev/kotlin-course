package lessons.lesson16.homework

import kotlin.collections.forEachIndexed

/*
Создай абстрактный принтер, который имеет абстрактный метод печати, принимающий в качестве аргумента строку.
Создай классы наследники: лазерный и струйный
Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно чёрными буквами
на белом фоне (хорошо работает на тёмной теме)
Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно цветными буквами
на цветном фоне. Слова должны быть разноцветны. Можно сделать список пар с цветом текста и фона и проходить циклически
по этому списку при выводе текста. Проверить работу на длинном тексте
*/

abstract class Printer(
){
    open fun print(arg: String){
        println("" )
    }
}
open class Laser(): Printer(){
    override fun print(arg: String){
        val splitString = arg.split(" ")
        for (i in splitString){
            println("${Colors.BLACK} ${Background.WHITE} $i ${Colors.RESET}")
        }
    }
}

open class Inkjet(): Printer(){
    override fun print(arg: String){
        val words = arg.split(" ")
        val textColors = listOf(Colors.RED, Colors.GREEN, Colors.YELLOW)
        val backColors = listOf(Background.WHITE, Background.BLACK, Background.CYAN)
        words.mapIndexed { index, word ->
            val color = textColors[index % textColors.size]
            val backColor = backColors[index % backColors.size]
            println("$color$backColor$word${Colors.RESET}")
        }

    }
}

fun main(){
    val printer = Inkjet()
    printer.print("Hello Kotlin Laser Printer Hello Kotlin Laser Printer Hello Kotlin Laser Printer" )
}
