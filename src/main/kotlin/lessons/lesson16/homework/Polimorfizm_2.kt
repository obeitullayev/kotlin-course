package lessons.lesson16.homework

/*
Геометрические Фигуры и Их Площадь
Абстрактный (базовый) класс: Shape с open методом area().
Классы наследники: Circle, Square, Triangle.
Метод area() возвращает 0.0.
Переопределите метод area() в каждом классе-наследнике для расчета площади соответствующей фигуры.
Подсказка: каждый класс должен иметь аргументы конструктора, позволяющие вычислить площадь (для круга это радиус, для квадрата это сторона, для треугольника это две стороны и угол между ними)
Создай набор геометрических фигур и выведи в цикле их площадь
*/

abstract class Shape(
){
    open fun area(){
        println("0.0")
    }
}
open class Circle(val radius: Double): Shape(){
    override fun area(){
        val pi = 3.14
        println(pi * radius * radius)
    }
}

open class Square(val side: Double): Shape(){
    override fun area(){
        println(side*side)
    }
}

open class Triangle(val a: Double, val b: Double, val degree: Double): Shape(){
    override fun area(){
        val pi = 3.14
        val sin = degree * pi / 180
        println(0.5*a*b*sin)
    }
}

fun main(){
    val shapes: List<Shape> = listOf(Circle(5.0), Square(4.0), Triangle(6.0, 8.0, 30.0))
    shapes.forEach { it.area() }
}
