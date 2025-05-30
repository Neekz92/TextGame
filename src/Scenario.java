import java.util.Random;
import java.util.Scanner;

public class Scenario {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int scenarioID;
    Player player;
    Player[] playerArray;

    public Scenario() {

        scenarioID = 0;
        player = null;
        playerArray = null;
    }



    public void rollScenario() {

        scenarioID = random.nextInt(1,2);
        vera_Crying_Child();

    }

    public void vera_Crying_Child() {

        if (scenarioID == 1) {
            System.out.println("A crying child approaches you. They ask: \n 'I am lost. Will you help me find my parents?");
            System.out.println("##########################################################################################");
            System.out.println("What do you do?");
            System.out.println("1. Search the crowded city, looking for a couple that is desperately trying to find their missing child");
            System.out.println("2. \"Fuck off, kid. I'm an adventure, not a social worker.");
            if (scanner.nextInt() == 1) {
                int roll = random.nextInt(1,21) + player.luck;
                if (roll > 12) {
                    System.out.println("Success! You rolled " + roll + " + " + player.luck);
                }
                else {
                    System.out.println("Failure! You rolled " + roll + " + " + player.luck);
                }
            }

        }
    }

}
