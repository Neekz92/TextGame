import java.util.Random;

public class Encounter {

    GameEngine gameEngine;
    Random random;
    String description;
    int amountOfPlayers = 0;
    Player[] playerArray = new Player[amountOfPlayers];

    boolean distributedRewards = false;
    int amountOfItems = 0;
    Item[] itemArray = new Item[amountOfItems];
    Item potion = new Potion();

    int amountOfMobs = 0;
    int xpBonus = 0;

    public Encounter() {
        random = new Random();
    }

    public void displayParticipants() {

        for (int i = 0; i < playerArray.length; i++) {
            System.out.println(playerArray[i].getName() + " === " + playerArray[i].currentHp + " HP");
        }
    }

    public void setup() {

    }

    public void addPlayer(Player player) {
        amountOfPlayers++;
        Player[] playerArrayClone = new Player[amountOfPlayers];
        for (int i = 0; i < playerArray.length; i++) {
            playerArrayClone[i] = playerArray[i];
        }
        playerArrayClone[amountOfPlayers - 1] = player;
        playerArray = playerArrayClone;
    }

    public void addItem(Item item) {
        amountOfItems++;
        Item[] itemArrayClone = new Item[amountOfItems];
        for (int i = 0; i < itemArray.length; i++) {
            itemArrayClone[i] = itemArray[i];
        }
        itemArrayClone[amountOfItems - 1] = item;
        itemArray = itemArrayClone;
    }


    public void removePlayer(Player player) {

        int index = 0;

        for (int i = 0; i < playerArray.length; i++) {  //  I can't remove the player from the array until I know that player's index.
            if (playerArray[i].equals(player)) {        //  This loop will determine the index of the player that is passed to it.
                index = i;
            }
        }


        if (amountOfPlayers > 0) {
            amountOfPlayers--;
            Player[] playerArrayClone = new Player[amountOfPlayers];
            for (int i = index; i < playerArray.length - 1; i++) {
                playerArrayClone[i] = playerArray[i + 1];
            }

            for (int i = 0; i < index; i++) {
                playerArrayClone[i] = playerArray[i];
            }

            playerArray = playerArrayClone;
        }
    }

    public boolean areHostilesDead() {

        int amountOfHostiles = 0;

        for (int i = 0; i < playerArray.length; i++) {
            if (playerArray[i] instanceof Enemy) {
                amountOfHostiles++;
            }
        }

        if (amountOfHostiles == 0) {
            return true;
        }
        return false;
    }



    public boolean arePlayersDead() {

        int amountOfPlayers = 0;

        for (int i = 0; i < playerArray.length; i++) {
            if (!(playerArray[i] instanceof Enemy)) {
                amountOfPlayers++;
            }
        }

        if (amountOfPlayers == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String returnMe = "";
        for (int i = 0; i < playerArray.length; i++) {
            returnMe += playerArray[i].getName() + " ";
        }
        return returnMe;
    }



    public void distributeRewards() {

        for (int i = 0; i < amountOfPlayers; i++) {
            int xp = (amountOfMobs / amountOfPlayers) + xpBonus;  //  I made this variable to slip into the actual xp formula so I don't have to rewrite the entire formula, I can just add this to the xp and give each mob a different xp bonus!

            if (xp <= 0) {
                xp = 1;
            }
            //System.out.println("DEBUG Encounter.java: " + amountOfMobs + " amount of mobs" + " " + amountOfPlayers + " amount of players");
            System.out.println(playerArray[i] + " recieved " + xp + " XP!");
            playerArray[i].setXp(playerArray[i].getXp() + xp);


            for (int j = 0; j < (playerArray[i].luck / 12) + 1; j++) {  //  Every 4 points in luck, will give a 2nd "tick" to maybe find an item drop.

                //System.out.println("DEBUG Encounter.distributeRewards() ~ Iteration = " + j + " Luck = " + playerArray[i].luck);
                int rng = random.nextInt(1, 6);  //  There's a 1 in 5 chance the current player will recieve an item drop.
                if (rng == 5) {

                    int randomDrop;
                    if (amountOfItems > 0) {  //  random.nextInt() won't work unless the first number is LESS THAN the second number. it wont work if its 0, 0
                        randomDrop = random.nextInt(0, amountOfItems); //  Roll a random number from 0 to amountOfItems. that will be the index of the item in the itemArray the player gets.
                    } else {
                        randomDrop = 0;
                    }
                    System.out.println(playerArray[i] + " looted: " + itemArray[randomDrop]);
                }
            }
        }
        amountOfMobs = 0;
    }



    public int countAmountOfEnemies() {
        int amountOfEnemies = 0;
        for (int i = 0; i < playerArray.length; i++) {
            if (playerArray[i] instanceof Enemy) {
                amountOfEnemies++;
            }
        }
        System.out.println("DEBUG: Encounter.countAmountOfEnemies = " + amountOfEnemies);
        return amountOfEnemies;
    }
}
