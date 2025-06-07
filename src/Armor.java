public class Armor extends Item {

    public Armor() {

        name = "Armor";
        rarity = "Common";
        modifier = random.nextInt(1,6);
        price = random.nextInt(1, 11);
    }
}
