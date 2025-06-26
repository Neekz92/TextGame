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
            System.out.println("What do you do?");
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