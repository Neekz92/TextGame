import java.util.Scanner;

public class Inventory {

    Scanner scanner = new Scanner(System.in);
    int amountOfItems;
    Item[] itemArray = new Item[amountOfItems];
    Player player;

    Item selectedItem;


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

    public void removeItem(Item item) {

        amountOfItems--;
        Item[] inventoryClone = new Item[amountOfItems];
        for (int i = 0; i < findItemIndex(item); i++) {
            inventoryClone[i] = itemArray[i];
        }
        for (int i = findItemIndex(item); i < inventoryClone.length; i++) {
            inventoryClone[i] = itemArray[i + 1];
        }
        itemArray = inventoryClone;
    }

    public void displayInventory() {

        if (player.inventory.itemArray.length == 0) {
            System.out.println("Your Inventory is empty.");
            displayCurrentGear();
        } else {
            System.out.println(player + "'s Inventory:");
            displayCurrentGear();
            for (int i = 0; i < player.inventory.itemArray.length; i++) {
                Item currentItem = player.inventory.itemArray[i];
                System.out.println("[ " + (i + 1) + " ] " + currentItem.displayItem());
            }
            System.out.println("[ 0 ] Exit");
        }
    }

    public void displayCurrentGear() {
        System.out.println("Armor: " + player.armor + " === " + "Attack: " + player.armor.attack + " | Defense: " + player.armor.defense + " | Luck: " + player.armor.luck + " | HP: " + player.armor.hp);
        System.out.println("Weapon: " + player.weapon + " === " + "Attack: " + player.weapon.attack + " | Defense: " + player.weapon.defense + " | Luck: " + player.weapon.luck + " | HP: " + player.weapon.hp);
        System.out.println("");;
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

        selectedItem = player.inventory.itemArray[itemSelect - 1];

        System.out.println("What would you like to do with " + selectedItem + "?");
        System.out.println("[ 1 ] Use");
        System.out.println("[ 2 ] Gift");
        System.out.println("[ 0 ] Exit");

        int itemInteraction = scanner.nextInt();
        scanner.nextLine();

        switch (itemInteraction) {
            case 1:

                if (selectedItem instanceof Spell) {
                    if (player instanceof Mage) {
                        ((Mage) player).addSpell((Spell) selectedItem);
                        //selectedItem.name = "Chain-Lightning";
                        player.inventory.removeItem(selectedItem);
                        System.out.println(player + " learned how to cast " + selectedItem.name);
                        player.movementPhaseOptions();
                    }
                    else {
                        System.out.println("You are no Mage. You don't understand magic.");
                        player.movementPhaseOptions();
                    }
                }

                if (selectedItem instanceof Skill) {
                    if (player instanceof Warrior) {
                        ((Warrior) player).addSkill((Skill) selectedItem);
                        player.inventory.removeItem(selectedItem);
                        System.out.println(player + " learned how to perform " + selectedItem.name);
                        player.movementPhaseOptions();
                    }
                    else {
                        System.out.println("You are no Warrior. You don't understand sword skills.");
                        player.movementPhaseOptions();
                    }
                }

                if (selectedItem instanceof Stunt) {
                    if (player instanceof Archer) {
                        ((Archer) player).addStunt((Stunt) selectedItem);
                        player.inventory.removeItem(selectedItem);
                        System.out.println(player + " learned how to do " + selectedItem.name);
                        player.movementPhaseOptions();
                    }
                    else {
                        System.out.println("You are no Archer. You don't understand bow stunts.");
                        player.movementPhaseOptions();
                    }
                }




                if (selectedItem instanceof Armor) {
                    if (player.armor == null) {
                        player.armor = (Armor) selectedItem;
                        player.updateStats();
                        System.out.println("You equipped " + player.armor);
                        removeItem(player.armor);
                        player.movementPhaseOptions();
                        return;
                    } else {
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
                                player.movementPhaseOptions();
                                return;
                        }
                    }
                    return;
                } else if (selectedItem instanceof Sword) {
                    if (player instanceof Warrior) {
                        if (player.weapon == null) {
                            player.weapon = selectedItem;
                            player.updateStats();
                            System.out.println("You equipped " + player.weapon);
                            // TODO: remove weapon from inventory
                            return;
                        } else {
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
                                    player.movementPhaseOptions();
                                    return;
                            }
                        }
                        return;
                    } else {
                        System.out.println("You are not proficient with this weapon.");
                        return;
                    }
                } else if (selectedItem instanceof Staff) {
                    if (player instanceof Mage) {
                        if (player.weapon == null) {
                            player.weapon = selectedItem;
                            player.updateStats();
                            System.out.println("You equipped " + player.weapon);
                            // TODO: remove weapon from inventory
                            return;
                        } else {
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
                                    player.movementPhaseOptions();
                                    return;
                            }
                        }
                        return;
                    } else {
                        System.out.println("You are not proficient with this weapon.");
                        return;
                    }
                } else if (selectedItem instanceof Bow) {
                    if (player instanceof Archer) {
                        if (player.weapon == null) {
                            player.weapon = selectedItem;
                            player.updateStats();
                            System.out.println("You equipped " + player.weapon);
                            // TODO: remove weapon from inventory
                            return;
                        } else {
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
                                    player.movementPhaseOptions();
                                    return;
                                case 2:
                                    player.movementPhaseOptions();
                                    return;
                            }
                        }
                    } else {
                        System.out.println("You are not proficient with this weapon.");
                        return;
                    }
                } else if (selectedItem instanceof Potion) {
                    System.out.println("You drank a " + selectedItem + " and healed for " + selectedItem.healAmount + " hp!");
                    player.currentHp = player.currentHp + selectedItem.healAmount;
                    if (player.currentHp > player.finalHp) {
                        player.currentHp = player.finalHp;
                    }
                    player.movementPhaseOptions();
                    removeItem(selectedItem);
                    return;
                }
                return;
            case 2:
                System.out.println("Who would you like to gift [ " + selectedItem + " ] to?");
                trade();
            case 0: player.movementPhaseOptions();
        }
    }


    public Player[] partyArray() {

        int amountOfPartyMembers = 0;
        for (int i = 0; i < player.gameEngine.playerArray.length; i++) {
            if (!((player.gameEngine.playerArray[i]) instanceof Enemy)) {
                amountOfPartyMembers++;
            }
        }

        Player[] partyArray = new Player[amountOfPartyMembers];
        for (int i = 0; i < player.gameEngine.playerArray.length; i++) {
            if (!(player.gameEngine.playerArray[i] instanceof Enemy)) {
                partyArray[i] = player.gameEngine.playerArray[i];
            }
        }
        return partyArray;
    }


    public void trade() {

        for (int i = 0; i < partyArray().length; i++) {
            System.out.println("[ " + (i + 1) + " ] " + partyArray()[i]);
        }

        int input = scanner.nextInt() - 1;  //  If the input is 1, that needs to correspond to the first position in the partyArray which is [0]. It's n - 1
        scanner.nextLine();

        player.targetedEnemy = partyArray()[input];

        if (player.getLocation().equals(player.targetedEnemy.getLocation())) {
            System.out.println("You have gifted your " + selectedItem + " to " + player.targetedEnemy);
            player.targetedEnemy.inventory.addItem(selectedItem);
            removeItem(selectedItem);
        } else {
            System.out.println("You are not in the same location, how are you going to gift them anything?");
        }
    }
}


//        return;
//        System.out.println("########################");
//      player.movementPhaseOptions();
