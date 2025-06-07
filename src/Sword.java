public class Sword extends Item {

    Sword() {

        name = "Sword";
        rarity = 

    }

    @Override
    public String toString() {

        String returnMe = "";

        returnMe += rarity + " " + name + "\n";
        return  returnMe;
    }
}
