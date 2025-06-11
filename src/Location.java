import java.util.Random;

public class Location {

    Shop shop = new Shop();

    GameEngine gameEngine;
    Random random;
    int x;
    int y;
    String description;
    Encounter encounter;
    Encounter[] encounterArray;
    int amountOfEncounters = 0;
    String name;

    boolean isTown = false;

    public Location(int x, int y) {

        random = new Random();
        this.x = x;
        this.y = y;
        encounterArray = new Encounter[amountOfEncounters];
    }

    @Override
    public String toString() {
        return name;
    }

    public Location() {
        this(0, 0);
    }


    public void add(Encounter encounter) {

        amountOfEncounters++;
        Encounter[] encounterArrayClone = new Encounter[amountOfEncounters];
        for (int i = 0; i < encounterArray.length; i++) {
            encounterArrayClone[i] = encounterArray[i];
        }
        encounterArrayClone[amountOfEncounters - 1] = encounter;
        encounterArray = encounterArrayClone;
    }


    public Encounter rollEncounter() {

        int rng = random.nextInt(0, encounterArray.length);
        encounter = encounterArray[rng];
        return encounter;
    }

    public void endEncounter() {

        if (encounter.areHostilesDead() && !encounter.arePlayersDead()) {  //  This runs when the players kill all the enemies in an encounter
            for (int i = 0; i < encounter.playerArray.length; i++) {
                encounter.playerArray[i].setEncounter(null);
                encounter.playerArray[i].hasEncounter = false;
                if (!encounter.distributedRewards) {  //  I was having an issue where every player involved was calling this reward distribution, so I made a boolean flag that only makes it trigger for the first player in the array.
                    encounter.distributeRewards();
                    encounter.distributedRewards = true;
                }
            }
            encounter.amountOfPlayers = 0;
            encounter.playerArray = new Player[encounter.amountOfPlayers];
            encounter = null;
            System.out.println("The battle is won!");
        } else if (!encounter.areHostilesDead() && encounter.arePlayersDead()) {
            System.out.println("The battle is lost!");
            for (int i = encounter.playerArray.length - 1; i >= 0; i--) {
                encounter.playerArray[i].gameEngine.removePlayer(encounter.playerArray[i]);  // Remove all entities from the gameEngine playerArray
                encounter.playerArray[i].setEncounter(null);  //  Set all entities in encounter playerArray to have encounter = null
                encounter.playerArray[i].hasEncounter = false;  //  Set all entities in encounter playerArray to have hasEncounter = false
                encounter.playerArray[i].isAlive = false;   //  Set all entities in encounter playerArray to have isAlive = false, it prevents them from taking turns. might not be needed but who knows?

                //System.out.println("DEBUG Location.endEncounter(): Removing " + encounter.playerArray[i]);
                encounter.removePlayer(encounter.playerArray[i]);  // Remove all entities from the encounter's playerArray
            }
            encounter = null;
        }
    }

    public void endSocialEncounter() {
        encounter.playerArray[0].setEncounter(null);
        encounter.playerArray[0].hasEncounter = false;
        encounter.amountOfPlayers = 0;
        encounter.playerArray = new Player[encounter.amountOfPlayers];
        encounter = null;
    }
}