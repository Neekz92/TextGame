import com.sun.source.tree.Tree;

public class AncientTreeEntMinibossTrigger extends SocialEncounter {

    public AncientTreeEntMinibossTrigger() {

    }

    @Override
    public void setup() {

        distributedRewards = false;


        System.out.println("In the thickest part of the forest, you come across a shrine surrounded by large trees with human faces wearing twisted smiles carved into them.");
        System.out.println("In front of the largest one, a patch of dirt appears to be disturbed, like something was uprooted here.");
    }

    @Override
    public void options() {

        if (playerArray[0].inventory.contains(irredescentFlower)) {
        }
        else {
            System.out.println("You cannot interact with this monolith.");
            playerArray[0].getLocation().endSocialEncounter();
            return;
        }

        System.out.println("[ 1 ] Plant the [ Iridescent Flower ] in front of the large tree");
        System.out.println("[ 2 ] Do not interact with the dirt");

        boolean choice = true;
        while(choice) {
            int input = scanner.nextInt();
            scanner.nextLine();

            switch(input) {
                case 1:
                    System.out.println("You plant the flower in front of the tree, and pack the dirt around it tightly.");
                    System.out.println("You hear a rustling sound, and notice leaves fluttering to the ground");
                    System.out.println("Suddenly, the large tree lets out a loud, blood curdling shriek.");
                    System.out.println("It tries to whip " + playerArray[0] + " with its mighty branches!");
                    System.out.println("");

                    Encounter minibossTreeEntAttack = new MinibossTreeEntAttack();
                    playerArray[0].getLocation().encounter = minibossTreeEntAttack;
                    minibossTreeEntAttack.gameEngine = playerArray[0].gameEngine;

                    amountOfMobs++;
                    Enemy treeEnt = new TreeEnt(gameEngine);
                    minibossTreeEntAttack.gameEngine.addPlayer(treeEnt);
                    treeEnt.setName("Elderblight, Lord of the Forest" + " (" + gameEngine.player.getLocation() + ")");
                    minibossTreeEntAttack.addPlayer(treeEnt);
                    minibossTreeEntAttack.addPlayer(playerArray[0]);


                    treeEnt.encounter = minibossTreeEntAttack;
                    treeEnt.hasEncounter = true;
                    treeEnt.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesn't mean i assign X,Y coordinates!
                    treeEnt.setY(gameEngine.player.getY());

                    playerArray[0].encounter = minibossTreeEntAttack;
                    playerArray[0].hasEncounter = true;
                    minibossTreeEntAttack.setup();
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