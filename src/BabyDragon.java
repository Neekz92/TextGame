public class BabyDragon extends Enemy {

    public BabyDragon(GameEngine gameEngine) {

        super(gameEngine);
        this.attack = 90;
        this.defense = 90;
        this.setHp(350);
        currentHp = getHp();

        setGold(5);
    }

    @Override
    public void combat() {

        for (int i = 0; i < gameEngine.cachedAmountOfPlayers; i++) {
            enemyAITargetArray = findEnemies();
            if (enemyAITargetArray.length > 0) {
                int rng = random.nextInt(0, enemyAITargetArray.length);
                targetedEnemy = enemyAITargetArray[rng];
                basicAttack();  //  For future enemies with more complex move lists, I might add basicAttack() to an array, along with its other moves like breathWeapon() etc, and then use rng to determine which one gets used.
            } else if (enemyAITargetArray.length == 1) {
                targetedEnemy = enemyAITargetArray[0];
                basicAttack();
            }
        }
    }

    @Override
    public void basicAttackDescription() {
        System.out.println("The juvenile Dragon tries to swipe " + targetedEnemy + " with its claws!");
    }
}
