public class OrcAttack extends CombatEncounter {

    public OrcAttack() {

        xpBonus = 5;

    }

    @Override
    public void setup() {

        distributedRewards = false;
        addItem(potion);  //  Adding a potion to this encounter's loot pool
        addItem(uncommonPotion);


        addItem(sword);
        addItem(uncommonSword);

        addItem(staff);
        addItem(uncommonStaff);

        addItem(bow);
        addItem(uncommonBow);

        addItem(armor);
        addItem(uncommonArmor);




        addItem(shieldBashCombo);
        addItem(perfectParry);
        addItem(taunt);

        addItem(chainLightning);
        addItem(heal);
        addItem(haste);

        addItem(criticalShot);
        addItem(rapidShot);
        addItem(igniteArrows);


        int rng = random.nextInt(0, gameEngine.playerArray.length + 1) + 1;
        System.out.println(rng + " snarling orcs draw their axes and charge toward you, at " + gameEngine.player.getLocation());

        int nameCounter = 1; //  This is the counter for each Orc spawned. it will help identify them when players need to see them in the list of enemies.

        for (int i = 0; i < rng; i++) {

            amountOfMobs ++;
            Enemy orc;
            gameEngine.addPlayer(orc = new Orc(gameEngine));
            orc.setName("Orc # " + nameCounter + " (" + gameEngine.player.getLocation() + ")");
            nameCounter ++;
            addPlayer(orc);
            orc.encounter = this;
            orc.hasEncounter = true;
            orc.setLocation(gameEngine.player.getLocation());
            orc.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesn't mean i assign X,Y coordinates!
            orc.setY(gameEngine.player.getY());
        }
    }
}