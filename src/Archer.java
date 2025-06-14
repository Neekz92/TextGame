public class Archer extends Player {

    Stunt selectedStunt;

    Stunt stunt = new Stunt();
    int amountOfStunts = 0;
    Stunt[] stuntList = new Stunt[amountOfStunts];
    Stunt[] allStunts = new Stunt[2];

    public Archer(GameEngine gameEngine, String name) {
        super(gameEngine, name);
        setHp(100);
        currentHp = getHp();
        attack = 5;
        defense = 5;
        luck = 0;

        weapon = new Bow();

        Stunt criticalShot = new CriticalShot();
        Stunt rapidShot = new RapidShot();
        allStunts[0] = criticalShot;
        allStunts[1] = rapidShot;

        addStunt(allStunts[random.nextInt(0,2)]);
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

        if (input == -1) {
            return null;
        }

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
                    int damage = (random.nextInt(1, (finalAttack / 5) + 5) - (targetedEnemy.finalDefense / 5)) * 5;  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
                    if (damage >= 1) {
                        damage = 5;
                    }
                    damage *= 2;
                    targetedEnemy.setHp(targetedEnemy.currentHp -= damage);
                    System.out.println(targetedEnemy + " took " + damage + " damage!");
                    targetedEnemy.deathCheck();
                    selectAim = false;
                    return;
                }
                System.out.println("Damn! " + this + " couldn't land a critical shot, but still managed to strike the target!");
                int damage = random.nextInt(1, (finalAttack / 5) + 5) - (targetedEnemy.finalDefense / 5);
                if (damage <= 1) {
                    damage = 2;
                }
                targetedEnemy.setHp(targetedEnemy.currentHp -= damage);
                System.out.println(targetedEnemy + " took " + damage + " damage!");
                targetedEnemy.deathCheck();
                selectAim = false;
                return;
            }
            else if (roll + (finalAttack / 5) > 10 + (targetedEnemy.defense / 5)) {
                if (input == rng) {
                    System.out.println("BULL'S EYE! " + this + " delivered a critical shot to " + targetedEnemy);
                    int damage = (random.nextInt(1, (finalAttack / 5) + 5) - (targetedEnemy.finalDefense / 5)) * 5;  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
                    if (damage <= 1) {
                        damage = 5;
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
        System.out.println("[ 0 ] Exit]");
    }

    public void combatOptions() {

        System.out.println("[ 1 ] Basic Attack");
        System.out.println("[ 2 ] Use a Stunt");
        System.out.println("[ 3 ] Run Away");
    }

    @Override
    public void combat() {

        updateStats();
        combatOptions();

        boolean selectMove = true;
        while (selectMove) {

            int input = scanner.nextInt();
            scanner.nextLine();

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
                        selectedStunt = stuntSelect();

                        if (selectedStunt == null) {
                            combatOptions();
                            continue;
                        }

                        if (selectedStunt.name.equals("Critical-Shot")) {
                            System.out.println("Select a Target");
                            stamina--;
                            showTargetOptions();
                            targetSelect();
                            criticalShot();
                            selectMove = false;
                            break;
                        }
                        else if (selectedStunt.name.equals("Rapid-Shot")) {
                            rapidShot();
                            selectMove = false;
                            break;
                        }

                        // Add more stunts
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

    public void rapidShot() {

        System.out.println(this + " is in the zone!");
        stamina--;
        boolean rapidShotLoop = true;
        int shotCount = 4;
        System.out.println(this + " begins unleashing a barrage of arrows");
        while (rapidShotLoop) {

            if (encounter == null) {
                rapidShotLoop = false;
                return;
            }


            System.out.println("Select a Target");
            showTargetOptions();
            basicAttack();
            shotCount --;

            int roll = rollLuck();
            if (roll + (finalLuck / 5) < 10 || shotCount <= 0) {
                System.out.println(this + " stopped to catch their breath.");
                System.out.println("The Rapid-Shot sequence has ended.");
                rapidShotLoop = false;
                break;
            }
            System.out.println(this + " continues the Rapid-Shot combo!");
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
