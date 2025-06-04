public class WolfAttack extends Encounter {

    public WolfAttack() {

    }

    @Override
    public void setup() {

        int rng = random.nextInt(0, gameEngine.playerArray.length) + 2;
        System.out.println("You are surrounded by " + (rng) + " wolves");

        int nameCounter = 1; //  This is the counter for each Wolf spawned. it will help identify them when players need to see them in the list of enemies.

        for (int i = 0; i < rng; i++) {
            Enemy wolf;
            gameEngine.addPlayer(wolf = new Wolf(gameEngine.player.getX(), gameEngine.player.getY()));
            wolf.setName("Wolf # " + nameCounter);
            nameCounter ++;
            addPlayer(wolf);
            wolf.hasEncounter = true;
        }
    }
}
