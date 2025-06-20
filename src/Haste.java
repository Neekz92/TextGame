public class Haste extends Spell {

    public Haste() {

        super();
        name = "Haste";
    }

    @Override
    public Item copy() {
        Item haste = new Haste();
        haste.name = "Haste";
        haste.rarity = "(Spell)";
        return haste;
    }
}
