public class AncientDrumstick extends Key {

    public AncientDrumstick() {

        super();
        name = "Ancient Drumstick";
    }

    @Override
    public void description() {

        System.out.println("It's a very large, old stick with a club at the end. Perhaps part of a colossal insturment.");
        System.out.println("This item can only be used at [ Sandworm Feeding Grounds (10,5) ].");
    }

    @Override
    public Item copy() {
        Item ancientDrumstick = new AncientDrumstick();
        ancientDrumstick.name = "Ancient Drumstick";
        ancientDrumstick.rarity = "(Key)";
        return ancientDrumstick;
    }
}
