public class ChainLightning extends Spell {

    public ChainLightning() {
        super();
        name = "Chain-Lightning";
    }

    @Override
    public Item copy() {
        Item chainLightniing = new ChainLightning();
        chainLightniing.name = "Chain-Lightning";
        chainLightniing.rarity = "(Spell)";
        return chainLightniing;
    }
}
