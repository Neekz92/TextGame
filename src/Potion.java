public class Potion extends Item {

    public Potion() {

        super();
        name = "Potion";
    }

    public Potion(String rarity) {
        super(rarity);
        name = "Potion";
    }

    @Override
    public Item copy() {
        Item potion = new Potion(this.rarity);
        potion.name = "Potion";
        return potion;
    }

    public String displayItem() {
        return rarity + " " + name;
    }
}
