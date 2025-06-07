public class Sword extends Item {

    Sword() {
        super();
        name = "Sword";
    }

    Sword(String rarity) {
        super(rarity);
    }

    @Override
    public Item copy() {
        Item sword = new Sword(this.rarity);
        sword.name = "Sword";
        return sword;
    }
}
