class Battle(private val team1: Team, private val team2: Team) {
    var isBattleFinished = false

    fun getBattleState(): BattleState {
        return when {
            !team1.isTeamAlive() && !team2.isTeamAlive() -> BattleState.Draw
            !team1.isTeamAlive() -> BattleState.Team2Victory
            !team2.isTeamAlive() -> BattleState.Team1Victory
            else -> BattleState.InProgress(team1.getTotalHealth() + team2.getTotalHealth(),
                team1.getRemainingWarriors() + team2.getRemainingWarriors())
        }
    }

    fun performIteration() {
        val allWarriors = mutableListOf<AbstractWarrior>()
        allWarriors.addAll(team1.warriors)
        allWarriors.addAll(team2.warriors)

        allWarriors.shuffle()

        for (warrior in allWarriors) {
            val enemyTeam = if (team1.warriors.contains(warrior)) team2 else team1
            val enemy = enemyTeam.getRandomWarrior()
            if (enemy != null && !warrior.isKilled) {
                warrior.attack(enemy)
            }
        }

        isBattleFinished = !team1.isTeamAlive() || !team2.isTeamAlive()
    }
}
