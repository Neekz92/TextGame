public class JobBoardWolf extends SocialEncounter {


    public JobBoardWolf() {

    }

    public void setup() {

        System.out.println("You notice a sign posted on the quest board requesting the subjugation of wolves. Would you like to accept this quest?");
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
                            int wolvesToKill = random.nextInt(3, 6);
                            System.out.println("You have accepted a quest to subjugate " + wolvesToKill + " wolves.");
                            playerArray[0].quest = "Wolf Quest";
                            playerArray[0].wolvesToKill = wolvesToKill;
                            playerArray[0].didASocialEncounterThisturn = true;
                            playerArray[0].getLocation().endSocialEncounter();
                            selectChoice = false;
                        } else {
                            System.out.println("You abandoned your previous quest and accept the new one.");
                            playerArray[0].wolvesToKill = 0;
                            playerArray[0].banditsToKill = 0;
                            playerArray[0].orcsToKill = 0;

                            int wolvesToKill = random.nextInt(3, 6);
                            System.out.println("You have accepted a quest to subjugate " + wolvesToKill + " wolves.");
                            playerArray[0].quest = "Wolf Quest";
                            playerArray[0].wolvesToKill = wolvesToKill;
                            playerArray[0].didASocialEncounterThisturn = true;
                            playerArray[0].getLocation().endSocialEncounter();
                            selectChoice = false;
                        }
                        break;
                    case 2:
                        System.out.println("I've got more important things to do.");
                        selectChoice = false;
                        playerArray[0].getLocation().endSocialEncounter();
                }
            } catch (Exception e) {
                System.out.println("Invalid option.");
                scanner.nextLine();
            }
        }
    }
}