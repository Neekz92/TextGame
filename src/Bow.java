public class Bow extends Item {

    public Bow() {
        super();
        name = "Longbow";
    }

    public Bow(String rarity) {
        super(rarity);
        name = "Longbow";
    }

    @Override
    public Item copy() {
        Item bow = new Bow(this.rarity);
        bow.name = "Longbow";
        return bow;
    }
}
