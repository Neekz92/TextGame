public class GoblinAttack extends CombatEncounter {

    public GoblinAttack() {

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

        addItem(chainLightning);
        addItem(heal);

        addItem(criticalShot);
        addItem(rapidShot);


        int rng = random.nextInt(0, gameEngine.playerArray.length + 1) + 1;
        System.out.println(rng + " Goblins attack you at " + gameEngine.player.getLocation());

        int nameCounter = 1; //  This is the counter for each Orc spawned. it will help identify them when players need to see them in the list of enemies.

        for (int i = 0; i < rng; i++) {

            amountOfMobs++;
            Enemy goblin;
            gameEngine.addPlayer(goblin = new Goblin(gameEngine));
            goblin.setName("Goblin # " + nameCounter + " (" + gameEngine.player.getLocation() + ")");
            nameCounter++;
            addPlayer(goblin);
            goblin.encounter = this;
            goblin.hasEncounter = true;
            goblin.setLocation(gameEngine.player.getLocation());
            goblin.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesn't mean i assign X,Y coordinates!
            goblin.setY(gameEngine.player.getY());
        }
    }
}