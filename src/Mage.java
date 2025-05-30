public class Mage extends Player{

    public Mage(String name) {
        super(name);
        setHp(8);
    }

    @Override
    public String toString() {
        return super.toString() + " the Mage";
    }
}
