public class WoundedAdventurer extends SocialEncounter {

    public WoundedAdventurer() {}

    public void setup() {

        System.out.println("A woman's voice calls out to you.");
        System.out.println("\"You there! You're an adventurer too, right? My party was attacked by goblins. I'm the only survivor. I can't face those monsters again, will you avenge my comrades?\"");
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
                            int goblinsToKill = random.nextInt(1, gameEngine.amountOfCharacters + 1) + 1;
                            System.out.println("You have accepted a quest to subjugate " + goblinsToKill + " goblins.");
                            playerArray[0].quest = "Goblin Quest";
                            playerArray[0].orcsToKill = goblinsToKill;
                            playerArray[0].didASocialEncounterThisturn = true;
                            playerArray[0].getLocation().endSocialEncounter();
                            selectChoice = false;
                        } else {
                            System.out.println("You abandoned your previous quest and accept the new one.");
                            playerArray[0].wolvesToKill = 0;
                            playerArray[0].banditsToKill = 0;
                            playerArray[0].orcsToKill = 0;

                            int goblinsToKill = random.nextInt(1, gameEngine.amountOfCharacters + 1) + 1;
                            System.out.println("You have accepted a quest to subjugate " + goblinsToKill + " goblins.");
                            playerArray[0].quest = "Goblin Quest";
                            playerArray[0].goblinsToKill = goblinsToKill;
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