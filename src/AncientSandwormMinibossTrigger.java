public class AncientSandwormMinibossTrigger extends SocialEncounter {

    public AncientSandwormMinibossTrigger() {

    }

    @Override
    public void setup() {

        distributedRewards = false;

        System.out.println("While traveling atop the scorching sands of the desert, you come across a massive drum. Though, the drum only seems to respond acoustically to a certain material.");
        description = "Sandworm Miniboss Encounter";
    }

    @Override
    public void options() {

        if (playerArray[0].inventory.contains(giantsCrown)) {

        } else {
            System.out.println("You cannot interact with this monolith.");
            playerArray[0].getLocation().endSocialEncounter();
            return;
        }



        boolean choice = true;
        while(choice) {
            System.out.println("[ 1 ] Use the [ Ancient Drumstick ] to pound the massive drum");
            System.out.println("[ 2 ] Do not interact with the drum");

            int input = scanner.nextInt();
            scanner.nextLine();

            switch(input) {
                case 1:
                    System.out.println("With full force, you smash the drum with the drum stick.");
                    System.out.println("You feel the sand shifting beneath your feet.");
                    System.out.println("Scorpions and vultures that were in the area rush to flee for safety.");
                    System.out.println("One of the nearby sand dunes explodes, and a super colossal Sandworm reveals itself!");
                    System.out.println("");

                    Encounter minibossSandwormAttack = new MinibossSandwormAttack();
                    playerArray[0].getLocation().encounter = minibossSandwormAttack;
                    minibossSandwormAttack.gameEngine = playerArray[0].gameEngine;

                    amountOfMobs++;
                    Enemy sandworm = new Sandworm(gameEngine);
                    minibossSandwormAttack.gameEngine.addPlayer(sandworm);
                    sandworm.setName("Desert Leviathan" + " (" + gameEngine.player.getLocation() + ")");
                    minibossSandwormAttack.addPlayer(sandworm);
                    minibossSandwormAttack.addPlayer(playerArray[0]);


                    sandworm.encounter = minibossSandwormAttack;
                    sandworm.hasEncounter = true;
                    sandworm.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesn't mean i assign X,Y coordinates!
                    sandworm.setY(gameEngine.player.getY());

                    playerArray[0].encounter = minibossSandwormAttack;
                    playerArray[0].hasEncounter = true;
                    minibossSandwormAttack.setup();
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