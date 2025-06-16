public class JobBoardBandit extends SocialEncounter {



    public JobBoardBandit() {

    }

    public void setup() {

        System.out.println("A sign hanging off the quest board catches your attention. It mentions the growing bandit outbreak and requests for someone to eliminate them.");
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
                            int banditsToKill = random.nextInt(3, 6);
                            System.out.println("You have accepted a quest to subjugate " + banditsToKill + " bandits.");
                            playerArray[0].quest = "Bandit Quest";
                            playerArray[0].banditsToKill = banditsToKill;
                            playerArray[0].didASocialEncounterThisturn = true;
                            playerArray[0].getLocation().endSocialEncounter();
                            selectChoice = false;
                        } else {
                            System.out.println("You abandoned your previous quest and accept the new one.");
                            playerArray[0].wolvesToKill = 0;
                            playerArray[0].banditsToKill = 0;
                            playerArray[0].orcsToKill = 0;

                            int banditsToKill = random.nextInt(3, 6);
                            System.out.println("You have accepted a quest to subjugate " + banditsToKill + " bandits.");
                            playerArray[0].quest = "Bandit Quest";
                            playerArray[0].banditsToKill = banditsToKill;
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
            }
        }
    }
}