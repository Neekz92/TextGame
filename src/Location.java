import java.util.Random;

public class Location {

    int x;
    int y;
    boolean hasEncounter;
    Encounter encounter;
    int amountOfEncounters = 0;
    Encounter[] possibleEncounters = new Encounter[amountOfEncounters];
    Random random = new Random();

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        hasEncounter = false;
        encounter = new Encounter();
        Map.size++;

    }

    public Location() {
        this(0, 0);
    }


    public void add(Encounter encounter) {
        amountOfEncounters++;
        Encounter[] possibleEncountersClone = new Encounter[amountOfEncounters];
        for (int i = 0; i < possibleEncounters.length; i++) {
            possibleEncountersClone[i] = possibleEncounters[i];
        }
        possibleEncountersClone[amountOfEncounters - 1] = encounter;
        possibleEncounters = possibleEncountersClone;
        encounter.location = this;
    }


    public void rollEncounter() {

        int randomEncounter = random.nextInt(0, amountOfEncounters);
        System.out.println("Debug: From location.rollEncounter() = " + randomEncounter);
        encounter = possibleEncounters[randomEncounter];
        hasEncounter = true;
    }


    public String getEncounters() {
        String returnMe = "";
        for (int i = 0; i < possibleEncounters.length; i++) {
            returnMe += possibleEncounters[i].description;
        }
        return returnMe;
    }

    public void debugShowEncounters() {
        for (int i = 0; i < possibleEncounters.length; i++) {
            System.out.println(possibleEncounters[i]);
        }
    }
}