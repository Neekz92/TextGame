public class Archer extends Player{

    public Archer(String name) {
        super(name);
        setHp(10);
    }

    @Override
    public String toString() {
        return super.toString() + " the Archer";
    }
}
