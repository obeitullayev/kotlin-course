package lessons.lesson13.homeworks

// 1 Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах.
// Определите среднее время выполнения теста.
fun avgRunTime(){
    val dict = mapOf("smoke" to 1, "regression" to 2, "integration" to 3 )
    val avgRun = dict.values.average()
    println(avgRun)
}

// 2 Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов а значения - строка с метаданными.
// Выведите список всех тестовых методов.
fun listOfMethods(){
    val dict = mapOf("get" to "User-Agent", "post" to "Cookie", "patch" to "Header")
    val methods = dict.keys
    println(methods)
}

// 3 В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
fun addData(){
    val dict = mutableMapOf("smoke" to "pass", "regression" to "fail")
    dict["integration"] = "skip"
    println(dict)
}

// 4 Посчитайте количество успешных тестов в словаре с результатами (ключ - название, значение - результат из passed, failed, skipped).
fun countPassedTests(){
    val dict = mutableMapOf("smoke" to "passed", "regression" to "failed", "integration" to "passed")
    val counter = dict.count { it.value==="passed" }
    println(counter)
}

// 5 Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен (ключ - название, значение - статус исправления).
fun delBugReport(){
    val dict = mutableMapOf("title1" to "fixed", "title2" to "ready", "title3" to "ready")
    val delBug = dict.remove("title1")
    println(dict)
}

// 6 Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа), выведите сообщение о странице и статусе её проверки.
fun getCheckStatus(){
    val dict = mapOf("stimmax.ru" to "passed", "stimmax.ru/course" to "skipped", "stimmax.ru/course-library" to "failed")
    for ((key, value) in dict){
        println("URL '$key' has status $value")
    }
}

// 7 Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
fun findGreaterTimeService(){
    val dict = mapOf("smoke" to 1, "regression" to 2, "integration" to 3 )
    val serviceGreater = dict.filter { it.value>2 }
    println(serviceGreater)
}

// 8 В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки).
// Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.
fun findResponseStatusForEndpoint (endpoint: String){
    val dict = mapOf("login" to "200 OK", "course" to "302 Found", "course-library" to "404 Not Found")
    val notTested= dict.getOrElse(endpoint){"Not tested"}
    println(notTested)
}

// 9 Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации, значение - сама конфигурация),
// получите значение для "browserType". Ответ не может быть null.
val dict = mapOf( "port" to "8080", "viewType" to "headless")
fun getConfVal(dict: Map<String, String>){
    val result = dict.containsKey("browserType")
    println(result)
}

// 10 Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.
fun addNewVersionApp(){
    val dict = mapOf( "1" to "registration", "2" to "login")
    val addedData = dict+mapOf("3" to "catalog")
    println(addedData)
}

// 11 Используя словарь с настройками тестирования для различных мобильных устройств (ключ — модель устройства, значение - строка с настройками),
// получите настройки для конкретной модели или верните настройки по умолчанию.
fun getSettingForModel(key: Int){
    val dict = mapOf( 17 to "call", 16 to "wifi")
    val getDefault= dict.getOrDefault(key, "About")
    println(getDefault)
}

// 12 Проверьте, содержит ли словарь с ошибками тестирования (ключ - код ошибки, значение - описание ошибки) определенный код ошибки.
fun checkIfContains(error: Int){
    val dict = mapOf(300 to "Redirect", 302 to "Found", 404 to "Not Found")
    val containError = dict.containsKey(error)
    println(containError)
}

// 13 Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version",
// а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped"). Отфильтруйте словарь,
// оставив только те сценарии, идентификаторы которых соответствуют определённой версии тестов, то-есть в ключе содержится требуемая версия.
fun getNeededVersion(ID: Int){
    val dict = mapOf("TestID_100" to "Passed", "TestID_101" to "Failed", "TestID_102" to "Skipped")
    val testId=dict.filterKeys{it.endsWith(ID.toString())}
    println(testId)
}

// 14 У вас есть словарь, где ключи — это названия функциональных модулей приложения, а значения — результаты их тестирования.
// Проверьте, есть ли модули с неудачным тестированием.
fun findInvalidModule(){
    val dict = mapOf("login" to "failed", "course" to "failed", "library" to "skipped")
    val invalidModule= dict.filterValues { it =="failed" }
    println(invalidModule)
}

// 15 Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
fun addSettings(){
    val dict = mutableMapOf( 17 to "call", 16 to "wifi")
    val dict2 = mapOf( 18 to "about", 19 to "bluetooth")
    dict.putAll(dict2)
    println(dict)
}

// 16 Объедините два неизменяемых словаря с данными о багах.
fun mergeTwoDict(){
    val dict = mapOf( 1 to "bug1", 2 to "bug2")
    val dict2 = mapOf( 3 to "bug3", 4 to "bug4")
    val mergedDict = dict+dict2
    println(mergedDict)
}

// 17 Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
fun clearDict(){
    val dict = mutableMapOf("login" to "failed", "course" to "failed", "library" to "skipped")
    dict.clear()
    println(dict)
}

// 18 Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены (имеют статус “skipped”).
// Ключи - название теста, значения - статус.
fun removeSkippedTests(){
    val dict = mapOf("login" to "failed", "course" to "failed", "library" to "skipped")
    val filtered = dict.filterNot { it.value=="skipped"}
    println(filtered)
}

// 19 Создайте копию словаря с конфигурациями тестирования удалив из него несколько конфигураций.
fun copyEditedDict(){
    val dict = mapOf( "port" to "8080", "viewType" to "headless", "proxy" to "443")
    val newDict = dict-"port"-"proxy"
    println(newDict)
}

// 20 Создайте отчет о тестировании, преобразовав словарь с результатами тестирования (ключ — идентификатор теста, значение — результат)
// в список строк формата "Test ID: результат".
fun convertDictToList(){
    val dict = mapOf("TestID_100" to "Passed", "TestID_101" to "Failed", "TestID_102" to "Skipped")
    val entries = dict.map { "${it.key}: ${it.value}"}
    println(entries)
}

// 21 Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
// 22 Преобразуйте словарь, содержащий числовой ID теста и данные о времени выполнения тестов, заменив идентификаторы тестов на их строковый аналог (например через toString()).
// 23 Для словаря с оценками производительности различных версий приложения (ключи - строковая версия, значения - дробное число времени ответа сервера) увеличьте каждую оценку на 10%, чтобы учесть новые условия тестирования.
// 24 Проверьте, пуст ли словарь с ошибками компиляции тестов.
// 25 Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
// 26 Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
// 27 Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
// 28 Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты, которые не прошли успешно и содержат в названии “optional”.

fun main(){
    avgRunTime()
    listOfMethods()
    addData()
    countPassedTests()
    delBugReport()
    getCheckStatus()
    findGreaterTimeService()
    findResponseStatusForEndpoint("logins")
    getConfVal(dict)
    addNewVersionApp()
    getSettingForModel(1)
    checkIfContains(302)
    getNeededVersion(101)
    findInvalidModule()
    addSettings()
    mergeTwoDict()
    clearDict()
    removeSkippedTests()
    copyEditedDict()
    convertDictToList()
}