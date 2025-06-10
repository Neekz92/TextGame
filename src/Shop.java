public class Shop {

    Item potion = new Potion();

    Item sword = new Sword();
    Item staff = new Staff();
    Item bow = new Bow();

    Item armor = new Armor();

    int amountOfItems = 0;
    Item[] itemArray = new Item[amountOfItems];

    public Shop() {

    }

    public void addItem(Item item) {

        amountOfItems ++;
        Item[] itemArrayClone = new Item[amountOfItems];
        for (int i = 0; i < itemArray.length; i++) {
            itemArrayClone[i] = itemArray[i];
        }
        itemArrayClone[amountOfItems - 1] = item;
    }


}
