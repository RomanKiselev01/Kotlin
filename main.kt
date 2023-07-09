fun main() {
    val team1 = Team()
    val team2 = Team()

    // Создаем команду 1
    team1.addWarrior(AbstractWeapon.Weapons.createSoldier())
    team1.addWarrior(AbstractWeapon.Weapons.createSoldier())
    team1.addWarrior(AbstractWeapon.Weapons.createSoldier())

    // Создаем команду 2
    team2.addWarrior(AbstractWeapon.Weapons.createSoldier())
    team2.addWarrior(AbstractWeapon.Weapons.createSoldier())

    val battle = Battle(team1, team2)

    println("=== Начало сражения ===")

    while (!battle.isBattleFinished) {
        val battleState = battle.getBattleState()

        when (battleState) {
            is BattleState.InProgress -> {
                println("=== Текущее состояние сражения ===")
                println("Суммарное здоровье: ${battleState.totalHealth}")
                println("Осталось воинов: ${battleState.remainingWarriors}")
                println("-------------------------------")

                battle.performIteration()
            }
            is BattleState.Team1Victory -> {
                println("=== Сражение завершено ===")
                println("Победила команда 1!")
                battle.isBattleFinished = true
            }
            is BattleState.Team2Victory -> {
                println("=== Сражение завершено ===")
                println("Победила команда 2!")
                battle.isBattleFinished = true
            }
            is BattleState.Draw -> {
                println("=== Сражение завершено ===")
                println("Ничья!")
                battle.isBattleFinished = true
            }
        }
    }

    println("=== Конец сражения ===")
}
