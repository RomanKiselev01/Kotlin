import kotlin.random.Random

open class Soldier(weapon: AbstractWeapon) : AbstractWarrior(50, 10.0, 70.0, weapon) {
    override val dodgeChance: Int
        get() = 50

    override fun checkAccuracy(accuracy: Int): Boolean {
        return true
    }

    override fun dodge(dodgeChance: Int): Boolean {
        return Random.nextBoolean()
    }
}
