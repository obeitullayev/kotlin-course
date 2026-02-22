package lessons.lesson24.homeworks

import kotlin.collections.plusAssign
import kotlin.text.compareTo

object Colors {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}

fun String.colorize(color: String): String {
    return "$color$this${Colors.RESET}"
}

// 2 Напиши функцию colorizeWords которая печатает слова из длинного предложения разбитого по пробелу разным цветом.
// Правило подбора цвета для каждого слова нужно передавать в виде функции, которая принимает слово и возвращает это же слово но уже "в цвете" через функцию colorize.
// Функция colorizeWords должна расширять строку и эту же строку и обрабатывать.

fun String.colorizeWords( transform: (String) -> String){
    val words = this.split(" ")//.joinToString(" ") {it.colorize(transform(it)) }

    for (word in words) {
        val color = transform(word)
        println(word.colorize(color))
    }
}

// Напиши несколько функций обработки слов:
//цвет слова зависит от его характеристик (для каждой характеристики отдельный цвет):
//начинается с большой буквы
//длина меньше трёх символов
//длина больше 6 символов
//длина кратна двум
//для всех прочих отдельный цвет.
//цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик. Когда счётчик доходит до края списка слов - он обнуляется и начинается заново.
//цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик. Счётчиком управляет функция, находящаяся в изменяемой переменной.
// Сначала это функция с инкрементом счётчика.
// Когда счётчик доходит до края списка цветов, нужно заменить функцию счётчика на функцию с декрементом. Когда счётчик доходит до нуля - заменить функцию счётчика на функцию с инкрементом и так далее.
//Создай переменную с длинным текстом (например из этого урока) и вызови у этой переменной функцию colorizeWords и передай в неё по очереди каждую из функций, проверь результат в консоли.

fun String.colorChoose (): String {
        val colored = when  {
            this[0].isUpperCase() -> Colors.RED
            this.length==2 -> Colors.BLUE
            this.length<3 -> Colors.GREEN
            this.length>6 -> Colors.YELLOW
            else -> Colors.WHITE
        }
    return colored
}


fun main() {
    val text = "Создай переменную с длинным текстом (например из этого урока) и вызови у этой переменной функцию colorizeWords и передай в неё по очереди каждую из функций, проверь результат в консоли."
    val colorList = listOf(Colors.RED, Colors.GREEN, Colors.YELLOW, Colors.BLUE, Colors.PURPLE, Colors.CYAN, Colors.WHITE)

//    ---
    text.colorizeWords{ it.colorChoose() }


//    ---
    var counter=0

    val str2= text.colorizeWords{  if (counter>=(colorList.size)) counter=0
        colorList[counter++]
    }

//    ---
    var counter2= {counter++}

    val str3= text.colorizeWords{
        if (counter==colorList.size-1) { counter2={counter--}
        }
        if (counter<0) {
            counter2={++counter}
        }
        colorList[counter2()]
    }
}