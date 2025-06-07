public class Sword extends Item {

    public Sword() {
        super();
        name = "Sword";
    }

    public Sword(String rarity) {
        super(rarity);
    }

    @Override
    public Item copy() {
        Item sword = new Sword(this.rarity);
        sword.name = "Sword";
        return sword;
    }
}
