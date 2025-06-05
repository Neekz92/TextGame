public class Enemy extends Player {

    public Enemy(GameEngine gameEngine) {

        super(gameEngine);
    }


    public void combat() {
        //System.out.println("DEBUG Enemy.java.combat()");
    }

    @Override
    public void encounterPhase() {
        //System.out.println("DEBUG Enemy.java.encounterPhase()");
    }

    @Override
    public void movementPhase() {
    }

    public Player[] findEnemies() {

        int amountOfEnemies = 0;
        for (int i = 0; i < encounter.playerArray.length; i++) {
            if (!(encounter.playerArray[i] instanceof Enemy)) {
                amountOfEnemies++;
                //System.out.println("DEBUG Enemy.java: " + amountOfEnemies);
            }
        }
        Player[] enemyArray = new Player[amountOfEnemies];
        int enemyIndex = 0;

        for (int i = 0; i < encounter.playerArray.length; i++) {
            if (!(encounter.playerArray[i] instanceof Enemy)) {
                enemyArray[enemyIndex] = encounter.playerArray[i];
                enemyIndex ++;
            }
        }
        return enemyArray;
    }
}
