fun main() {
    val player = Player("madrigal")

    //Aura
    val auraColor = player.auraColor()

    val healthStatus = player.formatHealthStatus()

    printPlayerStatus(player)

    player.castFireball()
}
private fun printPlayerStatus(
    player: Player
) {
    println("(Aura: $player.auraColor) " + "(Blessed: ${if (player.isBlessed) "YES" else "No"})")
    println("$player.name $player.healthStatus")
}




private fun castFireball(number: Int = 2) {
    println("A glass of Fireball springs into existence. (x$number)")
}