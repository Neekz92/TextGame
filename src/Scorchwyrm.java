public class Scorchwyrm extends Enemy {

    public Scorchwyrm(GameEngine gameEngine) {

        super(gameEngine);
        this.attack = 125;
        this.defense = 125;
        this.setHp(500);
        currentHp = getHp();

        setGold(5);
    }

    @Override
    public void combat() {

        for (int i = 0; i < gameEngine.cachedAmountOfPlayers; i++) {
            enemyAITargetArray = findEnemies();
            if (enemyAITargetArray.length > 0) {
                int rng = random.nextInt(0, enemyAITargetArray.length);
                targetedEnemy = enemyAITargetArray[rng];
                basicAttack();  //  For future enemies with more complex move lists, I might add basicAttack() to an array, along with its other moves like breathWeapon() etc, and then use rng to determine which one gets used.
            } else if (enemyAITargetArray.length == 1) {
                targetedEnemy = enemyAITargetArray[0];
                basicAttack();
            }
        }
    }

    @Override
    public void basicAttackDescription() {
        System.out.println("Scorchwyrm tries to slash " + targetedEnemy + " with its claws!");
    }


    @Override
    public void deathCheck() {

        Encounter cachedEncounter = encounter;

        if (currentHp <= 0) {
            isAlive = false;
            System.out.println(this + " has been slain!");

            for (int i = 0; i < gameEngine.playerArray.length; i++) {
                gameEngine.removePlayer(gameEngine.playerArray[i]);
            }
            gameEngine.removePlayer(this);

            getLocation().endEncounter();
            gameEngine.youWin();
        }
    }
}
