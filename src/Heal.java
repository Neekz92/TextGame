public class Heal extends Spell {

    public Heal() {
        super();
        name = "Heal";
    }

    @Override
    public Item copy() {
        Item heal = new Heal();
        heal.name = "Heal";
        heal.rarity = "(Spell)";
        return heal;
    }
}
