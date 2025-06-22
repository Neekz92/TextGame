public class CryingChild extends SocialEncounter {

    public CryingChild() {}

    public void setup() {

        System.out.println("You are approached by a sobbing child.");
        System.out.println("\"I can't find my parents. Will you help me?\"");
    }

    @Override
    public void options() {

        System.out.println("[ 1 ] Help the child find his parents");
        System.out.println("[ 2 ] Ignore the child. You have more important things to do.");

        boolean selectChoice = true;
        while (selectChoice) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1:
                    System.out.println("You search the crowds of people, looking for a couple desperately searching for their missing child.");
                    if (playerArray[0].rollLuck() + (playerArray[0].finalLuck / 5) > 10) {
                        System.out.println("You found the irresponsible parents!");
                        int goldReward = random.nextInt(0,(playerArray[0].finalLuck / 5) + 5) + 5;
                        playerArray[0].setGold(playerArray[0].getGold() + goldReward);
                        System.out.println(playerArray[0] + " received a reward of " + goldReward + " gold!");
                        playerArray[0].didASocialEncounterThisturn = true;
                        playerArray[0].getLocation().endSocialEncounter();
                        selectChoice = false;
                        break;
                    }
                    else {
                        System.out.println("Damn. Looks like you're out of luck, you poor bastard.");
                        playerArray[0].didASocialEncounterThisturn = true;
                        playerArray[0].getLocation().endSocialEncounter();
                        selectChoice = false;
                        break;
                    }
                    case 2: System.out.println("Fuck off, kid. I'm an adventurer, not a social worker.");
                    selectChoice = false;
                    playerArray[0].getLocation().endSocialEncounter();
                }
            }
            catch(Exception e) {
                System.out.println("Invalid option. Exception: " + e);
                scanner.nextLine();
            }
        }
    }
}
