public class AncientCavernMinibossTrigger extends SocialEncounter {

    public AncientCavernMinibossTrigger() {

    }

    @Override
    public void setup() {

        distributedRewards = false;


        System.out.println("You wander into a dark cavern, guided only by torchlight. You step over the bones of countless people that have long-since been sent to the underworld. There are rusted swords buried into the ground, their handles poking out.");
        System.out.println("At the end of the cave, you find a mural depicting a legion of armed corpses marching on the three Kingdoms. The mural has a section of it missing, perhaps stolen.");
        System.out.println("\"...Return the fragment, and you shall invite our mercy for when we rise...\")");
    }

    @Override
    public void options() {

        if (playerArray[0].inventory.contains(cursedFragment)) {
        }
        else {
            System.out.println("You cannot interact with this monolith.");
            playerArray[0].getLocation().endSocialEncounter();
            return;
        }

        System.out.println("[ 1 ] Fit the [ Cursed Fragment ] into the socket of the mural");
        System.out.println("[ 2 ] Do not interact with the mural");

        boolean choice = true;
        while(choice) {
            int input = scanner.nextInt();
            scanner.nextLine();

            switch(input) {
                case 1:
                    System.out.println("You place the fragment into the missing piece, like completing a dark puzzle.");
                    System.out.println("Before long, you hear the shifting of dirt.");
                    System.out.println("Several long-decayed bodies of deceased men unearth themselves.");
                    System.out.println(playerArray[0] + " is surrounded by flesh-less corpses who have somehow been given new life.");
                    System.out.println("");

                    Encounter minibossUndeadAttack = new MinibossUndeadAttack();
                    playerArray[0].getLocation().encounter = minibossUndeadAttack;
                    minibossUndeadAttack.gameEngine = playerArray[0].gameEngine;

                    amountOfMobs++;
                    Enemy deathKnight = new DeathKnight(gameEngine);
                    minibossUndeadAttack.gameEngine.addPlayer(deathKnight);
                    deathKnight.setName("Valrick the Oathbreaker" + " (" + gameEngine.player.getLocation() + ")");
                    minibossUndeadAttack.addPlayer(deathKnight);

                    int nameCounter = 1; //  This is the counter for each Wolf spawned. it will help identify them when players need to see them in the list of enemies.
                    for (int i = 0; i < 5; i++) {
                        Enemy undeadMinion = new UndeadMinion(gameEngine);
                        minibossUndeadAttack.gameEngine.addPlayer(undeadMinion);
                        undeadMinion.setName(("Minion of Valrick # " + nameCounter + " (" + gameEngine.player.getLocation() + ")"));
                        nameCounter++;
                        minibossUndeadAttack.addPlayer(undeadMinion);

                        undeadMinion.encounter = minibossUndeadAttack;
                        undeadMinion.hasEncounter = true;
                        undeadMinion.setX(gameEngine.player.getX());
                        undeadMinion.setY(gameEngine.player.getY());
                    }

                    minibossUndeadAttack.addPlayer(playerArray[0]);


                    deathKnight.encounter = minibossUndeadAttack;
                    deathKnight.hasEncounter = true;
                    deathKnight.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesn't mean i assign X,Y coordinates!
                    deathKnight.setY(gameEngine.player.getY());

                    playerArray[0].encounter = minibossUndeadAttack;
                    playerArray[0].hasEncounter = true;

                    minibossUndeadAttack.setup();
                    choice = false;
                    return;
                case 2:
                    System.out.println("\"I'm getting the hell out of here.\"");
                    playerArray[0].getLocation().endSocialEncounter();
                    choice = false;
                    return;
            }
        }
    }
}