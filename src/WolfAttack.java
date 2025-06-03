public class WolfAttack extends Encounter {

    Enemy wolf;
    public WolfAttack() {

    }


    @Override
    public void setup() {

        int rng = random.nextInt(0, gameEngine.playerArray.length) + 2;
        System.out.println("You are surrounded by " + (rng) + " wolves");
        for (int i = 0; i < rng; i++) {
            gameEngine.addPlayer(wolf = new Wolf(gameEngine.player.getX(), gameEngine.player.getY()));
        }
    }
}
