public class EnchantedIcePick extends Key {

    public EnchantedIcePick() {

        super();
        name = "Enchanted Ice-Pick";
    }

    @Override
    public void description() {

        System.out.println("It's an old ice-pick, though the steel is unrusted. Perhaps it contains a magical essence about it.");
        System.out.println("This item can only be used at [ Shiverpeak Mountain Summit (5,10) ].");
    }

    @Override
    public Item copy() {
        Item enchantedIcePick = new EnchantedIcePick();
        enchantedIcePick.name = "Enchanted Ice-Pick";
        enchantedIcePick.rarity = "(Key)";
        return enchantedIcePick;
    }
}
