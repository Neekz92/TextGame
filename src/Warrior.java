public class Warrior extends Player {

    public Warrior(String name) {
        super(name);
        setHp(15);
    }

    @Override
    public void combat() {

        System.out.println(name + " swings his sword!");
    }

    @Override
    public String toString() {
        return super.toString() + " the Warrior";
    }
}
