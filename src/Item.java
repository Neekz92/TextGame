import java.util.Random;

public class Item {

    Random random = new Random();

    String name;
    String rarity;
    int price;
    int ID;

    String stat1;
    String stat2;
    String stat3;
    String[] statArray = new String[3];

    int mod1;
    int mod2;
    int mod3;

    public Item(String rarity) {

        this.rarity = rarity;
    }

    public Item() {

        this("Common");
    }

    public void assignStats() {  //  Previously, this logic was inside the constructor. But it was allowing duplicates of the same item to be dropped, so I'm trying it with a seperate method and calling it each time an item is distributed in Encounter.distributeRewards().

        for (int i = 0; i < statArray.length; i++) {
            int rngStat = random.nextInt(1,5);

            switch (rngStat) {
                case 1: statArray[i] = "Attack"; break;
                case 2: statArray[i] = "Defense"; break;
                case 3: statArray[i] = "Luck"; break;
                case 4: statArray[i] = "Max HP"; break;
                default: statArray[i] = "NO STAT"; break;
            }

            stat1 = statArray[0];
            stat2 = statArray[1];
            stat3 = statArray[2];
        }

        switch (rarity) {
            case "Common":
                mod1 = random.nextInt(1,11);
                mod2 = random.nextInt(1,11);
                mod3 = random.nextInt(1,11);
                break;
            case "Uncommon":
                mod1 = random.nextInt(5,21);
                mod2 = random.nextInt(5,21);
                mod3 = random.nextInt(5,21);
                break;
            case "Rare":
                mod1 = random.nextInt(10,31);
                mod2 = random.nextInt(10,31);
                mod3 = random.nextInt(10,31);
                break;
            case "Legendary":
                mod1 = random.nextInt(15,41);
                mod2 = random.nextInt(15,41);
                mod3 = random.nextInt(15,41);
        }
    }

    public Item copy() {
        return new Item(this.rarity);
    }

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