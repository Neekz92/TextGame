public class Warrior extends Player {

    public Warrior(String name) {
        super(name);
        setHp(15);
    }

    @Override
    public String toString() {
        return super.toString() + " the Warrior";
    }
}
