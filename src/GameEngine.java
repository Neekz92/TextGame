import java.util.Scanner;

public class GameEngine {

    Scanner scanner;

    Player player;
    Player[] playerArray;

    Map map;

    int amountOfCharacters;
    int currentAmountOfPlayers;

    public GameEngine() {

        scanner = new Scanner(System.in);

        amountOfCharacters = 0;
        currentAmountOfPlayers = 0;
        playerArray = new Player[amountOfCharacters];

        map = new Map(this);
        map.gameEngine = this;

    }

    public void addPlayer(Player player) {

        amountOfCharacters++;
        Player[] playerArrayClone = new Player[amountOfCharacters];
        for (int i = 0; i < playerArray.length; i++) {
            playerArrayClone[i] = playerArray[i];
        }
        playerArrayClone[amountOfCharacters - 1] = player;
        playerArray = playerArrayClone;
    }

    public void removePlayer(Player player) {

        int index = 0;

        for (int i = 0; i < playerArray.length; i++) {  //  I can't remove the player from the array until I know that player's index.
            if (playerArray[i].equals(player)) {        //  This loop will determine the index of the player that is passed to it.
                index = i;
            }
        }


        amountOfCharacters--;
        Player[] playerArrayClone = new Player[amountOfCharacters];
        for (int i = index; i < playerArray.length - 1; i++) {
            playerArrayClone[i] = playerArray[i + 1];
        }

        for (int i = 0; i < index; i++) {
            playerArrayClone[i] = playerArray[i];
        }

        playerArray = playerArrayClone;
    }


    @Override
    public String toString() {
        String returnMe = "";
        for (int i = 0; i < playerArray.length; i++) {
            returnMe += playerArray[i].getName() + " ";
        }
        return returnMe;
    }



    public void characterCreation() {

        System.out.println("How many players?");
        currentAmountOfPlayers = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < currentAmountOfPlayers; i++) {
            System.out.println("Player " + (1 + i) + ", what is your name?");
            String name = scanner.next();

            System.out.println(name + ", what class are you?");
            System.out.println("[ 1 ] Warrior\n[ 2 ] Mage\n[ 3 ] Archer");
            int spec = scanner.nextInt();
            switch (spec) {
                case 1:
                    System.out.println("You have selected the Warrior class.");
                    player = new Warrior(this, name);
                    addPlayer(player);
                    //System.out.println("Debug from character creation: " + name);
                    break;

                case 2:
                    System.out.println("You have selected the Mage class.");
                    player = new Mage(this, name);
                    addPlayer(player);
                    break;

                case 3:
                    System.out.println("You have selected the Archer class.");
                    player = new Archer(this, name);
                    addPlayer(player);
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println("Character creation complete.\nYour party consists of:");
        for (int i = 0; i < playerArray.length; i++) {
            System.out.println(playerArray[i]);
        }
    }

    public void turnOrder() {

        boolean roundManager = true;
        int round = 1;
        while (roundManager) {
            System.out.println("Round: " + round);
            round++;
            if (round == 40){
                roundManager = false;
            }
            for (int i = 0; i < amountOfCharacters; i++) {
                    System.out.println(playerArray[i] + "'s turn. Location: " + playerArray[i].getLocation());
                    player = playerArray[i];     //  Set 'player' to the current player
                    player.gameEngine = this;   //  Set current player's GameEngine.

                    player.setLocation(map.findLocation(player.getX(), player.getY()));  //  set player's location
                    player.getLocation().gameEngine = this;  // Set the location's game engine

                    if (player.getLocation().encounter == null) {  //  If the player location is not currently engaged in an encounter,
                        player.movementPhase();  //  Allow the player to move
                        player.setLocation(map.findLocation(player.getX(), player.getY()));  //  set player's location after moving
                        // System.out.println("DEBUG 2: " + player + "'s location has been assigned to " + player.getLocation());
                        player.getLocation().gameEngine = this;  // Set the location's game engine after moving
                    }

                    if (player.getLocation().encounter != null) {  //  If the location the player gets to has an encounter,
                        player.encounter = player.getLocation().encounter;  //  Set the player's encounter to whatever the location's encounter is
                        if (player.hasEncounter == false) {
                            player.encounter.addPlayer(player);  //  Adds the current player to the Encounter's player array.
                            player.hasEncounter = true;
                        }
                    } else {  //  If the location has no encounter
                        if (!(player instanceof Enemy)) {  // Bugs appeared that caused mobs to roll new encounters... I'm thinking this might fix it
                            //System.out.println(player + " is calling rollEncounter() from the else block at (" + player.getX() + "," + player.getY() + " ) " + player.getLocation());+
                            player.getLocation().rollEncounter();  //  Randomly roll an encounter
                            player.encounter = player.getLocation().encounter;  //  Set the player's encounter to whatever the location's encounter is. Just like above.
                            player.encounter.gameEngine = this; // Set the Encounter's game engine
                            player.encounter.setup();
                            if (player.hasEncounter == false) {
                                player.encounter.addPlayer(player);  //  Adds the current player to the Encounter's player array. Just like above.
                                player.hasEncounter = true;
                            }
                        }
                    }
                    //System.out.println("DEBUG GameEngine.java: " + player.getName());
                    player.encounterPhase();
                    if (player.isStunned) {  //  If the player is stunned, don't attack.
                        System.out.println(player.getName() + " is stunned!");
                        player.isStunned = false;
                    }
                    else {
                        player.combat();
                    }
                    System.out.println("*************************************");

            }
        }
    }
}
