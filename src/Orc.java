public class Orc extends Enemy {

    public Orc(GameEngine gameEngine) {

        super(gameEngine);
        this.attack = 30;
        this.defense = 20;
        this.setHp(25);
        currentHp = getHp();
    }

    @Override
    public void combat() {

        enemyAITargetArray = findEnemies();

        if (enemyAITargetArray.length > 1) {
            int rng = random.nextInt(0, enemyAITargetArray.length);
            targetedEnemy = enemyAITargetArray[rng];
            Player firstTarget = targetedEnemy;

            int orcChoice = random.nextInt(1,8);
            if (orcChoice == 1) {
                shieldBash();
                rng = random.nextInt(0, enemyAITargetArray.length);

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


        else if (enemyAITargetArray.length == 1){
            targetedEnemy = enemyAITargetArray[0];
            int rng = random.nextInt(0, enemyAITargetArray.length);
            targetedEnemy = enemyAITargetArray[rng];

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
            System.out.println("");
            targetedEnemy.stunTimer = 1;
            targetedEnemy.isStunned = true;
            return;
        }
    }

    @Override
    public void basicAttackDescription() {
        System.out.println("The orc tries to cleave " + targetedEnemy + " with its axe!");
    }
}