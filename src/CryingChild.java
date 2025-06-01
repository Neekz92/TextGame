public class CryingChild extends Encounter {

    public CryingChild() {

        int input;

        this.description = "A crying child approaches you. What do you do?";
        addOptions("[1] Search the crowd for a couple, specifically a couple desperately searching for a missing child.");
        addOptions("[2] Ignore the kid. You've got bigger fish to fry.");
    }

    public void waitingDecision() {
        boolean waitingDecision = true;
        while (waitingDecision) {
            try {
                int input = scanner.nextInt();
                System.out.println("Debug: Input = " + input);
                scanner.nextLine();

                if (input == 1) {
                    if (player.rollLuck() > 12) {
                        System.out.println("Success");
                        waitingDecision = false;
                        scanner.nextLine();
                    }
                    else {
                        System.out.println("Failure!");
                        waitingDecision = false;
                        scanner.nextLine();
                    }
                }

                if (input == 2) {
                    System.out.println("Fuck off kid, I'm an adventurer not a social worker.");
                }
            } catch (Exception e) {
                System.out.println("Invalid option.");
                scanner.nextLine();
            }
        }
    }
}
