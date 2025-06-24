public class WoundedOrc extends SocialEncounter {

    public WoundedOrc() {

    }

    public void setup() {

        System.out.println("During your adventure, you find the tattered remains of a dead orc. His blood is scattered atop the ground that you walk.");
        System.out.println("It is quite obvious, wyverns are to blame for this massacre. You notice the clawed footprints of the presumed assailants. Do you wish to follow them?");
    }

    public void options() {

        System.out.println("[ 1 ] Accept the quest");
        System.out.println("[ 2 ] Ignore the quest");

        boolean selectChoice = true;
        while (selectChoice) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1:
                        if (playerArray[0].quest.equals("No Quest")) {
                            int wyvernsToKill = random.nextInt(1, gameEngine.amountOfCharacters + 1);
                            System.out.println("You have accepted a quest to subjugate " + wyvernsToKill + " wyverns.");
                            playerArray[0].quest = "Wyvern Quest";
                            playerArray[0].wyvernsToKill = wyvernsToKill;
                            playerArray[0].didASocialEncounterThisturn = true;
                            playerArray[0].getLocation().endSocialEncounter();
                            selectChoice = false;
                        } else {
                            System.out.println("You abandoned your previous quest and accept the new one.");
                            playerArray[0].wolvesToKill = 0;
                            playerArray[0].banditsToKill = 0;
                            playerArray[0].orcsToKill = 0;
                            playerArray[0].wyvernsToKill = 0;

                            int wyvernsToKill = random.nextInt(1, gameEngine.amountOfCharacters + 1);
                            System.out.println("You have accepted a quest to subjugate " + wyvernsToKill + " wyverns.");
                            playerArray[0].quest = "Wyvern Quest";
                            playerArray[0].wyvernsToKill = wyvernsToKill;
                            playerArray[0].didASocialEncounterThisturn = true;
                            playerArray[0].getLocation().endSocialEncounter();
                            selectChoice = false;
                        }
                        break;
                    case 2:
                        System.out.println("I've got more important things to do.");
                        selectChoice = false;
                        playerArray[0].rest();
                        playerArray[0].getLocation().endSocialEncounter();
                }
            } catch (Exception e) {
                System.out.println("Invalid option.");
                scanner.nextLine();
            }
        }
    }
}