public class Wolf extends Enemy {

    public Wolf(int x, int y) {

        this.name = "Wolf";
        setX(x);
        setY(y);
        this.attack = 5;
        this.defense = 2;
        this.setHp(10);
    }

    @Override
    public void combat() {

        int rng = random.nextInt(0, findEnemies().length);
        System.out.println("The wolf bites " + findEnemies()[rng] + "!");
    }
}
