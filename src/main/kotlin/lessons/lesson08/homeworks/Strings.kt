package lessons.lesson08.homeworks

import com.sun.tools.javac.Main
import lessons.lesson06.homeworks.example1

//Преобразование строк
//Создайте функцию, которая будет анализировать входящие фразы и применять к ним различные преобразования, делая текст более ироничным или забавным. Функция должна уметь распознавать ключевые слова или условия и соответственно изменять фразу.
//
//Правила проверки и преобразования:
//
//Если фраза содержит слово "невозможно":
//Преобразование: Замените "невозможно" на "совершенно точно возможно, просто требует времени".
//Если фраза начинается с "Я не уверен":
//Преобразование: Добавьте в конец фразы ", но моя интуиция говорит об обратном".
//Если фраза содержит слово "катастрофа":
//Преобразование: Замените "катастрофа" на "интересное событие".
//Если фраза заканчивается на "без проблем":
//Преобразование: Замените "без проблем" на "с парой интересных вызовов на пути".
//Если фраза содержит только одно слово:
//Преобразование: Добавьте перед словом "Иногда," и после слова ", но не всегда".

fun example1(arg:String) {
    if ("невозможно" in arg) {
        println(arg.replace("невозможно", "совершенно точно возможно, просто требует времени"))
    } else if (arg.startsWith("Я не уверен")) {
        println("${arg}, но моя интуиция говорит об обратном")
    } else if ("катастрофа" in arg) {
        val index: Int = arg.indexOf("катастрофа")
        val after_sub_string: String = arg.substring(index+11)
        val before_sub_string: String = arg.substring(0, index)
        println("${before_sub_string} интересное событие ${after_sub_string}")
    } else if (arg.endsWith("без проблем")) {
        val index: Int = arg.indexOf("без проблем")
        val sub_string: String = arg.substring(0, index)
        println("${sub_string} с парой интересных вызовов на пути")
    } else if (!arg.contains(" ")) {
        println("Иногда, ${arg.lowercase()}, но не всегда")
    }
}

//2. Извлечение даты из строки лога
//У вас есть строка лога, например "Пользователь вошел в систему -> 2021-12-01 09:48:23" (данные могут быть любыми, но формат всегда такой).
// Извлеките отдельно дату и время из этой строки и сразу распечатай их по очереди. Используй indexOf или split для получения правой части сообщения.

fun  example2 (arg: String) {
    val index: Int = arg.indexOf("->")
    val data  = arg.substring(index+2, index+13)
    val time = arg.substring(index+13)
    val text = """
        Date: %s
        Time: %s
    """.trimIndent()
    println(text.format(data, time))
}

//3. Маскирование личных данных
//Дана строка с номером кредитной карты, например "4539 1488 0343 6467". Замаскируйте все цифры, кроме последних четырех, символами "*".

fun example3(arg: String) {
    val sub_str = arg.substring((arg.length)-4)
    val stars = "*".repeat((arg.length)-4)
    println( stars + sub_str)
}

//4. Форматирование адреса электронной почты.
//У вас есть электронный адрес, например "username@example.com". Преобразуйте его в строку "username [at] example [dot] com", используя функцию replace()

fun example4(arg: String) {
    val index_a = arg.indexOf("@")
    val index_dot = arg.indexOf(".")
    val sub_str_a = arg.substring(0, index_a)
    val sub_str_dot = arg.substring(index_a+1, index_dot)
    val sub_str_else = arg.substring(index_dot+1)
    println("${sub_str_a} [at] ${sub_str_dot} [dot] ${sub_str_else}")
}

//5. Извлечение имени файла из пути.
//Дан путь к файлу, например "C:/Пользователи/Документы/report.txt" или "D:/good.themes/dracula.theme" (может быть любым). Извлеките название файла с расширением.

fun example5(arg: String) {
    val array = arg.split("/")
    val fileName = array[array.size-1]
    println(fileName)
}

//6. Создание аббревиатуры из фразы.
//У вас есть фраза, например "Котлин лучший язык программирования" (может быть любой с разделителями слов - пробел). Создайте аббревиатуру из начальных букв слов (например, "ООП").
//Используйте split. Используйте for для перебора слов. Используйте var переменную для накопления первых букв.

fun example6(arg: String) {
    val array = arg.split(" ")
    var counter= ""
    for (i in array){
        counter+=i[0].uppercase()
    }
    println(counter)
}

fun main() {
    example1("Этот")
    example2("Пользователь вошел в систему -> 2021-12-01 09:48:23")
    example3("4539 1488 0343 6467")
    example4("username@example.com")
    example5("C:/Пользователи/Документы/report.txt")
    example6( "Котлин лучший язык программирования")
}