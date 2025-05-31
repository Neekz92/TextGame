import java.util.Scanner;

public class Shop {

    Item[] itemArray;
    int amountOfItems;
    Potion potion;
    ExitShop exitShop;
    Scanner scanner = new Scanner(System.in);
    Player player;


    public Shop() {

        amountOfItems = 0;
        itemArray = new Item[amountOfItems];
        exitShop = new ExitShop();
        addItem(exitShop);
        potion = new Potion();
        player = null;
    }

    public void addItem(Item item) {

        amountOfItems ++;
        Item[] itemArrayClone = new Item[amountOfItems];
        for (int i = 0; i < itemArray.length; i++) {
            itemArrayClone[i] = itemArray[i];
        }
        itemArrayClone[amountOfItems - 1] = item;
        itemArray = itemArrayClone;
    }



    public void rollShop() {

        displayShop();
        boolean isShopping = true;
        while (isShopping) {
            boolean itemIsAvailable = false;
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < itemArray.length; i++) {
                    if (input == itemArray[i].ID) {
                        itemIsAvailable = true;
                        if (player.getGold() >= itemArray[i].getPrice()) {
                            System.out.println("Purchased " + itemArray[i].getName());
                        }
                        else {
                            System.out.println("Not enough gold.");
                        }
                    }
                }
                if (itemIsAvailable == false) {
                    System.out.println("This item is not available.");
                }
            }
            catch (Exception e) {
                System.out.println("Enter a valid number.");
                scanner.nextLine();
            }
        }
    }



    public void displayShop() {

        System.out.println("Gold: " + player.getGold());
        for (int i = 0; i < amountOfItems; i++) {
            System.out.println(itemArray[i].toString());
        }
    }
}
