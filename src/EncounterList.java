public class EncounterList {

    int amountOfEncounters;
    Encounter[] encounterArray;

    public EncounterList() {
        amountOfEncounters = 0;
        encounterArray = new Encounter[amountOfEncounters];
    }

    public void addEncounter(Encounter encounter) {
        amountOfEncounters++;
        Encounter[] cloneEncounterArray = new Encounter[amountOfEncounters];
        for (int i = 0; i < encounterArray.length; i++) {
            cloneEncounterArray[i] = encounterArray[i];
        }
        cloneEncounterArray[amountOfEncounters - 1] = encounter;
        encounterArray = cloneEncounterArray;
    }
}
