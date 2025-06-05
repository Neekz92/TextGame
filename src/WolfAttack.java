public class WolfAttack extends Encounter {

    public WolfAttack() {

    }

    @Override
    public void setup() {

        int rng = random.nextInt(0, gameEngine.playerArray.length) + 3;
        System.out.println("You are surrounded by " + (rng) + " wolves");

        int nameCounter = 1; //  This is the counter for each Wolf spawned. it will help identify them when players need to see them in the list of enemies.

        for (int i = 0; i < rng; i++) {
            Enemy wolf;
            System.out.println("DEBUG: WolfAttack.java: gameEngine.player refers to: " + gameEngine.player + " at location: " + gameEngine.player.getLocation());
            gameEngine.addPlayer(wolf = new Wolf(gameEngine.player.getX(), gameEngine.player.getY(), gameEngine));
            wolf.setName("Wolf # " + nameCounter);
            nameCounter ++;
            addPlayer(wolf);
            wolf.encounter = this;
            wolf.hasEncounter = true;
            wolf.gameEngine = gameEngine;
            wolf.setLocation(playerArray[0].getLocation());
        }
    }
}
