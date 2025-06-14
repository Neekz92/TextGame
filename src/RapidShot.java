public class RapidShot extends Stunt {

    public RapidShot() {

        name = "Rapid-Shot";
    }

    @Override
    public Item copy() {
        Item rapidShot = new RapidShot();
        rapidShot.name = "Rapid-Shot";
        rapidShot.rarity = "(Stunt)";
        return rapidShot;
    }
}
