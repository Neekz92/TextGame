public class AncientBabyDragonMinibossTrigger extends SocialEncounter {

    AncientBabyDragonMinibossTrigger() {

        description = "Baby Dragon Social Encounter";
    }

    @Override
    public void setup() {

        distributedRewards = false;


        System.out.println("You stumble upon a cave that spirals downward underground. You hear low rumbling growls of some unknown creature from within.");
        System.out.println("Do you want to proceed deeper into the cavern?");
    }

    @Override
    public void options() {

        boolean chooseOption = true;
        while (chooseOption) {
            System.out.println("[ 1 ] Press further into the black abyss that lies ahead");
            System.out.println("[ 2 ] Exit the cave");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        Encounter minibossBabyDragonAttack = new MinibossBabyDragonAttack();
                        minibossBabyDragonAttack.gameEngine = playerArray[0].gameEngine;
                        Player[] playerArrayClone = playerArray;
                        minibossBabyDragonAttack.playerArray = playerArrayClone;

                        amountOfMobs++;
                        Enemy babyDragon = new BabyDragon(gameEngine);
                        minibossBabyDragonAttack.gameEngine.addPlayer(babyDragon);
                        babyDragon.setName("Juvenile Dragon" + " (" + gameEngine.player.getLocation() + ")");
//                        playerArray[0].getLocation().encounter = minibossBabyDragonAttack;
                        minibossBabyDragonAttack.addPlayer(babyDragon);
                        babyDragon.encounter = minibossBabyDragonAttack;
                        babyDragon.hasEncounter = true;
                        babyDragon.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesn't mean i assign X,Y coordinates!
                        babyDragon.setY(gameEngine.player.getY());

                        minibossBabyDragonAttack.addPlayer(playerArray[0]);

                        playerArray[0].getLocation().endSocialEncounter();

                        System.out.println(playerArrayClone[0] + " delves deeper into the cave, the cacophony of guttural growls and grunts grows louder. Heavy footsteps can be heard with an increase in their rhythm.");
                        System.out.println("Soon enough, a juvenile dragon emerges from the darkness. The walls of the cavern are illuminated by the embers rolling out of the sides of its open jaw. It lets out a fierce roar and charges!");
                        System.out.println("");

                        playerArray = playerArrayClone;
                        playerArray[0].getLocation().encounter = minibossBabyDragonAttack;
                        playerArray[0].encounter = minibossBabyDragonAttack;
                        playerArray[0].hasEncounter = true;
                        minibossBabyDragonAttack.setup();
                        chooseOption = false;
                        return;

                    case 2:
                        System.out.println("\"This cave is too scary. I'm not going in there.\"");
                        chooseOption = false;
                        playerArray[0].getLocation().endSocialEncounter();
                        break;
                    default:
                        System.out.println("invalid. default block");
                }
            } catch (Exception e) {
                System.out.println("Invalid" + " " + e);
                scanner.nextLine();
            }
        }
    }
}