import java.util.Random;

public abstract class Item {

    Random random = new Random();

    String name;
    String rarity;
    int price;
    int ID;

    String stat1;
    String stat2;
    String stat3;
    String[] statArray = new String[3];

    int modifier1;
    int modifier2;
    int modifier3;
    int[] modifierArray = new int[3];

    public Item(String rarity) {

        name = "";
        this.rarity = rarity;
        price = 0;

        statArray[0] = stat1;
        statArray[1] = stat2;
        statArray[2] = stat3;

        modifierArray[0] = modifier1;
        modifierArray[1] = modifier2;
        modifierArray[2] = modifier3;

        for (int i = 0; i < statArray.length; i++) {
            int rng = random.nextInt(1, 5);
            switch (rng) {
                case 1: statArray[i] = "Attack"; break;
                case 2: statArray[i] = "Defense"; break;
                case 3: statArray[i] = "Luck"; break;
                case 4: statArray[i] = "Max HP"; break;
            }
        }

        for (int i = 0; i < modifierArray.length; i++) {
            switch (rarity) {
                case "Common": modifierArray[i] = random.nextInt(1,11); break;
                case "Uncommon": modifierArray[i] = random.nextInt(5,21); break;
                case "Rare": modifierArray[i] = random.nextInt(10,31); break;
                case "Legendary": modifierArray[i] = random.nextInt(15, 41); break;
            }
        }
    }

    public Item() {}

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void useItem() {

    }

    @Override
    public String toString() {
        String returnMe = "";
        returnMe += rarity + " " + name;
        return returnMe;
    }
}