package RPG.Characters;

public enum EnemyAI {
    
    ATTACK(1), SKILL(2), DEFEND(3);

    private final int enemyAction;

    EnemyAI(int enemyAction) {
        this.enemyAction = enemyAction;
    }

    public int getEnemyAction() {
        return this.enemyAction;
    }
}
