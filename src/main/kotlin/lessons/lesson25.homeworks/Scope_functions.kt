package lessons.lesson25.homeworks

// 1 Создайте функцию timeTracker, которая принимает другую функцию в качестве аргумента и измеряет время её выполнения.
// Функция timeTracker должна возвращать затраченное время в миллисекундах. Для измерения времени используйте System.currentTimeMillis() до и после выполнения переданной функции.
//
//Для проверки результата можно выполнить в ней например такой ресурсоёмкий код:

val myFunction = {
   val list = List(10000000) { (0..10000).random() }
   list.sorted()
}

fun <T> timeTracker  ( function:() -> T): Long {
    val before  = System.currentTimeMillis()
    function()
    val after = System.currentTimeMillis()
    return after-before
}

// 2
data class Person(val name: String, val age: Int) {
    var email: String = ""
}

data class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "General"
}

// 3
fun log(per: Person): String{
    return with(per){
        """
        Name: $name
        Age: $age
        Email: $email
    """.trimIndent()
    }
}

fun main(){
    println("--------------")
    // 1
    println(timeTracker(myFunction))
    println("--------------")

    // Задание 2: Использование apply для инициализации объекта Employee
    ////Создайте объект Employee и используйте apply для инициализации его полей email и department.

    val emp = Employee("John", 23, "QA").apply{
        email= "test@mail.com"
        department = "Engineer"
    }
    println(emp.toString())
    println("--------------")

    //Задание 3: Использование also для логирования
    //Создайте функцию, принимающую объект Person и выводящую информацию об объекте в консоль в красивом, отформатированном виде.
    // Используй with для создания контекста Person и возможности использовать поля объекта напрямую без обращения к переменной.
    //
    //Создайте объект Person и используйте also для добавления почты и печати данных в консоль с помощью метода который только что создали.

    val person =  Person("Stew", 32).also{
        it.email= "test2@mail.com"
        println(log(it))
    }
    println("--------------")

    //Задание 4: Использование with для преобразование Person в Employee
    //
    //Создайте объект класса Person. Используйте функцию with, чтобы создать из этого объекта Employee, указав дополнительно должность.
    // Возвращаемым значением должен быть новый объект Employee.

    val res= with(person){
         Employee(this.name, this.age, "HR")
    }
    println(res)
    println("--------------")

    //Задание 5: Использование run для преобразования и инициализации Employee
    //
    //Перепиши предыдущую задачу на использование run вместо with.
    //
    val runFunc = person.run{
         Employee(this.name, this.age, "HR")
    }
    println(runFunc)
    println("--------------")

    //Задание 6: Использование let для безопасного преобразования Person в Employee
    //
    //Создайте функцию toEmployee, которая расширяет класс Person, который может быть null.
    // В функции используйте функцию let для создания Employee, только если объект Person не null. В противном случае возвращается null

    val person1: Person? = null
    fun Person?.toEmployee(): Employee? {
        return  this?.let{
                Employee(name, age, "CEO")
        }
    }
    println(person.toEmployee())
    println(person1.toEmployee())
}