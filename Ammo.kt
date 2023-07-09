import kotlin.random.Random

enum class Ammo(val damage: Int, val criticalChance: Int, val criticalMultiplier: Double) {
    PISTOL(10, 25, 2.0),
    RIFLE(20, 15, 2.5),
    SHOTGUN(30, 10, 3.0);

    fun calculateDamage(): Int {
        val baseDamage = damage
        return if (criticalChance.chanceOccurs(10)) {
            (baseDamage * criticalMultiplier).toInt()
        } else {
            baseDamage
        }
    }


    fun Int.chanceOccurs(chance: Int): Boolean {
        return Random.nextInt(100) < chance
    }

    fun checkAccuracy(accuracy: Int): Boolean {
        return Random.nextInt(101) <= accuracy
    }
}




