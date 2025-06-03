public class Map {

    GameEngine gameEngine;
    Location cityOne;
    Location cityOneNorth;
    Location[] locationArray;

    public Map(GameEngine gameEngine) {
        locationArray = new Location[20];

        cityOne = new Location(0, 0);
        cityOne.add(new BanditAttack());
        locationArray[0] = cityOne;

        cityOneNorth = new Location(0, 1);
        cityOneNorth.add(new WolfAttack());
        cityOneNorth.add(new BanditAttack());
        locationArray[1] = cityOneNorth;
    }

    public Location findLocation(int x, int y) {
        for (int i = 0; i < locationArray.length; i++) {
            if (x == locationArray[i].x && y == locationArray[i].y) {
                return locationArray[i];
            }
        }
        return null;
    }

}