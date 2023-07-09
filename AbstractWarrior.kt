abstract class AbstractWarrior(
    val maxHealth: Int,
    val evasion: Double,
    val accuracy: Double,
    val weapon: AbstractWeapon
) : Warrior {
    var currentHealth: Int = maxHealth
        private set




    override val isKilled: Boolean
        get() = currentHealth <= 0

    override val evasionChance: Double
        get() = evasion

    override fun attack(enemy: Warrior) {
        if (weapon.isMagazineEmpty()) {
            weapon.reload()
            return
        }
        val ammoStack = weapon.getAmmoStack()


        while (!ammoStack.isEmpty()) {
            val ammo = ammoStack.pop()

        }
        val ammo = weapon.getAmmoForFire()
        var totalDamage = 0

        while (ammo != null) {
            if (ammo.checkAccuracy(accuracy.toInt()) && !enemy.dodge(dodgeChance)) {
                val damage = ammo.calculateDamage()
                enemy.takeDamage(damage)
                totalDamage += damage
            }

            ammoStack.pop()
        }

        println("${this::class.simpleName} атакует ${enemy::class.simpleName} и наносит урон $totalDamage")
    }

    override fun takeDamage(damage: Int) {
        currentHealth -= damage
        if (currentHealth < 0) currentHealth = 0
        println("${this::class.simpleName} получает урон $damage")
    }

        fun createGeneral() {
            println("General create")
        }



}