public class Orc extends Enemy {

    public Orc(GameEngine gameEngine) {

        super(gameEngine);
        this.attack = 45;
        this.defense = 35;
        this.setHp(55);
        currentHp = getHp();
    }

    @Override
    public void combat() {

        if (findEnemies().length > 1) {
            int rng = random.nextInt(0, findEnemies().length);
            targetedEnemy = findEnemies()[rng];
            Player firstTarget = targetedEnemy;

            int orcChoice = random.nextInt(1,5);
            if (orcChoice == 1) {
                shieldBash();
                rng = random.nextInt(0, findEnemies().length);

                for (int i = 0; i < encounter.amountOfPlayers; i++) {  //  This loop goes through all the encounter's players,
                    if (!(encounter.playerArray[i] instanceof Enemy)) {  //  Ignores all instances of Enemies
                        if (!firstTarget.equals(encounter.playerArray[i])) {  //  Ignores the previously selected target
                            targetedEnemy = encounter.playerArray[i];
                            break;
                        }
                    }
                }
                shieldBash();
            }
            else {
                basicAttack();
            }
        }


        else if (findEnemies().length == 1){
            targetedEnemy = findEnemies()[0];
            int rng = random.nextInt(0, findEnemies().length);
            targetedEnemy = findEnemies()[rng];

            int orcChoice = random.nextInt(1,5);
            if (orcChoice == 1) {
                shieldBash();
                shieldBash();
            }
            else {
                basicAttack();
            }

        }
    }

    public void shieldBash() {

        updateStats();
        System.out.println("In a frenzy, the orc charges forward with his shield!");
        if (rollAttack() + (finalAttack / 5) > 10 + (targetedEnemy.finalDefense / 5)) {
            System.out.println(targetedEnemy + " was bashed in the head by the orc!");
            System.out.println(targetedEnemy + " is dazed!");
            targetedEnemy.isStunned = true;
            return;
        }
    }

    @Override
    public void basicAttackDescription() {
        System.out.println("The orc tries to cleave " + targetedEnemy + "with its axe!");
    }
}