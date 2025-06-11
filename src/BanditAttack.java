public class BanditAttack extends CombatEncounter {

    public BanditAttack() {

    }

    @Override
    public void setup() {

        distributedRewards = false;
        addItem(potion);  //  Adding a potion to this encounter's loot pool
        addItem(sword);
        addItem(staff);
        addItem(bow);
        addItem(armor);


        int rng = random.nextInt(0, gameEngine.playerArray.length + 1) + 1;
        System.out.println("You are ambushed by " + (rng) + " bandits at " + gameEngine.player.getLocation() + "!");

        int nameCounter = 1;  //  This will increase each time a mob gets added, to help label them.

        for (int i = 0; i < rng; i++) {

            amountOfMobs++;
            Enemy bandit;
            gameEngine.addPlayer(bandit = new Bandit(gameEngine));
            bandit.setName("Bandit #" + nameCounter + " (" + gameEngine.player.getLocation() + ")");  //  Correctly labels each enemy spawned for the encounter.
            nameCounter++;

            addPlayer(bandit);
            bandit.encounter = this;
            bandit.hasEncounter = true;
            bandit.setLocation(gameEngine.player.getLocation());
            bandit.setX(gameEngine.player.getX());  //  REMEMBER: just because I assign a LOCATION, doesnt mean i assign X,Y coordinates!
            bandit.setY(gameEngine.player.getY());
        }
    }
}
