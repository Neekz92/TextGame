public class AncientBabyDragonMinibossTrigger extends SocialEncounter {

    AncientBabyDragonMinibossTrigger() {

    }

    @Override
    public void setup() {

        distributedRewards = false;


        System.out.println("You stumple upon a cave that spirals downward underground. You hear low rumbling growls of some unknown creature from within.");
        System.out.println("Do you want to proceed deeper into the cavern?");
    }

    @Override
    public void options() {

        boolean chooseOption = true;
        while (chooseOption) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch(choice) {
                    case 1:
                        System.out.println(playerArray[0] + " delves deeper into the cave, the cacophony of guttural growls and grunts grows louder. Heavy footsteps can be heard with an increase in their rhythm.");
                        System.out.println("Soon enough, a juvenile dragon emerges from the darkness. The walls of the cavern are illuminated by the embers rolling out of the sides of its jaws. It lets out a fierce roar and charges!");
                        playerArray[0].getLocation().endSocialEncounter();

                }
            }
            catch (Exception e) {
                System.out.println("Invalid");
            }
        }
    }
}