public class Sword extends Item {

    Sword(String rarity) {

        super(rarity);
        name = "Sword";
    }

    @Override
    public String toString() {

        String returnMe = "";

        returnMe += rarity + " " + name + "\n";
        return  returnMe;
    }
}
