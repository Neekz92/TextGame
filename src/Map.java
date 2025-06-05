public class Map {

    GameEngine gameEngine;


    Location cityOne;
    Location southWestPlains;
    Location westernPlains;

    Location bloodFlowerMeadows;
    Location kingsRiver;

    Location[] locationArray;

    public Map(GameEngine gameEngine) {
        locationArray = new Location[20];

        cityOne = new Location(0, 0);
        cityOne.add(new BanditAttack());
        cityOne.name = "City One";
        locationArray[0] = cityOne;

        southWestPlains = new Location(0, 1);
        southWestPlains.add(new WolfAttack());
        southWestPlains.add(new BanditAttack());
        southWestPlains.name = "South-West Plains";
        locationArray[1] = southWestPlains;

        westernPlains = new Location(0, 2);
        westernPlains.add(new WolfAttack());
        westernPlains.add(new BanditAttack());
        westernPlains.name = "Western Plains";
        locationArray[2] = westernPlains;


        bloodFlowerMeadows = new Location(1, 0);
        bloodFlowerMeadows.add(new WolfAttack());
        bloodFlowerMeadows.add(new BanditAttack());
        bloodFlowerMeadows.name = "Bloodflower Meadows";
        locationArray[3] = bloodFlowerMeadows;

        kingsRiver = new Location(2,0);
        kingsRiver.add(new WolfAttack());
        kingsRiver.add(new BanditAttack());
        kingsRiver.name = "King's River";
        locationArray[4] = kingsRiver;






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