package lessons.lesson03.homework

// 1. Название мероприятия
val eventName: String = "Interview Hakaton"

// 2. Дата проведения
var eventDate: String = "09 сентября 2025"

// 3. Место проведения
val eventLocation: String = "Online"

// 4. Подробный бюджет мероприятия, включая расходы на оборудование, кейтеринг и другие операционные расходы.
private val eventDetailedBudget: String = "Free"

// 5. Количество участников
var participantsCount: Number = 2

// 6. Длительность хакатона
var hackathonDuration: String = "2 часа"

// 7. Контактная информация и условия соглашений с поставщиками пищи, оборудования и других услуг.
private var suppliersContacts: String = "+7586445444"

// 8. Текущее состояние хакатона (статус)
var hackathonStatus: String = "Not ready"

// 9. Список спонсоров
private var sponsorsList: String = "Sber"

// 10. Бюджет мероприятия
private val eventBudget: Number = 1_000_000

// 11. Текущий уровень доступа к интернету
lateinit var internetAccessLevel: String

// 12. Информация о транспортировке оборудования, распределении ресурсов и координации между различными командами поддержки.
private val logisticsInfo: String = ""

// 13. Количество команд
var teamsCount: Number=3

// 14. Перечень задач
var taskList: String= ""

// 15. План эвакуации
val evacuationPlan: String=""

// 16. Список доступного оборудования (всё, что выделено для использования на мероприятии)
var availableEquipment: String=""

// 17. Список свободного оборудования (всё, что можно взять прямо сейчас и что не занято другими участниками)
var freeEquipment: String=""

// 18. График питания участников (зависит от поставщика питания, определяемого за неделю до начала)
lateinit var mealsSchedule: String

// 19. План мероприятий на случай сбоев
var backupPlan: String=""

// 20. Список экспертов и жюри
var expertsAndJudges: String=""

// 21. Политика конфиденциальности
var privacyPolicy: String=""

// 22. Приватные отзывы (фидбэк) участников и зрителей для анализа проблем
private lateinit var privateFeedback: String

// 23. Текущая температура в помещении
lateinit var currentTemperature: String

// 24. Данные мониторинга и анализ производительности сетевого оборудования и интернет-соединения
var networkMonitoringData: String=""

// 25. Регулятор скорости интернета (понижающий коэффициент)
var internetThrottleCoefficient: String="0.5"

// 26. Уровень освещения
var lightLevel: String=""

// 27. Лог событий мероприятия
private var eventLog: String=""

// 28. Возможность получения медицинской помощи прямо на мероприятии (да/нет)
var medicalSupportAvailable: Boolean = true

// 29. Планы и процедуры для обеспечения безопасности мероприятия
private val safetyProcedures: String=""

// 30. Регистрационный номер мероприятия
val eventRegistrationNumber: Number= 0

// 31. Максимально допустимый уровень шума в помещении хакатона
val maxNoiseLevel: String= "30 Db"

// 32. Индикатор превышения уровня шума в помещениях
var noiseExceeded: Boolean = true

// 33. План взаимодействия с прессой
var pressPlan: String= " "

// 34. Детальная публичная информация о проектах каждой команды
var projectsPublicInfo: String= " "

// 35. Статус получения всех необходимых разрешений для проведения мероприятия
lateinit var permissionsStatus: String

// 36. Индикатор доступности специализированного оборудования
var specialEquipmentAvailable: Boolean = true

// 37. Список партнеров мероприятия
private val partnersList: String=""

// 38. Отчет после мероприятия (фото, видео, отзывы)
lateinit var eventReport: String

// 39. Внутренние правила распределения призов
private val prizesRules: String=""

// 40. Список разыгрываемых призов
val prizesList: String=""

// 41. Контактная информация экстренных служб и медицинского персонала
val emergencyContacts: String=""

// 42. Особые условия для участников с ограниченными возможностями
val specialNeedsConditions: String=""

// 43. Общее настроение участников (по опросам)
lateinit var participantsMood: String

// 44. Подробный план хакатона
val hackathonSchedule: String by lazy {
    "Hello, this is a lazy string!"
}

// 45. Имя знаменитого специального гостя
lateinit var specialGuestName: String

// 46. Максимальное количество людей, которое может вместить место проведения
val venueCapacity: Number=1000

// 47. Количество часов, отведенное каждой команде для работы над проектом
val teamWorkHours: Number=10