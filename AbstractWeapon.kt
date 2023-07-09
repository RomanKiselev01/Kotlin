abstract class AbstractWeapon(
    val maxAmmo: Int,
    val fireType: FireType
) {
    var ammoStack = Stack<Ammo>()

    fun createAmmo(ammo: Ammo) {
        ammoStack.push(ammo)
    }

    fun reload() {
        ammoStack = Stack<Ammo>()
        for (i in 0 until maxAmmo) {
            createAmmo(chooseRandomAmmo())
        }
    }

    fun getAmmoForShot(): Ammo? {
        return ammoStack.pop()
    }

    private fun chooseRandomAmmo(): Ammo {
        val ammoTypes = Ammo.values()
        return ammoTypes.random()
    }

    abstract fun shoot()
    abstract fun isMagazineEmpty(): Boolean

    fun getAmmoForFire(): Ammo? {
        return ammoStack.pop()
    }


    fun getAmmoStack(): Stack<Ammo> {
        return ammoStack
    }


    object Weapons {
        fun createPistol(): AbstractWeapon {
            return object : AbstractWeapon(10, FireType.SingleShot) {
                override fun shoot() {
                    val ammo = getAmmoForShot()
                    if (ammo != null) {
                        val damage = ammo.calculateDamage()
                        println("Pistol shot! Damage: $damage")
                    } else {
                        println("Pistol out of ammo!")
                    }
                }

                override fun isMagazineEmpty(): Boolean {
                    return ammoStack.isEmpty()
                }
            }
        }

        fun createRifle(): AbstractWeapon {
            return object : AbstractWeapon(30, FireType.BurstFire(3)) {
                override fun shoot() {
                    val ammo = getAmmoForShot()
                    if (ammo != null) {
                        val damage = ammo.calculateDamage()
                        println("Rifle shot! Damage: $damage")
                    } else {
                        println("Rifle out of ammo!")
                    }
                }

                override fun isMagazineEmpty(): Boolean {
                    return ammoStack.isEmpty()
                }
            }
        }

        fun createMinigun(): AbstractWeapon {
            return object : AbstractWeapon(30, FireType.BurstFire(3)) {
                override fun shoot() {
                    val ammo = getAmmoForShot()
                    if (ammo != null) {
                        val damage = ammo.calculateDamage()
                        println("Minigun shot! Damage: $damage")
                    } else {
                        println("Minigun out of ammo!")
                    }
                }

                override fun isMagazineEmpty(): Boolean {
                    return ammoStack.isEmpty()
                }
            }
        }

        fun createPukalka(): AbstractWeapon {
            return object : AbstractWeapon(30, FireType.BurstFire(3)) {
                override fun shoot() {
                    val ammo = getAmmoForShot()
                    if (ammo != null) {
                        val damage = ammo.calculateDamage()
                        println("Pukalka shot! Damage: $damage")
                    } else {
                        println("Pukalka out of ammo!")
                    }
                }


                override fun isMagazineEmpty(): Boolean {
                    return ammoStack.isEmpty()
                }
            }

        }
        fun createGeneral(): AbstractWarrior {
            val weapon = createRifle()
            return object : General(createMinigun()) {}
        }

        fun createCaptain(): AbstractWarrior {
            val weapon = createPukalka()
            return object : Captain(createPukalka()) {}
        }

        fun createSoldier(): AbstractWarrior {
            val weapon = createPistol()
            return object : Soldier(createRifle()) {}
        }
    }



}
