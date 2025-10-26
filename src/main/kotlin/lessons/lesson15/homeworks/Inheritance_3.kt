package lessons.lesson15.homeworks

//3. Иерархия Мебели
//Базовый класс: Мебель
//Производные классы: …
//Дополнительное разветвление для …: …

open class Furniture(
    val material: String,
    val weight: Int
)
open class Table(
    material: String,
    weight: Int,
    val length: Int
): Furniture(material, weight)

open class Chair(
    material: String,
    weight: Int,
    val hasWheels: Boolean,
): Furniture(material, weight)

open class OfficeChair(
    material: String,
    weight: Int,
    hasWheels: Boolean
): Chair(material, weight, hasWheels)

open class DiningTable(
    material: String,
    weight: Int,
    length: Int
): Table(material, weight, length)