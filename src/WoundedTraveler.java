public class WoundedTraveler extends SocialEncounter {

    public WoundedTraveler() {}

    public void setup() {

        System.out.println("Along your travels, you come across a wounded man and a broken cart.");
        System.out.println("\"You there..! Adventurer! I was sent on a quest to deliver a certain treasure to a noble, but alas, I was ambushed by Orcs. Please, go after the Orcs and retrieve the treasure...");
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
                            int orcsToKill = random.nextInt(3, 6);
                            System.out.println("You have accepted a quest to subjugate " + orcsToKill + " bandits.");
                            playerArray[0].quest = "Orc Quest";
                            playerArray[0].orcsToKill = orcsToKill;
                            playerArray[0].didASocialEncounterThisturn = true;
                            playerArray[0].getLocation().endSocialEncounter();
                            selectChoice = false;
                        } else {
                            System.out.println("You abandoned your previous quest and accept the new one.");
                            playerArray[0].wolvesToKill = 0;
                            playerArray[0].banditsToKill = 0;
                            playerArray[0].orcsToKill = 0;

                            int orcsToKill = random.nextInt(3, 6);
                            System.out.println("You have accepted a quest to subjugate " + orcsToKill + " orcs.");
                            playerArray[0].quest = "Orc Quest";
                            playerArray[0].orcsToKill = orcsToKill;
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
            }
        }
    }
}
