public class Wolf extends Enemy {

    public Wolf(GameEngine gameEngine) {

        super(gameEngine);
        this.attack = 0;
        this.defense = 0;
        this.setHp(7);
        currentHp = getHp();
    }

    @Override
    public void combat() {

        enemyAITargetArray = findEnemies();

        if (enemyAITargetArray.length > 1) {
            int rng = random.nextInt(0, enemyAITargetArray.length);
            targetedEnemy = enemyAITargetArray[rng];
            basicAttack();
        }
        else if (enemyAITargetArray.length == 1){
            targetedEnemy = enemyAITargetArray[0];
            basicAttack();
        }
    }

    @Override
    public void basicAttackDescription() {
        System.out.println("The wolf tries to bite " + targetedEnemy + "!");
    }
}
