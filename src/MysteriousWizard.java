public class MysteriousWizard extends SocialEncounter {

    public MysteriousWizard() {

    }

    @Override
    public void setup() {

        System.out.println("Traveling through the bustling streets, an old woman with a large brimmed witch's hat places her long wrinkly fingers on your shoulder.");
        System.out.println("\"Salutations my dear, I am aspiring to begin a potion selling business, but, some of my stronger recipes have gone untested.\"");
        System.out.println("\"I will pay you in gold if you'll help me test their lasting effects.");
    }

    @Override
    public void options() {

        String alteredStat1 = "";
        String alteredStat2 = "";

        int rngStatDecider = random.nextInt(1,5);

        switch (rngStatDecider) {
            case 1: alteredStat1 = "Attack"; break;
            case 2: alteredStat1 = "Defense"; break;
            case 3: alteredStat1 = "Luck"; break;
            case 4: alteredStat1 = "Hp"; break;
        }

        rngStatDecider = random.nextInt(1,5);

        switch (rngStatDecider) {
            case 1: alteredStat2 = "Attack"; break;
            case 2: alteredStat2 = "Defense"; break;
            case 3: alteredStat2 = "Luck"; break;
            case 4: alteredStat2 = "Hp"; break;
        }

        int alteredValue1 = random.nextInt(-3,4);
        int alteredValue2 = random.nextInt(-3,4);

        System.out.println("[ 1 ] Agree to test the mysterious hag's potions");
        System.out.println("[ 2 ] Respectfully decline her offer");

        boolean selectChoice = true;
        while (selectChoice) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                if (input == 1) {
                    switch (alteredStat1) {
                        case "Attack":
                            playerArray[0].attack += alteredValue1;
                            System.out.println(playerArray[0] + "'s [ Attack ] has been altered by: " + alteredValue1);
                            break;
                        case "Defense":
                            playerArray[0].defense += alteredValue1;
                            System.out.println(playerArray[0] + "'s [ Defense ] has been altered by: " + alteredValue1);
                            break;
                        case "Luck":
                            playerArray[0].luck += alteredValue1;
                            System.out.println(playerArray[0] + "'s [ Luck ] has been altered by: " + alteredValue1);
                            break;
                        case "Hp":
                            playerArray[0].hp += alteredValue1;
                            System.out.println(playerArray[0] + "'s [ HP ] has been altered by: " + alteredValue1);
                            break;
                    }

                    switch (alteredStat2) {
                        case "Attack":
                            playerArray[0].attack += alteredValue2;
                            System.out.println(playerArray[0] + "'s [ Attack ] has been altered by: " + alteredValue2);
                            break;
                        case "Defense":
                            playerArray[0].defense += alteredValue2;
                            System.out.println(playerArray[0] + "'s [ Defense ] has been altered by: " + alteredValue2);
                            break;
                        case "Luck":
                            playerArray[0].luck += alteredValue2;
                            System.out.println(playerArray[0] + "'s [ Luck ] has been altered by: " + alteredValue2);
                            break;
                        case "Hp":
                            playerArray[0].hp += alteredValue2;
                            System.out.println(playerArray[0] + "'s [ HP ] has been altered by: " + alteredValue2);
                            break;
                    }
                    playerArray[0].updateStats();

                    if (playerArray[0].attack <= 0) {
                        playerArray[0].attack = 5;
                    }

                    if (playerArray[0].defense <= 0) {
                        playerArray[0].defense = 5;
                    }

                    if (playerArray[0].luck <= 0) {
                        playerArray[0].luck = 0;
                    }

                    if (playerArray[0].hp <= 0) {
                        playerArray[0].hp = 5;
                    }

                    if (playerArray[0].finalHp < playerArray[0].currentHp) {
                        playerArray[0].currentHp = playerArray[0].finalHp;
                    }

                    System.out.println("\"Heh heh heh! Much gratitude, young one. As promised, here is your payment.\"");
                    int goldReward = random.nextInt(0,(playerArray[0].finalLuck / 5) + 5) + 5;
                    playerArray[0].setGold(playerArray[0].getGold() + goldReward);
                    System.out.println(playerArray[0] + " received " + goldReward + " gold!");
                    playerArray[0].didASocialEncounterThisturn = true;
                    playerArray[0].getLocation().endSocialEncounter();
                    selectChoice = false;
                }
                else {
                        System.out.println("\"Get away from me before I paint the cobblestone with your blood.\"");
                        selectChoice = false;
                        playerArray[0].getLocation().endSocialEncounter();
                }
            }
            catch(Exception e) {
                System.out.println("Invalid option.");
                scanner.nextLine();
            }
        }
    }
}