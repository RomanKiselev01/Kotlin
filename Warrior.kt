interface Warrior {
    val evasionChance: Any
    val isKilled: Boolean
    val dodgeChance: Int

    fun attack(enemy: Warrior)
    fun takeDamage(damage: Int)
    fun checkAccuracy(accuracy: Int): Boolean
    fun dodge(dodgeChance: Int): Boolean
}
