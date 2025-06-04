public class Wolf extends Enemy {

    public Wolf(int x, int y) {

        super(x, y);
        this.name = "Wolf";
        this.attack = 5;
        this.defense = 2;
        this.setHp(10);
    }

    @Override
    public void combat() {

        int rng = random.nextInt(0, findEnemies().length);
        targetedEnemy = findEnemies()[rng];
        basicAttack();


    }

    @Override
    public void basicAttackDescription() {
        System.out.println("The wolf tries to bite " + targetedEnemy + "!");
    }



}
