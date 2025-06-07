public class Potion extends Item {

    public Potion(String rarity) {

        setName("Potion");
        this.rarity = rarity;
        setPrice(8);
        ID = 1;
    }
}
