package lessons.lesson16.homework


/*
Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
Выполнить перегрузку addToCart который:
Принимает два аргумента (itemId и количество amount)
Принимает словарь из id и количества и добавляет всё в корзину
Принимает список из id (добавляет по одной единице).
Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину в консоль.
Переопредели у корзины метод toString для красивого форматирования содержимого таблицы, включая итоговое количество артикулов и общее количество всего товара в корзине.
*/

open class Basket(
    val dict: MutableMap<String, Int> = mutableMapOf()
) {
    open fun addToCart(itemId: String) {
        dict[itemId] = dict.getOrDefault(itemId, 0) + 1
        println(dict)
    }

    open fun addToCart(itemId: String, amount: Int) {
        dict[itemId] = dict.getOrDefault(itemId, 0) + amount
        println(dict)
    }

    open fun addToCart(mapp: Map<String, Int>) {
        for ((key, value) in mapp) {
            dict[key] = dict.getOrDefault(key, 0) + value
        }
        println(dict)
    }

    open fun addToCart(ids: List<String>) {
        for (i in ids) {
            dict[i] = dict.getOrDefault(i, 1)
        }
        println(dict)
    }

    override open fun toString(): String {
        val itemsDescription = dict.entries.joinToString("\n") {
            "ID: ${it.key}, sum: ${it.value}"
        }

        val summary = "Sum of: IDs ${dict.keys.size}, products ${dict.values.sum()}"
        println(itemsDescription)
        println(summary)
        return "$itemsDescription\n$summary"
    }
}

fun main(){
    val basket = Basket()
    basket.addToCart("apple")
    basket.addToCart("apple")     // {apple=1}
    basket.addToCart("banana", 2)             // {apple=1, banana=2}
    basket.addToCart(mapOf("apple" to 3, "orange" to 1)) // {apple=4, banana=2, orange=1}
    basket.addToCart(listOf("banana", "apple", "kiwi"))  // {apple=5, banana=3, orange=1, kiwi=1}
    basket.toString()
}
