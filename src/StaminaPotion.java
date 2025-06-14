public class StaminaPotion extends Potion {

    int staminaAmount;

    public StaminaPotion(String rarity) {

        super(rarity);
        name = "Stamina Potion";
        staminaAmount = random.nextInt(1,4);
    }

    public StaminaPotion() {

        this("Common");
    }

    @Override
    public Item copy() {
        Item potion = new StaminaPotion(this.rarity);
        potion.name = "Stamina Potion";
        return potion;
    }

    public String displayItem() {
        return rarity + " " + name;
    }
}