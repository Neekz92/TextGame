public class IrredescentFlower extends Key {

    public IrredescentFlower() {

        super();
        name = "Iridescent Flower";
    }

    @Override
    public void description() {

        System.out.println("It's a flower with a rainbow, glowing aura radiating from it. You've heard myths of this flower bringing entire forests to life.");
        System.out.println("This item can only be used at [ Temple of Leaves (5,0) ].");
    }

    @Override
    public Item copy() {
        Item irredescentFlower = new IrredescentFlower();
        irredescentFlower.name = "Iridescent Flower";
        irredescentFlower.rarity = "(Key)";
        return irredescentFlower;
    }
}
