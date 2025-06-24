public class MinibossBabyDragonAttack extends CombatEncounter {

    public MinibossBabyDragonAttack() {

    }

    @Override
    public void setup() {

        distributedRewards = false;
        addItem(legendaryPotion);
        addItem(legendaryArmor);
        addItem(legendarySword);
        addItem(legendaryStaff);
        addItem(legendaryBow);

        System.out.println("The juvenile dragon charges forward at full speed, at " + gameEngine.player.getLocation() + "!");

        amountOfMobs++;
        Enemy babyDragon;
        gameEngine.addPlayer(babyDragon = new BabyDragon(gameEngine));
        babyDragon.setName("Juvenile Dragon" + " (" + gameEngine.player.getLocation() + ")");
        addPlayer(babyDragon);
        babyDragon.encounter = this;
        babyDragon.hasEncounter = true;
        babyDragon.setLocation(gameEngine.player.getLocation());
        babyDragon.getLocation().encounter = this;
        babyDragon.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesn't mean i assign X,Y coordinates!
        babyDragon.setY(gameEngine.player.getY());
    }
}

