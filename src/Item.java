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

    int attack;
    int defense;
    int luck;
    int hp;
    int[] statOptions = new int[4];

    public Item(String rarity) {

        this.rarity = rarity;
    }

    public Item() {

        this("Common");
    }



    public void assignStats2() {

        statOptions[0] = attack;
        statOptions[1] = defense;
        statOptions[2] = luck;
        statOptions[3] = hp;

        for (int i = 0; i < 3; i++) {
            int rngStat = random.nextInt(0,4);
            switch (rngStat) {
                case 0:
                    if (rarity.equals("Common")) {
                        attack += random.nextInt(1, 11);
                    }
                    else if (rarity.equals("Uncommon")) {
                        attack += random.nextInt(5,21);
                    }
                    else if (rarity.equals("Rare")) {
                        attack += random.nextInt(10,31);
                    }
                    else if (rarity.equals("Legendary")) {
                        attack += random.nextInt(15,41);
                    }
                    break;
                case 1:
                    if (rarity.equals("Common")) {
                        defense += random.nextInt(1, 11);
                    }
                    else if (rarity.equals("Uncommon")) {
                        defense += random.nextInt(5,21);
                    }
                    else if (rarity.equals("Rare")) {
                        defense += random.nextInt(10,31);
                    }
                    else if (rarity.equals("Legendary")) {
                        defense += random.nextInt(15,41);
                    }
                    break;
                case 2:
                    if (rarity.equals("Common")) {
                        luck += random.nextInt(1, 11);
                    }
                    else if (rarity.equals("Uncommon")) {
                        luck += random.nextInt(5,21);
                    }
                    else if (rarity.equals("Rare")) {
                        luck += random.nextInt(10,31);
                    }
                    else if (rarity.equals("Legendary")) {
                        luck += random.nextInt(15,41);
                    }
                    break;
                case 3:
                    if (rarity.equals("Common")) {
                        hp += random.nextInt(1, 11);
                    }
                    else if (rarity.equals("Uncommon")) {
                        hp += random.nextInt(5,21);
                    }
                    else if (rarity.equals("Rare")) {
                        hp += random.nextInt(10,31);
                    }
                    else if (rarity.equals("Legendary")) {
                        hp += random.nextInt(15,41);
                    }
                    break;
            }
        }
    }

    public void assignStats() {  //  Previously, this logic was inside the constructor. But it was allowing duplicates of the same item to be dropped, so I'm trying it with a seperate method and calling it each time an item is distributed in Encounter.distributeRewards().

        for (int i = 0; i < statArray.length; i++) {
            int rngStat = random.nextInt(1, 5);

            switch (rngStat) {
                case 1:
                    statArray[i] = "Attack";
                    break;
                case 2:
                    statArray[i] = "Defense";
                    break;
                case 3:
                    statArray[i] = "Luck";
                    break;
                case 4:
                    statArray[i] = "Max HP";
                    break;
                default:
                    statArray[i] = "NO STAT";
                    break;
            }

            stat1 = statArray[0];
            stat2 = statArray[1];
            stat3 = statArray[2];
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