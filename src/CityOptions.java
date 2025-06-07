import java.util.Scanner;

public class CityOptions {

    Player player;
    Scanner scanner = new Scanner(System.in);
    String[] optionsArray = { "[1] Visit the marketplace", "[2] Rest and recover"};
    Shop shop = new Shop();
    Item commonPotion = new Potion("Common");

    public void cityOptions() {

        for (int i = 0; i < optionsArray.length; i++) {
            System.out.println(optionsArray[i]);
        }

        boolean cityOptionsDecision = true;
        while (cityOptionsDecision) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input == 1) {
                    shop.player = player;
                    shop.addItem(commonPotion);
                    shop.rollShop();
                    cityOptionsDecision = false;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid option. " + e);
            }
        }
    }
}
