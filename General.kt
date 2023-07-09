import kotlin.random.Random

open class General(weapon: AbstractWeapon) : AbstractWarrior(150, 20.0, 90.0, weapon) {



    override val dodgeChance: Int
        get() = 50

    override fun checkAccuracy(accuracy: Int): Boolean {
        return true
    }

    override fun dodge(dodgeChance: Int): Boolean {
        return Random.nextBoolean()
    }
}