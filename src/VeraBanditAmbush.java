public class VeraBanditAmbush extends Encounter {

    Player bandit = new Bandit();

    public VeraBanditAmbush() {

        this.description = "You find yourself trying to catch a shortcut through an alley, and are confronted by a masked and cloaked man wielding a knife." +
                           "\n\"Gimme all 'yer coin. I know you 'ave a purse on you. Give it 'ere, or I'll spill your guts where you stand." +
                           "\nWhat do you do?";

        addOptions("[1] Draw your weapon, this chump doesn't know who he's messing with.");
        addOptions("[2] Hand over half your gold, you don't have time for this.");
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
                    add(bandit);
                    System.out.println("Don't fuck with me. It's time to meet your maker, bitch.");
                    waitingDecision = false;
                }
                else if (input == 2) {
                    System.out.println("Alright, I give up!");
                    player.setGold(player.getGold() - (player.getGold() / 2));
                    System.out.println("You gave half of your gold to the bandit");
                    waitingDecision = false;
                    location.hasEncounter = false;
                }
            }
            catch(Exception e) {
                System.out.println("Invalid option.");
                scanner.nextLine();
            }
        }
    }
}