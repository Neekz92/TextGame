public class Mage extends Player {

    public Mage(String name, GameEngine gameEngine) {
        super(name, gameEngine);
        setHp(1);
    }

    @Override
    public void combat() {

        System.out.println("[ 1 ] Basic Attack");
        System.out.println("[ 2 ] Cast a Spell");
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
        return super.toString() + " the Mage";
    }



    public void basicAttackDescription() {
        System.out.println(this + " launches a bolt of magic at " + targetSelect());
    }
}
