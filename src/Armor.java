public class Armor extends Item {

    public Armor() {

        super();
        name = "Armor";
    }

    public Armor(String rarity) {
        super(rarity);
    }

    @Override
    public Item copy() {
        Item armor = new Armor(this.rarity);
        armor.name = "Armor";
        return armor;
    }
}
