public class AncientFrostWraithMinibossTrigger extends SocialEncounter {

    public AncientFrostWraithMinibossTrigger() {

    }

    @Override
    public void setup() {

        distributedRewards = false;


        System.out.println("The temperature plummets as you climb to the top of the Shiverpeak Mountain Summit. At its peak, you discover a massive wall of frozen ice. You feel an icy gust, and with it comes a voice:");
        System.out.println("\"...Shatter the ice that entombs my spirit, for only my frost can stand against the hellfire that the realm shall suffer...");
    }

    @Override
    public void options() {

        if (playerArray[0].inventory.contains(giantsCrown)) {
        }
        else {
            System.out.println("You cannot interact with this monolith.");
            playerArray[0].getLocation().endSocialEncounter();
            return;
        }

        System.out.println("[ 1 ] Use the [ Enchanted Ice-Pick ] to shatter the wall of ice");
        System.out.println("[ 2 ] Do not interact with the statue");

        boolean choice = true;
        while(choice) {
            int input = scanner.nextInt();
            scanner.nextLine();

            switch(input) {
                case 1:
                    System.out.println("With all your might, you swing the Ice-Pick into the wall. Several cracks slowly spread up the structure.");
                    System.out.println("CRACK! Another swing, and the cracks multiply. It begins to look like the web of a great spider.");
                    System.out.println("Another swing, and then comes the noise similar to the sound of a thousand mirrors being shattered.");
                    System.out.println("The ice wall explodes, and a floating specter wreathed in a dark aura flies forward.");
                    System.out.println("");

                    Encounter minibossFrostWraithAttack = new MinibossFrostWraithAttack();
                    playerArray[0].getLocation().encounter = minibossFrostWraithAttack;
                    minibossFrostWraithAttack.gameEngine = playerArray[0].gameEngine;

                    amountOfMobs++;
                    Enemy frostWraith = new GiantKing(gameEngine);
                    minibossFrostWraithAttack.gameEngine.addPlayer(frostWraith);
                    frostWraith.setName("Coldshade, the Banished One" + " (" + gameEngine.player.getLocation() + ")");
                    minibossFrostWraithAttack.addPlayer(frostWraith);
                    minibossFrostWraithAttack.addPlayer(playerArray[0]);


                    frostWraith.encounter = minibossFrostWraithAttack;
                    frostWraith.hasEncounter = true;
                    frostWraith.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesn't mean i assign X,Y coordinates!
                    frostWraith.setY(gameEngine.player.getY());

                    playerArray[0].encounter = minibossFrostWraithAttack;
                    playerArray[0].hasEncounter = true;
                    minibossFrostWraithAttack.setup();
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