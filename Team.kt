class Team {
    val warriors: MutableList<AbstractWarrior> = mutableListOf()

    fun addWarrior(warrior: AbstractWarrior) {
        warriors.add(warrior)

    }

    fun getRandomWarrior(): AbstractWarrior? {
        return if (warriors.isNotEmpty()) {
            warriors.shuffled().first()
        } else {
            null
        }
    }

    fun isTeamAlive(): Boolean {
        return warriors.any { !it.isKilled }
    }

    fun getTotalHealth(): Int {
        return warriors.sumBy { it.currentHealth }
    }

    fun getRemainingWarriors(): Int {
        return warriors.count { !it.isKilled }
    }
}
