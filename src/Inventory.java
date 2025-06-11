import java.util.Scanner;

public class Inventory {

    Scanner scanner = new Scanner(System.in);
    int amountOfItems;
    Item[] itemArray = new Item[amountOfItems];
    Player player;

    public Inventory() {
    }

    public void addItem(Item item) {

        amountOfItems++;
        Item[] inventoryClone = new Item[amountOfItems];

        for (int i = 0; i < itemArray.length; i++) {
            inventoryClone[i] = itemArray[i];
        }
        inventoryClone[amountOfItems - 1] = item;
        itemArray = inventoryClone;
    }

    public int findItemIndex(Item item) {

        for (int i = 0; i < itemArray.length; i++) {
            if (item.equals(itemArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public void removeItem(int index) {

        amountOfItems--;
        Item[] inventoryClone = new Item[amountOfItems];
        for (int i = 0; i < findItemIndex(player.selectedItem); i++) {
            inventoryClone[i] = itemArray[i];
        }
        for (int i = findItemIndex(player.selectedItem); i < inventoryClone.length; i++) {
            inventoryClone[i] = itemArray[i + 1];
        }
        itemArray = inventoryClone;
    }

    public void displayInventory() {

        if (player.inventory.itemArray.length == 0) {
            System.out.println("Your Inventory is empty.");
            return;  // CHATGPT NOTICE ME: like this?
        } else {
            System.out.println(this + "'s Inventory:");
            for (int i = 0; i < player.inventory.itemArray.length; i++) {
                Item currentItem = player.inventory.itemArray[i];
                if (!(currentItem instanceof Potion)) {
                    System.out.println("[ " + (i + 1) + " ] " + currentItem + " === " + "Attack: " + currentItem.attack + " | Defense: " + currentItem.defense + " | " + "Luck: " + currentItem.luck + " | " + "HP: " + currentItem.hp);
                } else {
                    System.out.println("[ " + (i + 1) + " ] " + currentItem);
                }
            }
            System.out.println("[ 0 ] Exit");
        }
    }

    public void openInventory() {

        displayInventory();
        if (player.inventory.itemArray.length == 0) {
            return;
        }

        int itemSelect = scanner.nextInt();
        scanner.nextLine();

        if (itemSelect == 0) {
            player.movementPhaseOptions();
            return;
        }

        Item selectedItem = player.inventory.itemArray[itemSelect - 1];

        System.out.println("What would you like to do with " + selectedItem + "?");
        System.out.println("[ 1 ] Use");
        System.out.println("[ 2 ] Trade");
        System.out.println("[ 3 ] Exit");

        int itemInteraction = scanner.nextInt();
        scanner.nextLine();

        switch (itemInteraction) {
            case 1:
                if (selectedItem instanceof Armor) {
                    if (player.armor == null) {
                        player.armor = (Armor) selectedItem;
                        player.updateStats();
                        System.out.println("You equipped " + player.armor);
                        removeItem(findItemIndex(player.armor));
                        player.movementPhaseOptions();
                        return;
                    }
                    else {
                        System.out.println("Do you want to swap these two armors?");
                        System.out.println("[ 1 ] Yes");
                        System.out.println("[ 2 ] No");

                        int wantToSwapItem = scanner.nextInt();
                        switch (wantToSwapItem) {
                            case 1:
                                Item tempItem = player.armor;
                                player.armor = (Armor) selectedItem;
                                player.updateStats();
                                System.out.println("You equipped " + player.armor);
                                player.inventory.itemArray[itemSelect - 1] = tempItem;
                                return;
                        }
                    }
                    return;
                }
                else if (selectedItem instanceof Sword) {
                    if (player instanceof Warrior) {
                        if (player.weapon == null) {
                            player.weapon = selectedItem;
                            player.updateStats();
                            System.out.println("You equipped " + player.weapon);
                            // TODO: remove weapon from inventory
                            return;
                        }
                        else {
                            System.out.println("Do you want to swap these two weapons?");
                            System.out.println("[ 1 ] Yes");
                            System.out.println("[ 2 ] No");

                            int wantToSwapItem = scanner.nextInt();
                            switch (wantToSwapItem) {
                                case 1:
                                    Item tempItem = player.weapon;
                                    player.weapon = selectedItem;
                                    player.updateStats();
                                    System.out.println("You equipped " + player.weapon);
                                    player.inventory.itemArray[itemSelect - 1] = tempItem;
                                    return;
                            }
                        }
                        return;
                    }
                    else {
                        System.out.println("You are not proficient with this weapon.");
                        return;
                    }
                }
                else if (selectedItem instanceof Staff) {
                    if (player instanceof Mage) {
                        if (player.weapon == null) {
                            player.weapon = selectedItem;
                            player.updateStats();
                            System.out.println("You equipped " + player.weapon);
                            // TODO: remove weapon from inventory
                            return;
                        }
                        else {
                            System.out.println("Do you want to swap these two weapons?");
                            System.out.println("[ 1 ] Yes");
                            System.out.println("[ 2 ] No");
                            int wantToSwapItem = scanner.nextInt();
                            switch (wantToSwapItem) {
                                case 1:
                                    Item tempItem = player.weapon;
                                    player.weapon = selectedItem;
                                    player.updateStats();
                                    System.out.println("You equipped " + player.weapon);
                                    player.inventory.itemArray[itemSelect - 1] = tempItem;
                                    return;
                            }
                        }
                        return;
                    }
                    else {
                        System.out.println("You are not proficient with this weapon.");
                        return;
                    }
                }
                else if (selectedItem instanceof Bow) {
                    if (player instanceof Archer) {
                        if (player.weapon == null) {
                            player.weapon = selectedItem;
                            player.updateStats();
                            System.out.println("You equipped " + player.weapon);
                            // TODO: remove weapon from inventory
                            return;
                        }
                        else {
                            System.out.println("Do you want to swap these two weapons?");
                            System.out.println("[ 1 ] Yes");
                            System.out.println("[ 2 ] No");
                            int wantToSwapItem = scanner.nextInt();
                            switch (wantToSwapItem) {
                                case 1:
                                    Item tempItem = player.weapon;
                                    player.weapon = selectedItem;
                                    player.updateStats();
                                    System.out.println("You equipped " + player.weapon);
                                    player.inventory.itemArray[itemSelect - 1] = tempItem;
                                    return;
                                case 2:
                                    player.movementPhaseOptions();
                                    return;
                            }
                        }
                    }
                    else {
                        System.out.println("You are not proficient with this weapon.");
                        return;
                    }
                }
                else if (selectedItem instanceof Potion) {
                    System.out.println("You drank a " + selectedItem + " and healed for " + selectedItem.healAmount + " hp!");
                    player.currentHp = player.currentHp + selectedItem.healAmount;
                    if (player.currentHp > player.finalHp) {
                        player.currentHp = player.finalHp;
                    }
                    removeItem(findItemIndex(selectedItem));
                    return;
                }
                return;
            case 2:
                System.out.println("Trade is not yet implemented.");
                return;
            default: break;
        }
        System.out.println("########################");
        player.movementPhaseOptions();
    }
}
