import kotlin.math.roundToInt

val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10
fun main() {
    placeOrder("shady,Dragon's Breath,5.91")
}

fun performPurchase(price: Double) {
    displayBalance()
    val total = playerGold + playerSilver / 100.0

    println("Purchasing item for $price")
    println("Total purse: $total")

    val remaining = total - price
    println("Remaining balance: ${"%.2f".format(remaining)}")

    val remainingGold = remaining.toInt()
    val remainingSilver = (remaining % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks $tavernMaster about their order.")

    val (type, name, price) = menuData.split(",")
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

    performPurchase(price.toDouble())

    var phrase = "Ah, Delicious $name!"
    println("Madrigal exclaims: ${toDragonSpeak(phrase)}")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

