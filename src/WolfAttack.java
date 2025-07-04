public class WolfAttack extends CombatEncounter {

    public WolfAttack() {

        description = "Wolf Attack Encounter";

    }

    @Override
    public void setup() {

        distributedRewards = false;
        addItem(potion);  //  Adding a potion to this encounter's loot pool
        addItem(sword);
        addItem(staff);
        addItem(bow);
        addItem(armor);

        addItem(chainLightning);
        addItem(heal);
        addItem(haste);

        addItem(shieldBashCombo);
        addItem(perfectParry);
        addItem(taunt);

        addItem(criticalShot);
        addItem(rapidShot);
        addItem(igniteArrows);

        int rng = random.nextInt(0, gameEngine.cachedAmountOfPlayers + 1) + 1;
        System.out.println("You are surrounded by " + (rng) + " wolves at " + gameEngine.player.getLocation());

        int nameCounter = 1; //  This is the counter for each Wolf spawned. it will help identify them when players need to see them in the list of enemies.

        for (int i = 0; i < rng; i++) {

            amountOfMobs ++;
            Enemy wolf;
            gameEngine.addPlayer(wolf = new Wolf(gameEngine));
            wolf.setName("Wolf # " + nameCounter + " (" + gameEngine.player.getLocation() + ")");
            nameCounter ++;
            addPlayer(wolf);
            wolf.encounter = this;
            wolf.hasEncounter = true;
            wolf.setLocation(gameEngine.player.getLocation());
            wolf.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesn't mean i assign X,Y coordinates!
            wolf.setY(gameEngine.player.getY());
        }
    }
}
