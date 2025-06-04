public class Warrior extends Player {

    public Warrior(String name) {
        super(name);
        setHp(15);
    }

    @Override
    public void combat() {

        System.out.println("[ 1 ] Basic Attack");
        System.out.println("[ 2 ] Taunt");
        System.out.println("[ 3 ] Inventory");
        System.out.println("[ 4 ] Run Away");

        int input = scanner.nextInt();
        scanner.nextLine();

        boolean selectMove = true;
        while (selectMove) {
            switch (input) {
                case 1:
                    System.out.println("Select a Target");
                    showTargetOptions();
                    System.out.println(this + " swings their sword at " + targetSelect());
                    selectMove = false;
            }












        }
    }

    @Override
    public String toString() {
        return super.toString() + " the Warrior";
    }
}
