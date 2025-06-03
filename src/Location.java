import java.util.Random;

public class Location {

    GameEngine gameEngine;
    Random random;
    int x;
    int y;
    String description;
    Encounter encounter;
    Encounter[] encounterArray;
    int amountOfEncounters = 0;


    public Location(int x, int y) {

        random = new Random();
        this.x = x;
        this.y = y;
        encounterArray = new Encounter[amountOfEncounters];

    }

    public Location() {
        this(0, 0);
    }


    public void add(Encounter encounter) {

        amountOfEncounters ++;
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

}