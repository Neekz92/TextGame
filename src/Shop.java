import java.util.Scanner;

public class Shop {

    Item[] itemArray;
    int amountOfItems;
    Potion potion;
    ExitShop exitShop;
    Scanner scanner = new Scanner(System.in);
    Player player;
    boolean isShopping = false;
    boolean isAvailable;


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
        isShopping = true;
        for (int i = 0; i < itemArray.length; i++) {
            while (isShopping) {
                int input = scanner.nextInt();

                if (input == 0) {
                    isShopping = false;                     //
                    amountOfItems = 0;                     //  Previously, during Player 2's turn, it would keep the items that it added if Player 1
                    itemArray = new Item[amountOfItems];  //   visited the shop, since that occurs in the Scenario class. I needed to clear the array, so this
                    addItem(exitShop);                   //    clears the array, and adds the exitShop object back into it.
                    break;
                }



                for (int j = 0; j < itemArray.length; j++) {   //
                    if (input == itemArray[i].ID) {           //  I need to check if the item that the player inputted is available. If they typed in a bogus number,
                        isAvailable = true;                  //   tell them they typed an invalid thing.
                    }
                }




                if (isAvailable && input == itemArray[i].ID) {
                    if (player.getGold() >= itemArray[i].getPrice()) {
                        player.setGold(player.getGold() - itemArray[i].getPrice());
                        System.out.println("You purchased " + itemArray[i].getName() + " for " + itemArray[i].getPrice() + " gold");
                        isShopping = false;
                    }
                    else if (isAvailable && player.getGold() < itemArray[i].getPrice()) {
                        System.out.println("You don't have enough gold.");
                        scanner.nextLine();
                        displayShop();
                    }
                }




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
