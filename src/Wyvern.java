public class Wyvern extends Enemy {

    public Wyvern(GameEngine gameEngine) {

        super(gameEngine);
        this.attack = 60;
        this.defense = 60;
        this.setHp(80);
        currentHp = getHp();

        setGold(5);
    }

    @Override
    public void combat() {

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

    @Override
    public void basicAttackDescription() {
        System.out.println("The wyvern tries to slash " + targetedEnemy + " with its claws!");
    }
}
