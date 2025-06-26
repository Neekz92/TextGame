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
            System.out.println("What do you do?");
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
                    playerArray[0].getLocation().endSocialEncounter();
                    choice = false;
                    break;
                case 2:
                    System.out.println("\"I'm getting the hell out of here.\"");
                    playerArray[0].getLocation().endSocialEncounter();
                    choice = false;
                    break;
            }
        }
    }
}