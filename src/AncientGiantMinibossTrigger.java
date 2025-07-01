public class AncientGiantMinibossTrigger extends SocialEncounter {

    public AncientGiantMinibossTrigger() {

    }

    @Override
    public void setup() {

        distributedRewards = false;

        System.out.println("Atop the crest of the Stormpeak Mountain Summit, you come across a massive statue of a humanoid with an enormous hammer. He was the King of the Giants.");
        description = "Giant mini boss SOCIAL encounter";
    }

    @Override
    public void options() {

        if (playerArray[0].inventory.contains(giantsCrown)) {

        } else {
            System.out.println("You cannot interact with this monolith.");
            if (playerArray[0].getLocation().encounterArray.length > 0) {
                playerArray[0].getLocation().endSocialEncounter();
            }
            else {
                System.out.println("DEBUG from AncientGiantMiniBossTrigger.options(): some weird shit goin on here, encounter seems to be null.");
            }
            return;
        }

        boolean choice = true;
        while (choice) {
            System.out.println("[ 1 ] Place your [ Ancient Giant's Crown ] atop the statue's head");
            System.out.println("[ 2 ] Do not interact with the statue.");
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1:
                        playerArray[0].inventory.removeItem(giantsCrown);
                        System.out.println("You place the crown on top of its stone cranium.");
                        System.out.println("Suddenly, you hear the cracking of stone, and the ground trembles.");
                        System.out.println("SHATTER!! The statue fractures into millions of pieces, and a hulking figure emerges from within!");
                        System.out.println("\"Who dares intrude on the sacred Mountain of the Giants? As King, I shall not allow it. Prepare to be vanquished!\"");
                        System.out.println("");

                        Encounter minibossGiantAttack = new MinibossGiantAttack();
                        playerArray[0].getLocation().encounter = minibossGiantAttack;
                        minibossGiantAttack.gameEngine = playerArray[0].gameEngine;

                        amountOfMobs++;
                        Enemy giantKing = new GiantKing(gameEngine);
                        minibossGiantAttack.gameEngine.addPlayer(giantKing);
                        giantKing.setName("Jörmungandr, the Giant King" + " (" + gameEngine.player.getLocation() + ")");
                        minibossGiantAttack.addPlayer(giantKing);
                        minibossGiantAttack.addPlayer(playerArray[0]);


                        giantKing.encounter = minibossGiantAttack;
                        giantKing.hasEncounter = true;
                        giantKing.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesn't mean i assign X,Y coordinates!
                        giantKing.setY(gameEngine.player.getY());

                        playerArray[0].encounter = minibossGiantAttack;
                        playerArray[0].hasEncounter = true;
                        minibossGiantAttack.setup();
                        choice = false;
                        return;
                    case 2:
                        System.out.println("\"I'm getting the hell out of here.\"");
                        playerArray[0].getLocation().endSocialEncounter();
                        choice = false;
                        return;
                    default:
                        System.out.println("Invalid, default block");
                }
            } catch (Exception e) {
                System.out.println("Invalid option.");
                scanner.nextLine();
            }
        }
    }
}