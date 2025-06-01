public class Map {

    Location vera;
    Location veraLimitsNorth;
    Encounter cryingChild = new CryingChild();
    Encounter guardsLookingForBandit = new GuardsLookingForBandit();
    Encounter veraBanditAmbush = new VeraBanditAmbush();

    Location[] locationArray;
    static int size = 0;

    public Map() {
        locationArray = new Location[20];

        vera = new Location(0, 0);
        locationArray[0] = vera;
        vera.add(cryingChild);
        //vera.add(guardsLookingForBandit);
        vera.add(veraBanditAmbush);

        veraLimitsNorth = new Location(0,1);
        locationArray[1] = veraLimitsNorth;

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
                System.out.println("Map location: " + locationArray[i].x + " , " + locationArray[i].y);
            }

        }
    }
}