public class Bandit extends Enemy {

    public Bandit(int x, int y, GameEngine gameEngine) {

        super(gameEngine);
        this.name = "Bandit";
        this.attack = 3;
        this.defense = 1;
        this.setHp(10);

        setGold(5);
    }

    @Override
    public void combat() {

//        int rng = random.nextInt(0, findEnemies().length);
//        System.out.println("The bandit stabs " + findEnemies()[rng] + " with his dagger!");


        //System.out.println("DEBUG Bandit.java: combat() is running");
        //System.out.println("DEBUG Bandit.java: " + encounter.toString());
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
