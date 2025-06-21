import java.util.Random;

public class Shop {

    int amountOfItems = 0;
    Item[] itemArray = new Item[amountOfItems];
    Random random;

    public Shop() {

        random = new Random();
    }


    public void fillShop() {

        amountOfItems = 0;
        Item[] itemArrayClone = new Item[amountOfItems];
        itemArray = itemArrayClone;


        for (int i = 0; i < 7; i++) {
            int rng = random.nextInt(1,16);
            switch (rng) {
                case 1: addItem(new Potion()); break;
                case 2: addItem(new Potion("Uncommon")); break;
                case 3: addItem(new Sword()); break;
                case 4: addItem(new Sword("Uncommon")); break;
                case 5: addItem(new Staff()); break;
                case 6: addItem(new Staff("Uncommon")); break;
                case 7: addItem(new Bow()); break;
                case 8: addItem(new Bow("Uncommon")); break;
                case 9: addItem(new Armor()); break;
                case 10: addItem(new Armor("Uncommon")); break;

                case 11:addItem(new Potion()); break;
                case 12:addItem(new Sword()); break;
                case 13:addItem(new Staff()); break;
                case 14:addItem(new Bow()); break;
                case 15:addItem(new Armor()); break;
            }
        }
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

    public int findItemIndex(Item item) {

        for (int i = 0; i < itemArray.length; i++) {
            if (itemArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public void removeItem(Item item) {

        int index = findItemIndex(item);

        amountOfItems --;
        Item[] itemArrayClone = new Item[amountOfItems];
        for (int i = 0; i < index; i++) {
            itemArrayClone[i] = itemArray[i];
        }

        for (int i = index; i < itemArrayClone.length; i++) {
            itemArrayClone[i] = itemArray[i + 1];
        }

        itemArray = itemArrayClone;
    }
}
