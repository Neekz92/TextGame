import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map map = new Map();
        int amountOfPlayers = 0;
        Player[] playerArray;

        boolean askForPlayers = true;
        while (askForPlayers) {
            System.out.println("How many players?");
            try {
                amountOfPlayers = scanner.nextInt();
                System.out.println("Very well. You will play with " + amountOfPlayers + " players.");
                askForPlayers = false;
            } catch (Exception e) {
                System.out.println("Enter a valid amount of players, FOOL.");
                scanner.next();
            }
        }
        playerArray = new Player[amountOfPlayers];


        boolean characterCreation = true;
        while (characterCreation == true) {
            for (int i = 0; i < playerArray.length; i++) {
                System.out.println("Player " + (i + 1) + ", what is your name?");
                String name = scanner.next();
                System.out.println("Very well, " + name + ". What is your class? \n 1. Warrior \n 2. Mage \n 3. Archer");
                String spec = "";
                boolean chooseClass = true;
                while (chooseClass) {
                    try {
                        int specNumber = scanner.nextInt();
                        switch (specNumber) {
                            case 1:
                                System.out.println("You have chosen the Warrior class.\n");
                                Player currentPlayer = new Warrior(name);
                                playerArray[i] = currentPlayer;
                                chooseClass = false;
                                break;
                            case 2:
                                System.out.println("You have chosen the Mage class. \n");
                                currentPlayer = new Mage(name);
                                playerArray[i] = currentPlayer;
                                chooseClass = false;
                                break;
                            case 3:
                                System.out.println("You have chosen the Archer class.\n");
                                currentPlayer = new Archer(name);
                                playerArray[i] = currentPlayer;
                                chooseClass = false;
                                break;
                            default:
                                System.out.println("You can't even pick a number correctly. Try again.\n");
                        }
                    } catch (Exception e) {
                        System.out.println("Pick a valid number, IMBECILE!\n");
                        scanner.next();
                    }
                }
            }
            characterCreation = false;
            System.out.println("Excellent. Your party consists of: ");
            for (int i = 0; i < playerArray.length; i++) {

                System.out.println(playerArray[i]);
            }
            System.out.println("************************************************ \n");
        }
        boolean gameOver = false;
        int turnCount = 1;
        int roundCount = 1;
        while (gameOver == false) {
            System.out.println("Round: " + roundCount);
            System.out.println("================================================");
            for (int i = 0; i < playerArray.length; i++) {
                System.out.println("Turn: " + turnCount + "\n" + playerArray[i] + "'s turn \n");
                playerArray[i].setLocation(map.findLocation(playerArray[i].getX(), playerArray[i].getY()));  //  Stores the location the current player is at inside the current player's file.
                map.describeLocation(playerArray[i]);  //  Print the description of the location for the current player.
                Encounter currentEncounter = playerArray[i].getLocation().encounter;  //  Setting the current player's encounter to a variable, so I don't have to keep typing it.
                currentEncounter.add(playerArray[i]);  //  Add the current player to the encounter at this tile.
                currentEncounter.scenario.rollScenario();


                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                turnCount++;

                if (turnCount == 2) {
                    gameOver = true;
                }
            }
            roundCount++;
        }
    }
}