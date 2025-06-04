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
            gameEngine.addPlayer(bandit = new Bandit(gameEngine.player.getX(), gameEngine.player.getY()));
            bandit.setName("Bandit #" + nameCounter);  //  Correctly labels each enemy spawned for the encounter.
            nameCounter++;
            addPlayer(bandit);
            bandit.hasEncounter = true;
        }
    }
}
