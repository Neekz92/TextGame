public class Goblin extends Enemy {

    public Goblin(GameEngine gameEngine) {

        super(gameEngine);
        this.attack =20;
        this.defense = 20;
        this.setHp(15);
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
        System.out.println("The goblin tries to stab " + targetedEnemy + "!");
    }
}