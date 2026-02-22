package lessons.lesson7.homework

import org.hamcrest.Description
import org.hamcrest.Matchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.TypeSafeDiagnosingMatcher

enum class Color { RED, BLUE, GREEN, YELLOW, BLACK, WHITE }
data class Shape(val length: Float, val quantities: Int, val color: Color){
}

// 1 Проверка длины стороны в заданном диапазоне (например, от 0.1 до 100.0).
class LengthMatcher(
    private val fromLength: Float,
    private val toLength: Float
) : TypeSafeDiagnosingMatcher<Shape>() {

    override fun describeTo(description: Description) {
        description.appendText("shape with length between ")
            .appendValue(fromLength ).appendText("and").appendValue(toLength)
    }

    override fun matchesSafely(item: Shape, mismatchDescription: Description): Boolean {
        if (item.length !in fromLength..toLength) {
            mismatchDescription
                .appendText("length was ")
                .appendValue(item.length)
            return false
        }
        return true
    }
}

// 2 Проверка количества углов:
// 3 Для фигур с 3 и более сторонами количество углов совпадает с количеством сторон.
// 4 Для фигур с 1 или 2 сторонами (линий) углы отсутствуют (значение углов = 0).
class AngleMatcher(
    private val angles: Int
) : TypeSafeDiagnosingMatcher<Shape>() {

    override fun describeTo(description: Description) {
        description.appendText("angle number ")
            .appendValue(angles)
    }

    override fun matchesSafely(item: Shape, mismatchDescription: Description): Boolean {
        if ((item.quantities in 1..2 && angles == 0) || (item.quantities >= 3 && item.quantities == angles)) {
            return true
        } else {
            mismatchDescription.appendText("shape side number was ").appendValue(item.quantities)
            return false
        }
    }
}

// 5 Проверка на чётное количество сторон.
class EqualSideMatcher(
    private val expectedQuantity: Int
) : TypeSafeDiagnosingMatcher<Shape>() {

    override fun describeTo(description: Description) {
        description.appendText("shape with ")
            .appendValue(expectedQuantity)
            .appendText("sides")  }

    override fun matchesSafely(item: Shape, mismatchDescription: Description): Boolean {
        if (item.quantities % 2 != 0 ) {
            mismatchDescription
                .appendText("side was not equals ")
                .appendValue(item.quantities)
            return false
        }
        return true
    }
}

// 6 Проверка цвета фигуры.
class ShapeColorMatcher(
    private val expectedColor: Color
) : TypeSafeDiagnosingMatcher<Shape>() {

    override fun describeTo(description: Description) {
        description.appendText("shape with color ")
            .appendValue(expectedColor)
    }

    override fun matchesSafely(item: Shape, mismatchDescription: Description): Boolean {
        if (item.color != expectedColor) {
            mismatchDescription
                .appendText("Color was ")
                .appendValue(item.color)
            return false
        }
        return true
    }
}

// 7 Проверка на наличие отрицательной длины стороны (недопустимо).
class PositiveLengthMatcher(
) : TypeSafeDiagnosingMatcher<Shape>() {

    override fun describeTo( description: Description) {
        description.appendText("shape with length ")
    }

    override fun matchesSafely(item: Shape, mismatchDescription: Description): Boolean {
        if (item.length < 0) {
            mismatchDescription
                .appendText("length was ")
                .appendValue(item.length)
            return false
        }
        return true
    }
}

// 8 Проверка на наличие отрицательного количества сторон (недопустимо).
class PositiveQuantityMatcher(
) : TypeSafeDiagnosingMatcher<Shape>() {

    override fun describeTo( description: Description) {
        description.appendText("shape with quantity ")
    }

    override fun matchesSafely(item: Shape, mismatchDescription: Description): Boolean {
        if (item.quantities < 0) {
            mismatchDescription
                .appendText("quantities was ")
                .appendValue(item.quantities)
            return false
        }
        return true
    }
}

val shapes = listOf(
    Shape(10f, 3, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
    Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
    Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
    Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
    Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
    Shape(25f, 12, Color.YELLOW), Shape(30f, 0, Color.BLACK), Shape(35f, 16, Color.WHITE),
    Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE)
)

fun matchers() {
    val shape = Shape(10f, 1, Color.WHITE)
    assertThat(shape, LengthMatcher(10f, 20f))
    assertThat(shape, ShapeColorMatcher(Color.WHITE))
    assertThat(shape, PositiveLengthMatcher())
    assertThat(shape, PositiveQuantityMatcher())
    assertThat(shape, AngleMatcher(0))
}

fun main() {
    //1
    val isLengthMatch = LengthMatcher(0.1f, toLength = 20.0f)
    //2
    //3
    //4
    val isAngleEqual = AngleMatcher(0)
    //5
    val isSidesEqual = EqualSideMatcher(5)
    //6
    val isColorWhite= ShapeColorMatcher(Color.WHITE)
    //7
    val isPositiveLength = PositiveLengthMatcher()
    //8
    val isPositiveQuantity = PositiveQuantityMatcher()

    matchers()

    val validData = allOf(isLengthMatch, isAngleEqual, isSidesEqual, isColorWhite, isPositiveLength, isPositiveQuantity)

    val filtered1 = shapes.filter { shape -> validData.matches(shape) }
    println(filtered1)
}