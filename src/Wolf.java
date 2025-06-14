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

        if (findEnemies().length > 1) {
            int rng = random.nextInt(0, findEnemies().length);
            targetedEnemy = findEnemies()[rng];
            basicAttack();
        }
        else if (findEnemies().length == 1){
            targetedEnemy = findEnemies()[0];
            basicAttack();
        }
    }

    @Override
    public void basicAttackDescription() {
        System.out.println("The wolf tries to bite " + targetedEnemy + "!");
    }
}
