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
        System.out.println("The goblin tries to stab " + targetedEnemy + "!");
    }
}