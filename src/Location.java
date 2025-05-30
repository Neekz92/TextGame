public class Location {

    int x;
    int y;
    boolean hasEncounter;
    Encounter encounter;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        hasEncounter = false;
        encounter = new Encounter();
        Map.size++;
    }
}