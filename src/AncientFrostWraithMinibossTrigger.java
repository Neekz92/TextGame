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
            System.out.println("What do you do?");
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