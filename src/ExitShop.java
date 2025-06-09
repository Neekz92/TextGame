public class ExitShop extends Item {


    public ExitShop() {

        setName("Exit Shop");
        ID = 0;
    }

    @Override
    public String toString() {
        return "Exit shop ~~~***~~~ Type [ " + ID + " ] to exit";
    }
}
