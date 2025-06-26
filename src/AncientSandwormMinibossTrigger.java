public class AncientSandwormMinibossTrigger extends SocialEncounter {

    public AncientSandwormMinibossTrigger() {

    }

    @Override
    public void setup() {

        distributedRewards = false;


        System.out.println("While traveling atop the scorching sands of the desert, you come across a massive drum. Though, the drum only seems to respond acoustically to a certain material.");
        System.out.println("You cannot interact with this monolith. (I also haven't added the item needed to interact with it yet.)");
    }

    @Override
    public void options() {

        if (playerArray[0].inventory.contains(giantsCrown)) {
            System.out.println("What do you do?");
        }
        else {
            System.out.println("You cannot interact with this monolith.");
            playerArray[0].getLocation().endSocialEncounter();
            return;
        }

        System.out.println("[ 1 ] Use the [ Ancient Drumstick ] to pound the massive drum");
        System.out.println("[ 2 ] Do not interact with the drum");

        boolean choice = true;
        while(choice) {
            int input = scanner.nextInt();
            scanner.nextLine();

            switch(input) {
                case 1:
                    System.out.println("With full force, you smash the drum with the drum stick.");
                    System.out.println("You feel the sand shifting beneath your feet.");
                    System.out.println("Scorpions and vultures that were in the area begin quickly fleeing.");
                    System.out.println("One of the nearby sand dunes explodes, and a super colossal Sandworm reveals itself!");
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