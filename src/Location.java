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
    String name;


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



    public void endEncounter() {
        if (encounter.areHostilesDead() && !encounter.arePlayersDead()) {  //  This runs when the players kill all the enemies in an encounter
            for (int i = 0; i < encounter.playerArray.length; i++) {
                encounter.playerArray[i].setEncounter(null);
                encounter.playerArray[i].hasEncounter = false;
            }
            encounter.amountOfPlayers = 0;
            encounter.playerArray = new Player[encounter.amountOfPlayers];
            encounter = null;
            System.out.println("The battle is won!");
        }

         else if (!encounter.areHostilesDead() && encounter.arePlayersDead()) {
            System.out.println("The battle is lost!");
            for (int i = 0; i < encounter.playerArray.length; i++) {
                encounter.playerArray[i].gameEngine.removePlayer(encounter.playerArray[i]);
                encounter.playerArray[i].setEncounter(null);
                encounter.playerArray[i].hasEncounter = false;
                encounter.playerArray[i].isAlive = false;
            }
        }
    }
}