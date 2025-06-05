public class BanditAttack extends Encounter {

    public BanditAttack() {

    }

    @Override
    public void setup() {

        int rng = random.nextInt(0, gameEngine.playerArray.length) + 1;
        System.out.println("You are ambushed by " + (rng) + " bandits!");

        int nameCounter = 1;  //  This will increase each time a mob gets added, to help label them.

        for (int i = 0; i < rng; i++) {

            Enemy bandit;
            System.out.println("DEBUG: BanditAttack.java: gameEngine.player refers to: " + gameEngine.player + " at location: " + gameEngine.player.getLocation());
            gameEngine.addPlayer(bandit = new Bandit(gameEngine));
            bandit.setName("Bandit #" + nameCounter);  //  Correctly labels each enemy spawned for the encounter.
            nameCounter++;
            addPlayer(bandit);
            bandit.encounter = this;
            bandit.hasEncounter = true;
            bandit.gameEngine = gameEngine;
            bandit.setLocation(playerArray[0].getLocation());
        }
    }
}
