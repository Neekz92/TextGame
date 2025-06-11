public class Warrior extends Player {
    String shield = null;

    public Warrior(GameEngine gameEngine, String name) {
        super(gameEngine, name);
        setHp(15);
        currentHp = getHp();
        attack = 5;
        defense = 5;

        weapon = new Sword();
    }

    @Override
    public void combat() {

        System.out.println("[ 1 ] Basic Attack");
        System.out.println("[ 2 ] Shield Bash Combo");
        System.out.println("[ 3 ] Run Away");

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
                    break;
                case 2:
                    if (stamina >= 1) {
                        System.out.println("Shield Bash Combo");
                        showTargetOptions();
                        shieldBash();
                        stamina --;
                        selectMove = false;
                        break;
                    }
                    else {
                        System.out.println("Not enough stamina.");
                        break;
                    }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " the Warrior";
    }


    @Override
    public void basicAttackDescription() {
        System.out.println(this + " swings their sword at " + targetSelect());
    }


    public void shieldBash() {

        updateStats();

        Player[] shieldBashTargets = new Player[2];
        Player shieldBashTarget1 = null;
        Player shieldBashTarget2 = null;

        System.out.println("Select first target");
        shieldBashTarget1 = targetSelect();


        if (encounter.countAmountOfEnemies() == 1) { //  Only need 1 target if there is only 1 enemy present
            System.out.println(name + " tries to bash " + shieldBashTarget1.getName());
            if (rollAttack() > 10) {
                shieldBashTarget1.isStunned = true;
                return;
            }
        }

        else {  //  Encounter has more than 1 enemy
            System.out.println("Select second target");
            boolean mustChooseADifferentTarget = true;
            while (mustChooseADifferentTarget) {
                shieldBashTarget2 = targetSelect();

                int roll = rollAttack();

                if (shieldBashTarget1.equals(shieldBashTarget2)) {
                    System.out.println("Must choose a different target.");

                }
                else {
                    System.out.println(name + " tries to bash " + shieldBashTarget1.getName() + " and " + shieldBashTarget2.getName());
                    targetedEnemy = shieldBashTarget1;
                    if (roll + (finalAttack / 5) >= 10 + (shieldBashTarget1.finalDefense / 5)) {
                        shieldBashTarget1.isStunned = true;
                        System.out.println(shieldBashTarget1 + " is dazed from the shield bash!");
                    }

                    roll = rollAttack();
                    targetedEnemy = shieldBashTarget2;
                    if (roll + (finalAttack / 5)  >= 10 + (shieldBashTarget2.finalDefense / 5)) {
                        shieldBashTarget2.isStunned = true;
                        System.out.println(shieldBashTarget2 + " is dazed from the shield bash!");
                    }
                    mustChooseADifferentTarget = false;
                }
            }
        }
    }
}
