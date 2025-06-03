public class BanditAttack extends Encounter {

    Player bandit = new Bandit();
    public BanditAttack() {

    }

    @Override
    public void setup() {

        int rng = random.nextInt(0, gameEngine.playerArray.length) + 5;
        System.out.println("You are ambushed by " + (rng) + " bandits!");
        for (int i = 0; i < rng; i++) {
            gameEngine.addPlayer(bandit);
        }
    }
}
