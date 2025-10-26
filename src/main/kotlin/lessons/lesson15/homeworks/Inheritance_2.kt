package lessons.lesson15.homeworks

// 2. Учебные Заведения
//Базовый класс: Учебное Заведение
//Производные классы: Школа, …
//Дополнительное разветвление для …: …

open class EducationalInstitutions(
    val capacity: Int,
    val classes: List<String>,
    val subjects: List<String>
)
open class ElementarySchool(
    capacity: Int,
    classes: List<String>,
    subjects: List<String>
): EducationalInstitutions(capacity, classes, subjects)

open class MiddleSchool(
    capacity: Int,
    classes: List<String>,
    subjects: List<String>
): EducationalInstitutions(capacity, classes, subjects)

open class HighSchool(
    capacity: Int,
    classes: List<String>,
    subjects: List<String>
): EducationalInstitutions(capacity, classes, subjects)