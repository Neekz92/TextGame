public class Skill extends Item {

    public Skill() {

        price = random.nextInt(1,11);
    }

    @Override
    public String displayItem() {
        return "(Skill) " + name;
    }
}
