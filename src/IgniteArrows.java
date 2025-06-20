public class IgniteArrows extends Stunt {

    public IgniteArrows() {

        name = "Ignite Arrows";
    }

    @Override
    public Item copy() {
        Item igniteArrows = new IgniteArrows();
        igniteArrows.name = "Ignite Arrows";
        igniteArrows.rarity = "(Stunt)";
        return igniteArrows;
    }
}
