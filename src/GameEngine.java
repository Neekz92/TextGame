import java.util.Random;
import java.util.Scanner;

public class GameEngine {

    Scanner scanner;
    Random random;

    Player player;
    Player[] playerArray;
    DragonToken dragonToken;

    Map map;


    int amountOfCharacters;
    int currentAmountOfPlayers;

    static int citiesRemaining = 3;

    public GameEngine() {

        random = new Random();

        scanner = new Scanner(System.in);

        amountOfCharacters = 0;
        currentAmountOfPlayers = 0;
        playerArray = new Player[amountOfCharacters];

        dragonToken = new DragonToken();
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

        boolean howManyPlayers = true;
        while (howManyPlayers) {
            System.out.println("How many players?");
            try {
                currentAmountOfPlayers = scanner.nextInt();
                scanner.nextLine();
                howManyPlayers = false;
            }
            catch (Exception e) {
                System.out.println("Invalid input. Try again, but this time with integers.");
                scanner.nextLine();
            }
        }

        for (int i = 0; i < currentAmountOfPlayers; i++) {
            System.out.println("Player " + (1 + i) + ", what is your name?");
            String name = scanner.nextLine();

            boolean classSelection = true;
            while (classSelection) {
                System.out.println(name + ", what class are you?");
                System.out.println("[ 1 ] Warrior\n[ 2 ] Mage\n[ 3 ] Archer\n[ 4 ] Random");
                try {
                    int spec = scanner.nextInt();
                    scanner.nextLine();
                    switch (spec) {
                        case 1:
                            System.out.println("You have selected the Warrior class.");
                            player = new Warrior(this, name);
                            player.inventory = new Inventory();
                            player.inventory.player = player;
                            addPlayer(player);
                            player.updateStats();
                            classSelection = false;
                            break;

                        case 2:
                            System.out.println("You have selected the Mage class.");
                            player = new Mage(this, name);
                            player.inventory = new Inventory();
                            player.inventory.player = player;
                            addPlayer(player);
                            player.updateStats();
                            classSelection = false;
                            break;

                        case 3:
                            System.out.println("You have selected the Archer class.");
                            player = new Archer(this, name);
                            player.inventory = new Inventory();
                            player.inventory.player = player;
                            addPlayer(player);
                            player.updateStats();
                            classSelection = false;
                            break;

                        case 4:
                            spec = random.nextInt(1,4);

                            switch (spec) {
                                case 1:
                                    System.out.println("You have selected the Warrior class.");
                                    player = new Warrior(this, name);
                                    player.inventory = new Inventory();
                                    player.inventory.player = player;
                                    addPlayer(player);
                                    player.updateStats();
                                    classSelection = false;
                                    break;

                                case 2:
                                    System.out.println("You have selected the Mage class.");
                                    player = new Mage(this, name);
                                    player.inventory = new Inventory();
                                    player.inventory.player = player;
                                    addPlayer(player);
                                    player.updateStats();
                                    classSelection = false;
                                    break;

                                case 3:
                                    System.out.println("You have selected the Archer class.");
                                    player = new Archer(this, name);
                                    player.inventory = new Inventory();
                                    player.inventory.player = player;
                                    addPlayer(player);
                                    player.updateStats();
                                    classSelection = false;
                                    break;
                            }
                            break;




                        default:
                            System.out.println("Invalid option.");
                    }
                }
                catch (Exception e) {
                    System.out.println("You have to use WHOLE NUMBERS, don't screw this up. You're better than that.");
                    scanner.nextLine();
                }
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
            if (round == 200){
                roundManager = false;
            }
            for (int i = 0; i < amountOfCharacters; i++) {
                    if (round % 1 == 0) {
                        dragonToken.movement();
                        map.scorchLocation();
                        dragonToken.location = map.findLocation(dragonToken.x, dragonToken.y);
                        System.out.println("DEBUG: " + dragonToken.location + "(" + dragonToken.x + "," + dragonToken.y + ")");
                        if (dragonToken.location.isTown) {
                            System.out.println(dragonToken.location.name + " has been razed to the ground, and all the people have been burned to ashes.");
                            map.findLocation(dragonToken.x, dragonToken.y).isTown = false;
                            citiesRemaining --;
                            gameOver();
                        }

                    }

                    System.out.println("");
                    System.out.println(playerArray[i] + "'s turn. Location: " + playerArray[i].getLocation());

                    if (!playerArray[i].quest.equals("No Quest")) {

                        if (playerArray[i].wolvesToKill > 0) {
                            System.out.println("Quest: Kill " + playerArray[i].wolvesToKill + " wolves");
                        }

                        else if (playerArray[i].banditsToKill > 0) {
                            System.out.println("Quest: Kill " + playerArray[i].banditsToKill + " bandits");
                        }

                        else if (playerArray[i].orcsToKill > 0) {
                            System.out.println("Quest: Kill " + playerArray[i].orcsToKill + " orcs");
                        }

                        else if (playerArray[i].goblinsToKill > 0) {
                            System.out.println("Quest: Kill " + playerArray[i].orcsToKill + " goblins");
                        }
                    }


                    player = playerArray[i];     //  Set 'player' to the current player
                    player.gameEngine = this;   //  Set current player's GameEngine.
                    player.didASocialEncounterThisturn = false;

                    player.setLocation(map.findLocation(player.getX(), player.getY()));  //  set player's location
                    player.getLocation().gameEngine = this;  // Set the location's game engine
                    player.getLocation().shop.fillShop();
                    for (int j = 0; j < player.getLocation().shop.itemArray.length; j++) {  //  Reset the rolls on each item in the marketplace
                        player.getLocation().shop.itemArray[j].assignStats2();  // CURRENT ISSUE, NOTICE ME CHATGPT It should assign stats at the beginning of each turn
                    }

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
                    player.encounterPhase();
                    player.parryStance = false;


                    if (player.stunTimer > 0) {  //  If the player is stunned, don't attack.
                        System.out.println(player.getName() + " is stunned for " + player.stunTimer + " turns!");
                        player.stunTimer --;
                    }
                    else {
                        if (player.encounter instanceof CombatEncounter) {
                            player.combat();

                            if (player.hasteTimer > 0 && player.encounter != null) {  //  player gets another action if they still have > 0 haste timer
                                System.out.println(player + " is still empowered by Haste!");
                                player.combat();
                                player.hasteTimer--;
                                System.out.println(player + " has " + player.hasteTimer + " hasted actions remaining.");
                            }
                        }
                    }
                    if (player.didASocialEncounterThisturn == false && player.hasEncounter == false && player.getLocation().isTown && player.getLocation().isScorched == false) {
                        boolean rested = player.cityOptions();
                        if (rested) continue;
                    }
                    System.out.println("*************************************");
            }
        }
    }

    public boolean arePlayersAlive() {

        for (int i = 0; i < playerArray.length; i++) {
            if (playerArray[i].currentHp > 0) {
                return true;
            }
        }
        return false;
    }

    public void gameOver() {
        if (citiesRemaining == 0 && !arePlayersAlive()) {
            System.out.println("All cities have been destroyed. Game Over.");
        }
    }
}
