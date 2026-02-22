package lessons.lesson17.homeworks

// Почемучка
// Нужно скопировать код к себе и постараться ответить на все “почему” в комментариях и заданным образом доработать класс ChildrenClass (BaseClass доработке не подлежит)

abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass - Потому что используется поле из класса ChildrenClass с тем же названием
    private val privateVal: String,
    // 2. объясни, почему это поле недоступно в main() - доступно только в объявленом класе и наследнике
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
    set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"
    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }
    fun printText() {
        privatePrint()
    }
    // 7. объясни, почему эта функция не может быть публичной - Если сделать метод public, он вернул бы объект класса
    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }
    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст - В ChildrenClass есть переопределение
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }
    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }
    // 9. объясни, почему эта функция не может быть публичной или protected - Если сделать метод public или protected, он вернул бы объект PrivateClass
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}
class ChildrenClass(
    val privateVal: String,
    protectedVal: String,

    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле - В main() можно обращаться через ChildrenClass, потому что оно унаследовано из BaseClass
    publicVal: String,
    publicField: String
) : BaseClass(privateVal, protectedVal, privateVal   ) {
    override fun verifyPublicField(value: String) = true
    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет - ChildrenClass наследует BaseClass, поэтому все public методы родителя становятся public методы дочернего класса.
    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint() - В BaseClass privatePrint() - private, Даже если в ChildrenClass объявлен метод с таким же именем, это новый метод, а не переопределение.
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }
    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
    fun addPublicField(value: String) {
        publicField = value
    }

    fun setProtecteddField(value: String) {
        protectedField = value
    }


}

fun main() {
    val child = ChildrenClass("a", "b", "c", "d")
    child.addPublicField("Антонио Бандерас")
    child.setProtecteddField("новое значение")
    child.printText()
    println(child.getAll())

}