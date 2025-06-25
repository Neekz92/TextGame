import java.util.Random;

public class Item {

    Random random = new Random();

    String name;
    String rarity;
    int price;

    String stat1;
    String stat2;
    String stat3;
    String[] statArray = new String[3];

    int attack;
    int defense;
    int luck;
    int hp;
    int[] statOptions = new int[4];

    int healAmount;

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

        switch (rarity) {
            case "Common":
                healAmount = random.nextInt(5, 11);
                break;
            case "Uncommon":
                healAmount = random.nextInt(10, 21);
                break;
            case "Rare":
                healAmount = random.nextInt(15, 31);
                break;
            case "Legendary":
                healAmount = 9999999;
                break;
        }


        switch (rarity) {
            case "Common":
                price = random.nextInt(1, 11);
                break;
            case "Uncommon":
                price = random.nextInt(20, 41);
                break;
            case "Rare":
                price = random.nextInt(40, 61);
                break;
            case "Legendary":
                price = random.nextInt(60, 81);
                break;
        }

        for (int i = 0; i < 3; i++) {
            int rngStat = random.nextInt(0, 4);
            switch (rngStat) {
                case 0:
                    if (rarity.equals("Common")) {
                        attack += random.nextInt(1, 11);
                    } else if (rarity.equals("Uncommon")) {
                        attack += random.nextInt(5, 21);
                    } else if (rarity.equals("Rare")) {
                        attack += random.nextInt(10, 31);
                    } else if (rarity.equals("Legendary")) {
                        attack += random.nextInt(15, 41);
                    }
                    break;
                case 1:
                    if (rarity.equals("Common")) {
                        defense += random.nextInt(1, 11);
                    } else if (rarity.equals("Uncommon")) {
                        defense += random.nextInt(5, 21);
                    } else if (rarity.equals("Rare")) {
                        defense += random.nextInt(10, 31);
                    } else if (rarity.equals("Legendary")) {
                        defense += random.nextInt(15, 41);
                    }
                    break;
                case 2:
                    if (rarity.equals("Common")) {
                        luck += random.nextInt(1, 11);
                    } else if (rarity.equals("Uncommon")) {
                        luck += random.nextInt(5, 21);
                    } else if (rarity.equals("Rare")) {
                        luck += random.nextInt(10, 31);
                    } else if (rarity.equals("Legendary")) {
                        luck += random.nextInt(15, 41);
                    }
                    break;
                case 3:
                    if (rarity.equals("Common")) {
                        hp += random.nextInt(1, 11);
                    } else if (rarity.equals("Uncommon")) {
                        hp += random.nextInt(5, 21);
                    } else if (rarity.equals("Rare")) {
                        hp += random.nextInt(10, 31);
                    } else if (rarity.equals("Legendary")) {
                        hp += random.nextInt(15, 41);
                    }
                    break;
            }
        }

    }

    public void description() {}

    public Item copy() {
        return new Item(this.rarity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String returnMe = "";
        returnMe += rarity + " " + name;
        return returnMe;
    }

    public String displayItem() {

        return this + " === " + "Attack: " + attack + " | Defense: " + defense + " | " + "Luck: " + luck + " | " + "HP: " + hp;
    }
}