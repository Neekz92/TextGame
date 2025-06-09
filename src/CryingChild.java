public class CryingChild extends SocialEncounter {

    @Override
    public void setup() {

        System.out.println("A crying child approaches you.");
        System.out.println("\"Will you help me find my parents? I'n lost...\"");
    }

    @Override
    public void options() {

        System.out.println("[ 1 ] Help the child");
        System.out.println("[ 2 ] Ignore the child. You've got more important things to do.");

        boolean chooseOption = true;
        while (chooseOption) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1: System.out.println("You search the busy marketplace, keeping your eyes peeled for a couple desperately searching for their missing child.");
                    if (playerArray[0].rollLuck() > 10) {
                        System.out.println("You found the irresponsible parents!");
                        chooseOption = false;
                        playerArray[0].getLocation().endEncounter();
                        return;
                    }
                    else {
                        System.out.println("Damn. Guess you're out of luck, you poor bastard.");
                        chooseOption = false;
                        playerArray[0].getLocation().endEncounter();
                    }
                }
            }
            catch(Exception e) {
                System.out.println("Invalid option.");
            }
        }

    }
}
