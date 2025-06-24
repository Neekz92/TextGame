public class DragonAttack extends CombatEncounter {

    GameEngine gameEngine;
    static int amountOfDragons = 0;

    public DragonAttack(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        description = "DragonAttack encounter";
    }

    @Override
    public void setup() {

        if (amountOfDragons == 0) {

            System.out.println("");
            System.out.println("**********");
            System.out.println("**********");
            System.out.println("**********");
            System.out.println("The heavens themselves part, as a gigantic beast descends from the sky. Scorchwyrm, the Realm's Destroyer reveals itself at " + gameEngine.player.getLocation());
            System.out.println("The Mighty Dragon unleashes a pillar of flame into the sky from his maw. He roars so fiercly, your bones quake beneath your flesh.");
            System.out.println("**********");
            System.out.println("**********");
            System.out.println("**********");
            System.out.println("");

            amountOfMobs++;
            Scorchwyrm dragon = gameEngine.dragon;
            gameEngine.addPlayer(dragon);
            dragon.setName("Scorchwyrm, Destroyer of Realms" + " (" + gameEngine.player.getLocation() + ")");
            addPlayer(dragon);
            amountOfDragons++;
            dragon.setLocation(gameEngine.player.getLocation());
            dragon.getLocation().encounter = this;
            dragon.setX(gameEngine.player.getX()); //  REMEMBER: just because I assign a LOCATION, doesn't mean i assign X,Y coordinates!
            dragon.setY(gameEngine.player.getY());
        }
    }
}