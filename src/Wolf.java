public class Wolf extends Enemy {

    public Wolf(int x, int y, GameEngine gameEngine) {

        super(x, y, gameEngine);
        this.name = "Wolf";
        this.attack = 5;
        this.defense = 2;
        this.setHp(10);

    }

    @Override
    public void combat() {

        //System.out.println("DEBUG Wolf.java: combat() is running");
        //System.out.println("DEBUG Wolf.java: " + encounter.toString());
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
