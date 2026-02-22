package lessons.lesson15.homeworks

//4. Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)

abstract class Materials {
    private val materials = mutableListOf<String>()
    fun addMaterial(material: String) {
        materials.add(material)
    }
    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }
    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}

open class AddToBottom(
    material: String,
    weight: Int,
    val length: Int
): Materials(){
    fun addMaterialToBottom(material: String) {
        val current = extractMaterials()
        addMaterial(material)
        current.forEach {
            addMaterial(it)
        }
    }
}

fun main() {
    val container = AddToBottom("Wood", 10, 5)

    // Добавляем начальные материалы
    container.addMaterial("M1")
    container.addMaterial("M2")
    container.addMaterial("M3")

    println("=== До добавления в дно ===")
    container.printContainer()
    // Ожидаемый вывод:
    // [0]: M1
    // [1]: M2
    // [2]: M3

    // Добавляем новый материал в "дно"
    container.addMaterialToBottom("NewBottom")

    println("=== После добавления в дно ===")
    container.printContainer()
    // Ожидаемый вывод:
    // [0]: NewBottom   <- новый элемент внизу (под индексом 0)
    // [1]: M1
    // [2]: M2
    // [3]: M3
}
