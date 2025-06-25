public class CursedFragment extends Key {

    public CursedFragment() {

        super();
        name = "Cursed Mural Fragment";
    }

    @Override
    public void description() {

        System.out.println("It's a stone slab decorated with a painting depicting an armored skeletal figure with green embers burning from its eye sockets.");
        System.out.println("This item can only be used at [ Cavern of Cadavers (5,5) ].");
    }

    @Override
    public Item copy() {
        Item cursedFragment = new CursedFragment();
        cursedFragment.name = "Cursed Mural Fragment";
        cursedFragment.rarity = "(Key)";
        return cursedFragment;
    }
}
