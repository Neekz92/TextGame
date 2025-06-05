public class WolfAttack extends Encounter {

    public WolfAttack() {

    }

    @Override
    public void setup() {

        int rng = random.nextInt(0, gameEngine.playerArray.length) + 3;
        System.out.println("You are surrounded by " + (rng) + " wolves at " + gameEngine.player.getLocation());

        int nameCounter = 1; //  This is the counter for each Wolf spawned. it will help identify them when players need to see them in the list of enemies.

        for (int i = 0; i < rng; i++) {
            Enemy wolf;
            gameEngine.addPlayer(wolf = new Wolf(gameEngine));
            wolf.setName("Wolf # " + nameCounter);
            nameCounter ++;
            addPlayer(wolf);
            wolf.encounter = this;
            wolf.hasEncounter = true;
            wolf.setLocation(gameEngine.player.getLocation());
            wolf.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesnt mean i assign X,Y coordinates!
            wolf.setY(gameEngine.player.getY());
        }
    }
}
