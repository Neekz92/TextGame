public class CryingChild extends Encounter {

    public CryingChild() {

        int input;

        this.description = "A crying child approaches you. Sobbing, they ask, \"I'm lost. Will you help me find my parents?\" \nWhat do you do?";
        addOptions("[1] Search the crowd for a couple, specifically a couple desperately searching for a missing child.");
        addOptions("[2] Ignore the kid. You've got bigger fish to fry.");
    }

    @Override
    public void waitingDecision() {
        boolean waitingDecision = true;
        while (waitingDecision) {
            try {
                int input = scanner.nextInt();
                System.out.println("Debug: Input = " + input);
                scanner.nextLine();

                if (input == 1) {
                    if (player.rollLuck() > 12) {
                        System.out.println("\"AYYO! Anybody lose a KID!?\"");
                        System.out.println("Success! You find the irresponsible ass parents! You are awarded with 8 gold.");
                        waitingDecision = false;
                        player.setGold(player.getGold() + 8);
                        location.hasEncounter = false;
                    }
                    else {
                        System.out.println("Failure!");
                        waitingDecision = false;
                        location.hasEncounter = false;
                    }
                }

                if (input == 2) {
                    System.out.println("Fuck off kid. I'm an adventurer, not a social worker.");
                    waitingDecision = false;
                    location.hasEncounter = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid option.");
                scanner.nextLine();
            }
        }
    }
}
