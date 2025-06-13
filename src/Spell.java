public class Spell extends Item {

    String name;

    public Spell() {

        price = random.nextInt(1,11);
    }

    @Override
    public String displayItem() {
        return "Spell: " + name;
    }
}
