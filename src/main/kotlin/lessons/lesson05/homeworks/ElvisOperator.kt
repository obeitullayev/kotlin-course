package lessons.lesson05.homeworks
// #1
val koefficient_zatuhaniya: Double? = null
val nachalnaya_intensivnost: Double = 90.0
val count = nachalnaya_intensivnost*(koefficient_zatuhaniya?:0.5)

// #2
val delivery_price: Double = 10.0
val insurance: Double = 0.005
val price: Double? = null
val  count2 = (insurance*(price?:50.0))+delivery_price

// #3

val pressure: String? = "34.6" // но может быть null
val attentionMessage = "Attention, pressure is lost"
val pressureForLab = pressure?:attentionMessage


