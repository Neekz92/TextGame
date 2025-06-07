import java.util.Random;

public abstract class Item {

    Random random = new Random();

    String name;
    String rarity;
    String[] modifierOptions = new String[4];
    int modifier;
    int price;
    int ID;

    public Item() {

        name = "";
        price = 0;
        modifierOptions[0] = "Common";
        modifierOptions[1] = "Uncommon";
        modifierOptions[2] = "Rare";
        modifierOptions[3] = "Legendary";
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
        returnMe += name;
        return returnMe;
    }
}