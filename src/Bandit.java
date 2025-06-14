public class Bandit extends Enemy {

    public Bandit(GameEngine gameEngine) {

        super(gameEngine);
        this.attack = 0;
        this.defense = 0;
        this.setHp(8);
        currentHp = getHp();

        setGold(5);
    }

    @Override
    public void combat() {

        if (findEnemies().length > 0) {
            int rng = random.nextInt(0, findEnemies().length);
            targetedEnemy = findEnemies()[rng];
            basicAttack();  //  For future enemies with more complex move lists, I might add basicAttack() to an array, along with its other moves like breathWeapon() etc, and then use rng to determine which one gets used.
        }
        else if (findEnemies().length == 1){
            targetedEnemy = findEnemies()[0];
            basicAttack();
        }
    }

    @Override
    public void basicAttackDescription() {
        System.out.println("The bandit tries to stab " + targetedEnemy + " with his dagger!");
    }
}
