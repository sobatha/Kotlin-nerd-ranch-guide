fun main() {
    var beverage = readLine()?.let {
        if(it.isNotBlank()) {
            it.capitalize()
        } else {
            "Buttered Ale"
        }
    }
//    beverage = null
    println(beverage)
}