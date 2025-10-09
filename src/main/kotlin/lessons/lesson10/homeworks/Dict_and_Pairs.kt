package lessons.lesson10.homeworks


//1 Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
val mutableMap= mapOf<Int, Int>()

//2 Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
val MapDouble = mapOf(1.23f to 2.23, 2.33f to 2.32)

//3 Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
val mutableDict = mutableMapOf<Int, String>()

//4 Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
fun addNewPair(dict: MutableMap<Int, String> ) {
    dict[1] = "Kotlin";
    dict[2] = "Java";
    dict[3] = "JS"
    for ((key, value) in dict){
        println("$key:$value")
    }
}

//5 Используя словарь из предыдущего задания, извлеките значение, используя ключ.
// Попробуй получить значение с ключом, которого в словаре нет.
fun getValue(dict: MutableMap<Int, String>, key: Int){
        println("key:"+dict[key])
}

//6 Удалите определенный элемент из изменяемого словаря по его ключу.
fun deleteValue(dict: MutableMap<Int, String>, key: Int){
    dict.remove(key)
    println(dict)
}

//7 Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение.
// Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
val MapDouble2 = mapOf(1.23 to 0, 2.33 to 2)
fun division(dict: Map<Double, Int>){
    for ((key, value) in dict){
        if (value==0){println("бесконечность")}
        else {println(key/value)}
    }
}

//8 Измените значение для существующего ключа в изменяемом словаре.
fun newValue(dict: MutableMap<Int, String>, key: Int, value: String){
    dict[key]=value
    println(dict)
}

//9 Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
val firstDict = mapOf(1 to "Java", 2 to "Kotlin")
val secDict = mapOf(3 to "JS", 4 to "TS")
fun multiplyDict(dict1: Map<Int, String>, dict2: Map<Int, String>){
    val mutableDict = mutableMapOf<Int, String>();
    fun addDictToThird(dict: MutableMap<Int, String>, addedDict: Map<Int, String>){
        for ((key, value) in addedDict){
            dict[key]=value
        }
    }
    addDictToThird(mutableDict, dict1)
    addDictToThird(mutableDict,dict2)
    println(mutableDict)
}

//10 Создайте словарь, где ключами являются строки, а значениями - списки целых чисел.
// Добавьте несколько элементов в этот словарь.
val stringDict = mapOf("languages" to listOf("Java", "TS"), "programme" to listOf("Idea", "VSCode"))

//11 Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк. Добавь данные в словарь.
// Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку.
// Распечатай полученное множество.
val setDict = mapOf(1 to mutableSetOf("Java", "TS"), 2 to mutableSetOf("Idea", "VSCode"))
fun getSetAndAddValue(dict: Map<Int, MutableSet<String>>, key: Int, setVal: String){
    val value = dict[key]
    value?.add(setVal)
    println("$key:$value")
}

//12 Создай словарь, где ключами будут пары чисел.
// Через перебор найди значение у которого пара будет содержать цифру 5 в качестве первого или второго значения.
fun findValueFromPairs() {
    val intPairs = mapOf(Pair(1, 2) to "value", Pair(4, 5) to "value2")
    for ((key, value) in intPairs) {
        val (x, y) = key
        if (x==5 || y==5){println(value)}
    }
}


fun main(){
    addNewPair(mutableDict)
    getValue(mutableDict, 4)
    deleteValue(mutableDict, 2)
    division(MapDouble2)
    newValue(mutableDict, 1, "TS")
    multiplyDict(firstDict, secDict)
    getSetAndAddValue(setDict, 1, "Python")
    findValueFromPairs()
}


//Задачи на подбор оптимального типа для словаря

//1 Словарь библиотека: Ключи - автор книги, значения - список книг
val dictBookstore = mapOf<Pair<String, String>, Int>()

//2 Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
val dictPlants = mutableMapOf<String, List<String>>()

//3 Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
val quarterFinal = mapOf<String, List<String>>()

//4 Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
val treatmentCourse = mapOf<String, List<String>>()

//5 Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест
val travelDict = mapOf<String, Map<String, List<String>>>()
