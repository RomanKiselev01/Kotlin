sealed class BattleState {
    class InProgress(val totalHealth: Int, val remainingWarriors: Int) : BattleState()
    object Team1Victory : BattleState()
    object Team2Victory : BattleState()
    object Draw : BattleState()
}
