import java.util.Random;
import java.util.Scanner;

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
        amountOfPlayers ++;
        Player[] playerArrayClone = new Player[amountOfPlayers];
        for (int i = 0; i < playerArray.length; i++) {
            playerArrayClone[i] = playerArray[i];
        }
        playerArrayClone[amountOfPlayers - 1] = player;
        playerArray = playerArrayClone;

    }

}
