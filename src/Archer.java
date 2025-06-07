public class Archer extends Player {

    String bow;
    String quiver;
    public Archer(GameEngine gameEngine, String name) {
        super(gameEngine, name);
        setHp(10);
        currentHp = getHp();
        attack = 5;
        defense = 5;
    }



    public void criticalShot() {

        System.out.println("Steady your aim.");
        System.out.println("[ 1 ] Aim high");
        System.out.println("[ 2 ] Aim center");
        System.out.println("[ 3 ] Aim low");

        int input = scanner.nextInt();
        scanner.nextLine();

        boolean selectAim = true;
        int rng = random.nextInt(1,4);

        while (selectAim) {

            int roll = rollAttack();

            if (roll == 20) {
                if (input == rng) {
                    System.out.println("NATURAL 20");
                    System.out.println("BULL'S EYE! " + this + " delivered a critical shot to " + targetedEnemy);
                    int damage = (random.nextInt(1, attack + 1) + (attack / 5) - (targetedEnemy.defense / 5) * 5);  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
                    damage *= 2;
                    targetedEnemy.setHp(targetedEnemy.currentHp -= damage);
                    System.out.println(targetedEnemy + " took " + damage + " damage!");
                    targetedEnemy.deathCheck();
                    selectAim = false;
                    return;
                }
                System.out.println("Damn! " + this + " couldn't land a critical shot, but still managed to strike the target!");
                int damage = random.nextInt(1, attack + 1) + (attack / 5) - (targetedEnemy.defense / 5);
                targetedEnemy.setHp(targetedEnemy.currentHp -= damage);
                System.out.println(targetedEnemy + " took " + damage + " damage!");
                targetedEnemy.deathCheck();
                selectAim = false;
                return;
            }





            else if (roll + (attack / 20) >= 10 + (targetedEnemy.defense / 20)) {
                if (input == rng) {
                    System.out.println("BULL'S EYE! " + this + " delivered a critical shot to " + targetedEnemy);
                    int damage = ((random.nextInt(1, attack + 1) + (attack / 5) - (targetedEnemy.defense / 5))) * 5;  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
                    targetedEnemy.setHp(targetedEnemy.currentHp -= damage);
                    System.out.println(targetedEnemy + " took " + damage + " damage!");
                    targetedEnemy.deathCheck();
                    selectAim = false;
                    return;
                }
                System.out.println("Damn! " + this + " couldn't land a critical shot, but still managed to strike the target!");
                int damage = random.nextInt(1, attack + 1) + (attack / 4) ;
                targetedEnemy.setHp(targetedEnemy.currentHp -= damage);
                System.out.println(targetedEnemy + " took " + damage + " damage!");
                targetedEnemy.deathCheck();
                selectAim = false;
                }
            return;
        }
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
                    break;
                case 2:
                    System.out.println("Select a Target");
                    showTargetOptions();
                    targetSelect();
                    criticalShot();
                    selectMove = false;
                    break;
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
