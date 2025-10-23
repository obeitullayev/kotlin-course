package lessons.lesson14.homeworks

import java.security.DrbgParameters

// 1. Событие: вечеринка. Создайте класс Party, который описывает вечеринку.
// У него должны быть свойства location (String) и attendees (Int).
// Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.
class Party(val location: String, val attendees: Int){
    fun details(){
        println("Location: $location Attendees: $attendees")
    }
}

// 2. Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию.
// У него должно быть свойство type (String) и intensity (Int). Добавьте метод express(), который выводит описание
// эмоции в зависимости от её типа и интенсивности.
class Emotion(val type: String, val intensity: Int){
    fun express(){
        println("Description: $type, Intensity: $intensity")
    }
}

// 3. Природное явление: луна. Создайте объект Moon, который будет представлять Луну.
// Добавьте свойства isVisible (Boolean), чтобы отображать, видна ли Луна в данный момент, и phase (String),
// чтобы отображать текущую фазу Луны (например, "Full Moon", "New Moon"). Добавьте метод showPhase(),
// который выводит текущую фазу Луны.
object Moon {
    val isVisible: Boolean = true
    val phase: String = "Full Moon"

    fun showPhase() {
        println(phase)
    }
}

// 4. Покупка: продукт. Создайте дата класс для продукта, который будет представлять продукт в магазине.
// У него должны быть свойства “название”, “цена”, “количество”.
data class Milk(val name: String, val price: Float, val Litres: Int)

//5. Мероприятие: концерт. Создайте класс, который будет представлять концерт.
// У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”.
// Также приватное поле “проданные билеты”. Добавьте метод, который выводит информацию о концерте и метод
// “купить билет”, который увеличивает количество проданных билетов на один.
data class Concert(val Group: String, val location: String, val price: Float, val capability: Int, private var soldTickets: Int) {
    fun getIngo(){
        println("Address: $location, Group: $Group, Price: $price, Places: $capability ")
    }

    fun ticketCounter(){
        soldTickets++
    }
}

//6. Стеллаж и полки.
// Цель задания: Создать систему управления складским пространством с использованием классов "Стеллаж" и "Полка стеллажа".
//Класс Shelf (Полка Стеллажа)
//
//Характеристики:
//Вместимость полки (capacity): максимальная сумма букв всех названий предметов, которые могут быть размещены на полке.
// Список предметов (items): хранит названия предметов на полке.
//Добавление Предмета (addItem):
//Принимает название предмета.
//Проверяет, поместится ли предмет на полку, учитывая длину его названия и текущее заполнение полки.
//Возвращает true и добавляет предмет, если есть место. В противном случае возвращает false.

//Удаление Предмета (removeItem):
//Принимает название предмета.
//Удаляет предмет, если он найден на полке.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.

//Проверка Вместимости (canAccommodate):
//Принимает название предмета.
//Определяет, вместится ли предмет на полку.
//Возвращает true, если предмет вместится, и false, если места недостаточно.

//Проверка наличия предмета (containsItem):
//Принимает название предмета
//Возвращает true если такой предмет есть
//Получение списка предметов (zgetItems):
//Возвращает неизменяемый список предметов

class Shelf(val capacity: Int){
    val items= mutableListOf<String>()

    private fun itemSize(): Int{
        val itemsSize= items.sumOf { it.length }
        return itemsSize
    }

    fun addItem(item: String): Boolean{
        if ((item.length+itemSize())<=capacity) {
            items.add(item)
            return true
        } else
            return false
    }

    fun removeItem(item: String): Boolean{
        if (item in items) {
            items.remove(item)
            return true
        } else
            return false
    }

    fun canAccommodate(item: String): Boolean{
        if ((itemSize() + item.length) <= capacity){
             return true
        } else
            return false
    }

    fun containsItem(item: String): Boolean{
        if (item in items){
            return true
        } else
            return false
    }

    fun getItem(): List<String>{
        return items.toList()
    }
}

//Класс Rack (Стеллаж)
//
//Характеристики:
//
//Список полок (shelves): хранит полки стеллажа.
//Максимальное количество полок.
//Методы:
//
//Добавление Полки (addShelf):
//Добавляет новую полку в стеллаж.
//Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен или была попытка добавить полку которая уже установлена.
//Удаление Полки (removeShelf):
//Принимает индекс полки для удаления.
//Удаляет полку по указанному индексу.
//Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.
//Добавление Предмета (addItem):
//Добавляет предмет на первую свободную полку.
//Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.
//Удаление Предмета (removeItem):
//Находит и удаляет только один предмет с любой полки.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.
//Проверка наличия предмета на стеллаже (containsItem):
//Возвращает true если предмет есть на одной из полок
//Получение списка полок (getShelves):
//Возвращает неизменяемый список полок
//Печать Содержимого (printContents):
//Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов. Информацию выводить в наглядном читаемом виде
//Сложное удаление полки (advancedRemoveShelf):
//Принимает индекс полки для удаления
//Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается, его нужно пропустить и попробовать разместить следующий.
//Удаляет полку с оставшимися предметами
//Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет.

class Rack(private val maxShelves: Int) {
    private val shelves = mutableListOf<Shelf>()

    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.size >= maxShelves || shelves.contains(shelf)) return false
        shelves.add(shelf)
        return true
    }

    fun removeShelf(index: Int): List<String> {
        return if (index in shelves.indices) {
            val removedItems = shelves[index].getItem()
            shelves.removeAt(index)
            removedItems
        } else {
            emptyList()
        }
    }

    fun addItem(item: String): Boolean {
        for (shelf in shelves) {
            if (shelf.addItem(item)) return true
        }
        return false
    }

    fun removeItem(item: String): Boolean {
        for (shelf in shelves) {
            if (shelf.removeItem(item)) return true
        }
        return false
    }

    fun containsItem(item: String): Boolean {
        return shelves.any { it.containsItem(item) }
    }

    fun getShelves(): List<Shelf> = shelves.toList()

    fun printContents() {
        println("=== Rack Contents ===")
        for ((index, shelf) in shelves.withIndex()) {
            val usedSpace = shelf.getItem().sumOf { it.length }
            val remaining = shelf.capacity - usedSpace
            println("Shelf #$index")
            println("  Capacity: ${shelf.capacity}")
            println("  Used: $usedSpace")
            println("  Remaining: $remaining")
            println("  Items: ${shelf.getItem()}")
            println()
        }
    }

    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in shelves.indices) return emptyList()
        val leftItems = mutableListOf<String>()
        val indexedShelf = shelves[index].getItem().sortedByDescending { it.length }
        shelves.removeAt(index)
        for (item in indexedShelf) {
            var placed = false
            for (shelf in shelves) {
                if (shelf.addItem(item)) {
                    placed = true
                    break
                }
            }
            if (!placed) {
                leftItems.add(item)
            }
        }
        return leftItems
    }
}



fun main() {
    // Создаём три полки с разной вместимостью
    val shelf1 = Shelf(capacity = 20)
    val shelf2 = Shelf(capacity = 15)
    val shelf3 = Shelf(capacity = 10)

    // Создаём стеллаж, в который можно добавить максимум 3 полки
    val rack = Rack(maxShelves = 3)

    // Добавляем полки в стеллаж
    rack.addShelf(shelf1)
    rack.addShelf(shelf2)
    rack.addShelf(shelf3)

    // Пробуем добавить предметы
    rack.addItem("Книга")
    rack.addItem("Коробка")
    rack.addItem("Тетрадь")
    rack.addItem("Игрушка")
    rack.addItem("Папка")

    rack.advancedRemoveShelf(1)
    rack.printContents()
}