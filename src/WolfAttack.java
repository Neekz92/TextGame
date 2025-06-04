public class WolfAttack extends Encounter {

    public WolfAttack() {

    }


    @Override
    public void setup() {

        int rng = random.nextInt(0, gameEngine.playerArray.length) + 2;
        System.out.println("You are surrounded by " + (rng) + " wolves");
//        for (int i = 0; i < rng; i++) {
//            System.out.println("Wolf " + (i+1) + " === 10 HP");
//        }
        for (int i = 0; i < rng; i++) {
            Enemy wolf;
            gameEngine.addPlayer(wolf = new Wolf(gameEngine.player.getX(), gameEngine.player.getY()));
            addPlayer(wolf);
            wolf.hasEncounter = true;
        }
    }
}
