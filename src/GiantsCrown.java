public class GiantsCrown extends Key {

    public GiantsCrown() {
        super();
        name = "Ancient Giant's Crown";
    }

    @Override
    public void description() {

        System.out.println("It's a very old crown, worn by the King of the Giants.");
        System.out.println("This item can only be used at [ Stormpeak Mountain Summit (0,5) ].");
    }

    @Override
    public Item copy() {
        Item giantsCrown = new GiantsCrown();
        giantsCrown.name = "Ancient Giant's Crown";
        giantsCrown.rarity = "(Key)";
        return giantsCrown;
    }
}
