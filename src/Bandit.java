public class Bandit extends Enemy {

    public Bandit(int x, int y) {

        super(x, y);
        this.name = "Bandit";
        this.attack = 3;
        this.defense = 1;
        this.setHp(8);

        setGold(5);
    }

    @Override
    public void combat() {

//        int rng = random.nextInt(0, findEnemies().length);
//        System.out.println("The bandit stabs " + findEnemies()[rng] + " with his dagger!");

        int rng = random.nextInt(0, findEnemies().length);
        targetedEnemy = findEnemies()[rng];
        basicAttack();
    }

    @Override
    public void basicAttackDescription() {
        System.out.println("The bandit tries to stab " + targetedEnemy + " with his dagger!");
    }
}
