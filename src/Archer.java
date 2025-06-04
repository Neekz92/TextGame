public class Archer extends Player {

    public Archer(String name) {
        super(name);
        setHp(10);
    }

    @Override
    public void combat() {

        System.out.println("[ 1 ] Basic Attack");
        System.out.println("[ 2 ] Critical Shot");
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
                    basicAttack();
                    selectMove = false;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " the Archer";
    }



    public void basicAttackDescription() {
        System.out.println(this + " quickly looses an arrow toward " + targetSelect() + "!");
    }
}
