import java.util.Random;
import java.util.Scanner;

public class Scenario {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int scenarioID;
    Player player;
    Player[] playerArray;
    Shop shop = new Shop();

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
            System.out.println("2. Head to the marketplace and shop");






            int input = scanner.nextInt();
            if (input == 1) {
                int roll = random.nextInt(1,21) + player.luck;
                if (roll > 12) {
                    System.out.println("AYYYO!!!!! I GOT A LOST KID HERE!!!");
                    System.out.println("Success! You rolled " + roll + " + " + player.luck);
                }
                else {
                    System.out.println("Failure! You rolled " + roll + " + " + player.luck);
                    System.out.println("Damn. Guess you're out of luck, poor bastard.");
                }
            }



            else if (input == 2) {
                shop.player = player;
                System.out.println("Welcome to my shop. I hope you'll take a look at my wares, but don't try to negotiate, prices are rigid in these trying times.");
                shop.addItem(shop.potion);
                shop.rollShop();
            }
            else {
                System.out.println("Debug: Shop did not load");
            }

        }
    }

}
