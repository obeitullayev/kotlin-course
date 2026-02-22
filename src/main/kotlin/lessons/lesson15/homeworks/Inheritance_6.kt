package lessons.lesson15.homeworks

// 6. Третий класс при добавлении строки должен отсортировать весь список метиралов в алфавитном порядке включая добавляемый материал.


open class sortedMaterials(
    material: String,
    weight: Int,
    val length: Int
): Materials(){
    fun makeSortedMaterials(ListStr: List<String>) {
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
        mergedList.sort()
        mergedList.forEach { addMaterial(it) }
    }
}

fun main() {
    val container = sortedMaterials("Wood", 10, 5)

    // Добавляем начальные материалы
    container.addMaterial("Banana")
    container.addMaterial("Apple")
    container.addMaterial("Cherry")

    println("=== До сортировки ===")
    container.printContainer()
    // [0]: Banana
    // [1]: Apple
    // [2]: Cherry

    // Новые материалы для добавления
    val newMaterials = listOf("Date", "Fig", "Elderberry")

    container.makeSortedMaterials(newMaterials)

    println("=== После сортировки ===")
    container.printContainer()
    // Ожидаемый вывод (алфавитный порядок):
    // [0]: Apple
    // [1]: Banana
    // [2]: Cherry
    // [3]: Date
    // [4]: Elderberry
    // [5]: Fig
}
