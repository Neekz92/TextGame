import com.sun.source.tree.Tree;

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

    Scorchwyrm dragon;

    Encounter dragonAttack = new DragonAttack(this);

    public GameEngine() {

        random = new Random();

        scanner = new Scanner(System.in);

        amountOfCharacters = 0;
        currentAmountOfPlayers = 0;
        playerArray = new Player[amountOfCharacters];

        map = new Map(this);
        map.gameEngine = this;

        dragon = new Scorchwyrm(this);
        dragon.gameEngine = this;
        dragonAttack.description = "Dragon Attack";
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

        dragonToken = new DragonToken(this);
        map.dragonToken = dragonToken;
        dragonToken.location = map.findLocation(dragonToken.x, dragonToken.y);

        System.out.println("Character creation complete.\nYour party consists of:");
        for (int i = 0; i < playerArray.length; i++) {
            System.out.println(playerArray[i]);
        }
    }

    public void turnOrder() {

        int citiesDestroyed = 0;

        boolean roundManager = true;
        int round = 1;
        while (roundManager && gameOver() == false) {
            System.out.println("Round: " + round);
            System.out.println("Tiles scorched: " + Map.tilesRemaining);
            System.out.println("Cities remaining: " + citiesRemaining);
            System.out.println("Scorchwyrm is at: " + dragonToken.location + "(" + dragonToken.x + "," + dragonToken.y + ")");
            round++;
            if (round == Integer.MAX_VALUE){
                roundManager = false;
            }

            if (gameOver() == false && !dragonToken.hasEncounter) {
                dragonToken.location = map.findLocation(dragonToken.x, dragonToken.y);
                dragonToken.location.remove(dragonAttack);

                if (!isOnMiniboss()) {
                    map.scorchLocation();
                }

                if (map.scorchwyrmsLair.encounterArray.length == 0) {
                    map.scorchwyrmsLair.add(new AncientBabyDragonMinibossTrigger());
                }
                dragonToken.movement();
                dragonToken.location = map.findLocation(dragonToken.x, dragonToken.y);



                for (int i = 0; i < playerArray.length; i++) {  //  Check if the Dragon is on the same location as any other player after it moves
                    Player currentPlayer = playerArray[i];

                    if (dragonToken.location.equals(currentPlayer.getLocation())) {
                        dragonToken.hasEncounter = true;

                        System.out.println("");
                        System.out.println("**********");
                        System.out.println("**********");
                        System.out.println("**********");
                        System.out.println("Barreling down from from the sky, Scorchwyrm the Destroyer has revealed itself!");
                        System.out.println("**********");
                        System.out.println("**********");
                        System.out.println("**********");
                        System.out.println("");

                        currentPlayer.getLocation().encounter.addPlayer(dragon);
                        addPlayer(dragon);
                        dragon.setX(player.getX());
                        dragon.setY(player.getY());
                        dragon.setLocation(map.findLocation(dragon.getX(), dragon.getY()));
                        dragon.setName("Scorchwyrm, Destroyer of Realms" + " (" + dragon.getLocation() + ")");
                        DragonAttack.amountOfDragons ++;
                        break;
                    }

                }

                dragonToken.location.add(dragonAttack);
                System.out.println("DEBUG: dragonAttack event should be added " + dragonToken.location.name + " | " + dragonToken.location.encounterArray.length);



                if (dragonToken.location.isTown) {
                    System.out.println("");
                    System.out.println("********");
                    System.out.println("******** " + dragonToken.location.name + " has been razed to the ground, and all the people have been burned to ashes. ********");
                    System.out.println("********");
                    System.out.println("");
                    map.findLocation(dragonToken.x, dragonToken.y).isTown = false;
                    citiesRemaining--;
                    if (gameOver()) {
                        roundManager = false;
                        break;
                    }
                }
            }


            for (int i = 0; i < amountOfCharacters; i++) {
                    if (round % 1 == 0) {

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
                            System.out.println("Quest: Kill " + playerArray[i].goblinsToKill + " goblins");
                        }
                    }


                    player = playerArray[i];     //  Set 'player' to the current player

                    if (player.encounter == null && player.getLocation().encounter != null) {
                        player.encounter = player.getLocation().encounter;
                    }

                    player.gameEngine = this;   //  Set current player's GameEngine.
                    player.didASocialEncounterThisturn = false;

                    player.setLocation(map.findLocation(player.getX(), player.getY()));  //  set player's location
                    player.getLocation().gameEngine = this;  // Set the location's game engine
                    player.getLocation().shop.fillShop();
                    for (int j = 0; j < player.getLocation().shop.itemArray.length; j++) {  //  Reset the rolls on each item in the marketplace
                        player.getLocation().shop.itemArray[j].assignStats2();
                    }

                    if (player.getLocation().encounter == null) {  //  If the player location is not currently engaged in an encounter,

                        player.encounter = null;
                        player.hasEncounter = false;
                        player.movementPhase();  //  Allow the player to move
                        player.setLocation(map.findLocation(player.getX(), player.getY()));  //  set player's location after moving
                        player.getLocation().gameEngine = this;  // Set the location's game engine after moving
                    }

                    if (player.getLocation().encounter != null) {  //  If the location the player gets to has an encounter,
                        player.encounter = player.getLocation().encounter;  //  Set the player's encounter to whatever the location's encounter is

                        if (player.hasEncounter == false) {
                            player.encounter.addPlayer(player);  //  Adds the current player to the Encounter's player array.
                            player.hasEncounter = true;
                        }
                    }
                    else {  //  If the location has no encounter
                        if (!(player instanceof Enemy) && !player.getLocation().equals(dragonToken.location)) {  // Bugs appeared that caused mobs to roll new encounters... I'm thinking this might fix it
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
                    if (!player.didASocialEncounterThisturn && !player.hasEncounter && player.getLocation().isTown && !player.getLocation().isScorched) {
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

    public boolean gameOver() {
        if (citiesRemaining == 0 || !arePlayersAlive()) {
            return true;
        }
        return false;
    }

    public boolean isOnMiniboss() {

        if (dragonToken.x == 0 && dragonToken.y == 5) {
            return true;
        }

        if (dragonToken.x == 5 && dragonToken.y == 5) {
            return true;
        }

        if (dragonToken.x == 5 && dragonToken.y == 0) {
            return true;
        }

        if (dragonToken.x == 5 && dragonToken.y == 10) {
            return true;
        }

        if (dragonToken.x == 10 && dragonToken.y == 10) {
            return true;
        }

        return false;
    }
}
