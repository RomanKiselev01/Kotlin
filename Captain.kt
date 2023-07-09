import kotlin.random.Random

open class Captain(weapon: AbstractWeapon) : AbstractWarrior(100, 15.0, 80.0, weapon) {
    override val dodgeChance: Int
        get() = 50

    override fun checkAccuracy(accuracy: Int): Boolean {
        return true
    }

    override fun dodge(dodgeChance: Int): Boolean {
        return Random.nextBoolean()
    }
}