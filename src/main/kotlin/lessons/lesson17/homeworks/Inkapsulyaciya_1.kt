package lessons.lesson17.homeworks

//Опиши схематически класс игрового автомата, правильно расставив объявление полей (val или var)
// и методов (аргументы и возвращаемые значения), включая модификаторы доступа (private для приватных)

//Поля:
//
//цвет
//модель
//включен
//ОС загружена
//список установленных игр
//наличие джойстика
//баланс вырученных средств
//владелец
//телефон поддержки.
//игровой сеанс оплачен
//стоимость одного игрового сеанса
//пин-код автомата

//Методы:
//
//включить
//выключить
//загрузить ОС
//завершить работу ОС
//показать список игр
//включить игру
//оплатить игровой сеанс
//забрать наличные с помощью пин-кода
//открыть сейф и выдать наличные

open class open class SlotMachine(   val color: String,
                          val model: String,
                          var enabled: Boolean,
                          var osLoaded: Boolean,
                          val gameList: List<String>,
                          var joystickAvailability: Boolean,
                          private var balanceIncome: Int,
                          private val owner: String,
                          val supportPhone: String,
                          var gameSessionPaid: Boolean,
                          val costOfOneGame: Int,
                          private var pinCodeForMachine: Int){

   public fun enable(){
        enabled=true
    }

    public fun disable(){
        enabled=false
    }

    public fun loadOs(){
        osLoaded=true
    }

    public fun unloadOs(){
        osLoaded=false
    }

    public fun showGamesList(){
        print(gameList)
    }

    public fun enableGame(game: String): String?{
        return if (gameSessionPaid&&gameList.contains(game)){
            "Game $game started"
        } else {
            "Game not available or not paid"
        }
    }

    public fun payForGame(money: Int, game: String){
         if  (!enabled || !osLoaded) {
             println("Machine is not ready")
             return
         }
        if (money>=costOfOneGame){
             balanceIncome +=money
             gameSessionPaid=true
             enableGame(game)
         } else {
            println("Not enough money")
        }
    }

    private fun takeIncomeWithPin(pin: Int){
        if (pin==pinCodeForMachine){
            print(balanceIncome)
            balanceIncome=0
        }
    }

      fun openSafeAndTakeIncome(pin: Int){
        takeIncomeWithPin(pin)
    }
}