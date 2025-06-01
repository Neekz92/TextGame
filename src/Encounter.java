import java.util.Random;
import java.util.Scanner;

public class Encounter {

    int amountOfParticipants = 0;
    Player[] playerArray = new Player[amountOfParticipants];  //  Player objects are referenced in the encounter object. The encounter object is created inside the location object.
    Player player;
    Location location;
    String description;
    String options;
    int amountOfOptions;
    String[] optionsArray = new String[amountOfOptions];
    Scanner scanner = new Scanner(System.in);
    Random random;
    int playerInput;




    public void add(Player player) {
        amountOfParticipants ++;
        Player[] playerArrayClone = new Player[amountOfParticipants];

        for (int i = 0; i < playerArray.length; i++) {
            playerArrayClone[i] = playerArray[i];
        }
        playerArrayClone[amountOfParticipants - 1] = player;
        playerArray = playerArrayClone;
        this.player = player;
    }



    public void addOptions(String option) {
        amountOfOptions++;
        String[] optionsArrayClone = new String[amountOfOptions];
        for (int i = 0; i < optionsArray.length; i++) {
            optionsArrayClone[i] = optionsArray[i];
        }
        optionsArrayClone[amountOfOptions - 1] = option;
        optionsArray = optionsArrayClone;
    }

    public void showOptions() {
        for (int i = 0; i < amountOfOptions; i++) {
            System.out.println(optionsArray[i]);
        }
    }


    public void showParticipants() {
        String returnMe = "";
        for (int i = 0; i < playerArray.length; i++) {
            returnMe += playerArray[i].getName() + " ";
        }
        System.out.println("Entities involved in this encounter: " + returnMe);
    }


    public Encounter() {

    }

    public void waitingDecision() {}

}
