public class Mage extends Player {

    public Mage(String name) {
        super(name);
        setHp(8);
    }

    @Override
    public void combat() {

        System.out.println("[ 1 ] Basic Attack");
        System.out.println("[ 2 ] Cast a Spell");
        System.out.println("[ 3 ] Inventory");
        System.out.println("[ 4 ] Run Away");
    }
    @Override
    public String toString() {
        return super.toString() + " the Mage";
    }
}
