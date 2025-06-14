public class Stunt extends Item {

    public Stunt() {

        price = random.nextInt(1,11);
    }

    @Override
    public String displayItem() {
        return "(Stunt) " + name;
    }
}
