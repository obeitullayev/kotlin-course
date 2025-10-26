package lessons.lesson15.homeworks

// 5. Второй класс должен получать список строк и вставлять их в начало контейнера но поочерёдно с теми данными, которые уже есть.
// То-есть, наш список должен появиться в контейнере по индексам 0, 2, 4 и так далее.


open class addListOfMaterialToContainer(
    material: String,
    weight: Int,
    val length: Int
): Materials(){
    fun addListByStep(ListStr: List<String>) {
        var i = 0
        val current = extractMaterials()
        val mergedList= mutableListOf<String>()
        while ( i < current.size ){
            if (i<ListStr.size){ mergedList.add(ListStr[i]) }
            if (i<current.size){ mergedList.add(current[i]) }
            i++
        }
        while (i<ListStr.size){
            mergedList.add(ListStr[i])
            i++
        }
        mergedList.forEach { addMaterial(it) }
    }
}

fun main() {
    // создаём контейнер
    val container = addListOfMaterialToContainer("Wood", 10, 5)

    // добавляем начальные материалы
    container.addMaterial("M1")
    container.addMaterial("M2")
    container.addMaterial("M3")

    println("=== До добавления списка ===")
    container.printContainer()
    // Ожидаемый вывод:
    // [0]: M1
    // [1]: M2
    // [2]: M3

    // список новых материалов для добавления
    val newMaterials = listOf("A", "B", "C", "D")

    // вызываем метод вставки через один
    container.addListByStep(newMaterials)

    println("=== После добавления списка ===")
    container.printContainer()
    // Ожидаемый вывод:
    // [0]: A   <- новые элементы на 0, 2, 4...
    // [1]: M1
    // [2]: B
    // [3]: M2
    // [4]: C
    // [5]: M3
    // [6]: D  <- оставшийся элемент из newMaterials
}
