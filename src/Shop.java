public class Shop {

    int amountOfItems = 0;
    Item[] itemArray = new Item[amountOfItems];

    public Shop() {

    }


    public void fillShop() {

        amountOfItems = 0;
        Item[] itemArrayClone = new Item[amountOfItems];
        itemArray = itemArrayClone;

        Item potion = new Potion();
        addItem(potion);

        Item sword = new Sword();
        addItem(sword);

        Item staff = new Staff();
        addItem(staff);

        Item bow = new Bow();
        addItem(bow);

        Item armor = new Armor();
        addItem(armor);
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
