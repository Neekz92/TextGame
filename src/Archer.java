public class Archer extends Player {

    Stunt selectedStunt;

    Stunt stunt = new Stunt();
    int amountOfStunts = 0;
    Stunt[] stuntList = new Stunt[amountOfStunts];
    Stunt[] allStunts = new Stunt[2];

    public Archer(GameEngine gameEngine, String name) {
        super(gameEngine, name);
        setHp(10);
        currentHp = getHp();
        attack = 5;
        defense = 5;

        weapon = new Bow();

        Stunt criticalShot = new CriticalShot();
        addStunt(criticalShot);
    }

    public void addStunt(Stunt stunt) {

        amountOfStunts ++;
        Stunt[] stuntListClone = new Stunt[amountOfStunts];
        for (int i = 0; i < stuntList.length; i++) {
            stuntListClone[i] = stuntList[i];
        }
        stuntListClone[amountOfStunts - 1] = stunt;
        stuntList = stuntListClone;
    }

    public Stunt stuntSelect() {

        int input = scanner.nextInt() - 1;  //  If the input is 1, that needs to correspond to the first position in the encounter.playerArray which is [0]. It's n - 1
        scanner.nextLine();

        return stuntList[input];
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
                System.out.println("NATURAL 20");
                if (input == rng) {
                    System.out.println("BULL'S EYE! " + this + " delivered a critical shot to " + targetedEnemy);
                    int damage = (random.nextInt(0, (finalAttack + 1)) + (finalAttack / 5) - (targetedEnemy.finalDefense / 5)) * 10;  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
                    if (damage >= 1) {
                        damage = 20;
                    }
                    damage *= 2;
                    targetedEnemy.setHp(targetedEnemy.currentHp -= damage);
                    System.out.println(targetedEnemy + " took " + damage + " damage!");
                    targetedEnemy.deathCheck();
                    selectAim = false;
                    return;
                }
                System.out.println("Damn! " + this + " couldn't land a critical shot, but still managed to strike the target!");
                int damage = random.nextInt(0, (finalAttack + 1)) + (finalAttack / 5) - (targetedEnemy.finalDefense / 5);
                if (damage <= 1) {
                    damage = 2;
                }
                targetedEnemy.setHp(targetedEnemy.currentHp -= damage);
                System.out.println(targetedEnemy + " took " + damage + " damage!");
                targetedEnemy.deathCheck();
                selectAim = false;
                return;
            }
            else if (roll + (finalAttack / 5) >= 10 + (targetedEnemy.defense / 5)) {
                if (input == rng) {
                    System.out.println("BULL'S EYE! " + this + " delivered a critical shot to " + targetedEnemy);
                    int damage = (random.nextInt(0, (finalAttack + 1)) + (finalAttack / 5) - (targetedEnemy.finalDefense / 5)) * 10;  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
                    if (damage <= 1) {
                        damage = 10;
                    }
                    targetedEnemy.setHp(targetedEnemy.currentHp -= damage);
                    System.out.println(targetedEnemy + " took " + damage + " damage!");
                    targetedEnemy.deathCheck();
                    selectAim = false;
                    return;
                }
                System.out.println("Damn! " + this + " couldn't land a critical shot, but still managed to strike the target!");
                int damage = random.nextInt(0, (finalAttack + 1)) + (finalAttack / 5) - (targetedEnemy.finalDefense / 5) ;
                if (damage <= 0) {
                    damage = 1;
                }
                targetedEnemy.setHp(targetedEnemy.currentHp -= damage);
                System.out.println(targetedEnemy + " took " + damage + " damage!");
                targetedEnemy.deathCheck();
                selectAim = false;
                }
            return;
        }
    }

    public void showStunts() {

        for (int i = 0; i < stuntList.length; i++) {
            System.out.println("[ " + (i + 1) + " ] " + stuntList[i].name);
        }

    }

    @Override
    public void combat() {

        updateStats();
        System.out.println("[ 1 ] Basic Attack");
        System.out.println("[ 2 ] Use a Stunt");
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
                        System.out.println("Select a Stunt");
                        showStunts();

                        if (stuntSelect().name.equals("Critical-Shot")) {
                            System.out.println("Select a Target");
                            stamina--;
                            showTargetOptions();
                            targetSelect();
                            criticalShot();
                            selectMove = false;
                            break;
                        }
                    }
                    else {
                        System.out.println("Not enough stamina.");
                        break;
                    }
                case 3:
                    run();
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
