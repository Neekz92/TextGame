public class Map {

    Location location00;
    Location[] locationArray;
    static int size = 0;

    public Map() {
        location00 = new Location(0, 0);
        locationArray = new Location[20];
        locationArray[0] = location00;
    }

    public Location findLocation(int x, int y) {
        for (int i = 0; i < locationArray.length; i++) {
            if (x == locationArray[i].x && y == locationArray[i].y) {
                return locationArray[i];
            }
        }
        return null;
    }

    public void describeLocation(Player player) {

        for (int i = 0; i < size; i++) {
            if (locationArray[i].x == player.getX() && locationArray[i].y == player.getY()) {
                System.out.println("Map location: 0, 0");
            }
        }
    }
}