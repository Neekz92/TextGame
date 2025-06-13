public class MysteriousWizard extends SocialEncounter {

    public MysteriousWizard() {

    }

    @Override
    public void setup() {

        System.out.println("Traveling through the bustling streets, an old woman with a large brimmed witch's hat places her long wrinkly fingers on your shoulder.");
        System.out.println("\"Salutations my dear, I am aspiring to embark on a business selling potions, and some of my stronger recipes have gone untested.\"");
        System.out.println("\"I will pay you 3 gold pieces if you'll help me test their lasting effects.");
    }

    @Override
    public void options() {

        String alteredStat1;
        String alteredStat2;

        int rngStatDecider = random.nextInt(1,5);

        switch (rngStatDecider) {
            case 1: alteredStat1 = "Attack"; break;
            case 2: alteredStat1 = "Defense"; break;
            case 3: alteredStat1 = "Luck"; break;
            case 4: alteredStat1 = "Hp"; break;
        }

        rngStatDecider = random.nextInt(1,5);

        switch (rngStatDecider) {
            case 1: alteredStat1 = "Attack"; break;
            case 2: alteredStat1 = "Defense"; break;
            case 3: alteredStat1 = "Luck"; break;
            case 4: alteredStat1 = "Hp"; break;
        }

        int alteredValue1 = random.nextInt(-5,6);
        int alteredValue2 = random.nextInt(-5,6);

        System.out.println("[ 1 ] Agree to test the mysterious hag's potions");
        System.out.println("[ 2 ] Respectfully decline her offer");

        boolean selectChoice = true;
        while (selectChoice) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                if (input == 1) {
                    //switch (alteredStat1) {
                    //    case "Attack":
                    }
                //}
            }
            catch(Exception e) {
                System.out.println("Invalid option.");
            }
        }
    }
}