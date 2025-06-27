public class WyvernAttack extends CombatEncounter {

    public WyvernAttack() {

        xpBonus = 20;
        description = "Wyvern Attack Encounter";
    }

    @Override
    public void setup() {

        distributedRewards = false;
        addItem(uncommonPotion);  //  Adding a potion to this encounter's loot pool
        addItem(rarePotion);

        addItem(uncommonSword);
        addItem(rareSword);
        addItem(uncommonStaff);
        addItem(rareStaff);
        addItem(uncommonBow);
        addItem(rareBow);
        addItem(uncommonArmor);
        addItem(rareArmor);

        addItem(chainLightning);
        addItem(heal);
        addItem(haste);

        addItem(shieldBashCombo);
        addItem(perfectParry);
        addItem(taunt);

        addItem(criticalShot);
        addItem(rapidShot);
        addItem(igniteArrows);

        addItem(giantsCrown);
        addItem(irredescentFlower);
        addItem(cursedFragment);
        addItem(ancientDrumstick);
        addItem(enchantedIcePick);

        int rng = random.nextInt(1, gameEngine.cachedAmountOfPlayers + 1);
        System.out.println("From the sky," + rng +  " wyverns descend upon you, at " + gameEngine.player.getLocation());

        int nameCounter = 1; //  This is the counter for each Wolf spawned. it will help identify them when players need to see them in the list of enemies.

        for (int i = 0; i < rng; i++) {

            amountOfMobs ++;
            Enemy wyvern;
            gameEngine.addPlayer(wyvern = new Wyvern(gameEngine));
            wyvern.setName("Wyvern # " + nameCounter + " (" + gameEngine.player.getLocation() + ")");
            nameCounter ++;
            addPlayer(wyvern);
            wyvern.encounter = this;
            wyvern.hasEncounter = true;
            wyvern.setLocation(gameEngine.player.getLocation());
            wyvern.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesn't mean i assign X,Y coordinates!
            wyvern.setY(gameEngine.player.getY());
        }
    }
}
