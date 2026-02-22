package lessons.lesson15.homeworks

// 7. Четвёртый класс должен принимать словарь (ключи и значения строки).
// Каждая пара ключа и значения должна попадать в контейнер следующим образом - ключ в начало, значение в конец.
// Таким образом в начале должны быть ключи в обратном порядке, потом существующие материалы, потом все значения.


open class mapMaterials(
    material: String,
    weight: Int,
    val length: Int
): Materials(){

    fun addMappedMaterials(mapKeyValue: Map<String, String>) {
        val current = extractMaterials()
        val mergedList= mutableListOf<String>()
        mapKeyValue.keys.sortedDescending().forEach { mergedList.add(it) }
        mergedList.addAll(current)
        mergedList.addAll(mapKeyValue.values)
        mergedList.forEach { addMaterial(it) }
    }
}

fun main() {
    // создаём экземпляр подкласса
    val container = mapMaterials("Wood", 10, 5)

    // добавляем какие-то начальные материалы
    container.addMaterial("M1")
    container.addMaterial("M2")

    println("=== До map ===")
    container.printContainer()
    // Ожидаемый вывод:
    // [0]: M1
    // [1]: M2

    // создаём словарь ключ-значение
    val map = mapOf(
        "A" to "1",
        "B" to "2",
        "C" to "3"
    )

    // вызываем метод
    container.addMappedMaterials(map)

    println("=== После map ===")
    container.printContainer()
    // Ожидаемый вывод:
    // [0]: C   <- ключи в обратном порядке
    // [1]: B
    // [2]: A
    // [3]: M1  <- старые материалы посередине
    // [4]: M2
    // [5]: 1   <- значения в конце
    // [6]: 2
    // [7]: 3
}
