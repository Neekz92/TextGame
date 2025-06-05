import java.util.Random;

public class Encounter {

    GameEngine gameEngine;
    Random random;
    String description;
    int amountOfPlayers = 0;
    Player[] playerArray = new Player[amountOfPlayers];

    public Encounter() {
        random = new Random();
    }

    public void displayParticipants() {

        for (int i = 0; i < playerArray.length; i++) {
            System.out.println(playerArray[i].getName() + " === " + playerArray[i].getHp() + " HP");
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




}
