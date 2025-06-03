public class Enemy extends Player {

    public Enemy(int x, int y) {

        setX(x);
        setY(y);
    }

    public void combat() {

    }

    @Override
    public void encounterPhase() {
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



        for (int i = 0; i < enemyArray.length; i++) {
            //System.out.println("DEBUG Enemy.java: " + enemyArray[i]);
        }
        return enemyArray;
    }
}
