public class BanditAttack extends Encounter {

    Enemy bandit;
    public BanditAttack() {

    }

    @Override
    public void setup() {

        int rng = random.nextInt(0, gameEngine.playerArray.length) + 1;
        System.out.println("You are ambushed by " + (rng) + " bandits!");
        for (int i = 0; i < rng; i++) {
            gameEngine.addPlayer(bandit = new Bandit(gameEngine.player.getX(), gameEngine.player.getY()));
        }
    }
}
