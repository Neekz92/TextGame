public class AncientGiantMinibossTrigger extends SocialEncounter {

    public AncientGiantMinibossTrigger() {

    }

    @Override
    public void setup() {

        distributedRewards = false;

        System.out.println("Atop the crest of the Stormpeak Mountain Summit, you come across a massive statue of a humanoid with an enormous hammer. He was the King of the Giants.");

    }

    @Override
    public void options() {

        if (playerArray[0].inventory.contains(giantsCrown)) {
            System.out.println("What do you do?");
        } else {
            System.out.println("You cannot interact with this monolith.");
            playerArray[0].getLocation().endSocialEncounter();
            return;
        }

        boolean choice = true;
        while (choice) {
            System.out.println("[ 1 ] Place your [ Ancient Giant's Crown ] atop the statue's head");
            System.out.println("[ 2 ] Do not interact with the statue.");
//            try {
            int input = scanner.nextInt();
            scanner.nextLine();
            System.out.println("DEBUG: input was: " + input);

            switch (input) {
                case 1:
                    playerArray[0].inventory.removeItem(giantsCrown);
                    System.out.println("You place the crown on top of its stone cranium.");
                    System.out.println("Suddenly, you hear the cracking of stone, and the ground trembles.");
                    System.out.println("SHATTER!! The statue fractures into millions of pieces, and a hulking figure emerges from within!");
                    System.out.println("\"Who dares intrude on the sacred Mountain of the Giants? As King, I shall not allow it. Prepare to be vanquished!\"");
                    System.out.println("");

                    Encounter minibossGiantAttack = new MinibossGiantAttack();
                    minibossGiantAttack.gameEngine = playerArray[0].gameEngine;
                    Player[] playerArrayClone = playerArray;
                    minibossGiantAttack.playerArray = playerArrayClone;

                    amountOfMobs++;
                    Enemy giantKing = new GiantKing(gameEngine);
                    minibossGiantAttack.gameEngine.addPlayer(giantKing);
                    giantKing.setName("Jörmungandr, the Giant King" + " (" + gameEngine.player.getLocation() + ")");
                    minibossGiantAttack.addPlayer(giantKing);
                    giantKing.encounter = minibossGiantAttack;
                    giantKing.hasEncounter = true;
                    giantKing.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesn't mean i assign X,Y coordinates!
                    giantKing.setY(gameEngine.player.getY());


                    minibossGiantAttack.addPlayer(playerArray[0]);
                    playerArray[0].getLocation().endSocialEncounter();

                    playerArray = playerArrayClone;
                    playerArray[0].getLocation().encounter = minibossGiantAttack;
                    playerArray[0].encounter = minibossGiantAttack;
                    playerArray[0].hasEncounter = true;
                    minibossGiantAttack.setup();
                    choice = false;
                    return;
                case 2:
                    System.out.println("\"I'm getting the hell out of here.\"");
                    playerArray[0].getLocation().endSocialEncounter();
                    choice = false;
                    break;
                default:
                    System.out.println("Invalid, default block");
            }
        }
//            catch(Exception e) {
        System.out.println("Invalid option.");
        scanner.nextLine();
    }
}