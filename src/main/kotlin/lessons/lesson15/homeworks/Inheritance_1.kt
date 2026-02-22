package lessons.lesson15.homeworks

// 1. Геометрические Фигуры
//Базовый класс: Геометрическая Фигура
//Производные классы: Многоугольник, Круг
//Дополнительное разветвление для Многоугольник: Треугольник, Четырехугольник

open class Figure(
    val form: String,
)
open class Polygon(
    form: String
): Figure(form)

open class Circle(
    form: String
): Figure(form)

open class Triangle(
    form: String
): Polygon(form)

open class Quadrilateral(
    form: String
): Polygon(form)