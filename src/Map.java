public class Map {

    GameEngine gameEngine;


    Location cityOne;
    Location southWestPlains;
    Location westernPlains;
    Location rockyPlateau;
    Location stormpeakMountainsSouth;
    Location stormpeakMountainsSummit;
    Location stormpeakMountainsNorth;

    Location crabgrassHills;
    Location greatneckReach;
    Location bloodFlowerMeadows;
    Location kingsRiver;
    Location kingsRiverRapids;
    Location kingsBasin;

    Location greentreeWoods;
    Location greentreeForest;
    Location templeOfLeaves;
    Location woodsOfSilence;
    Location southShore;
    Location sirensCove;
    Location bastardsBay;
    Location lutewardPort;
    Location cityThree;

    Location whisperingGrove;
    Location brutesWetlands;

    Location[] locationArray;

    public Map(GameEngine gameEngine) {
        locationArray = new Location[24];  //  23

        cityOne = new Location(0, 0);
        cityOne.add(new CryingChild());
        cityOne.add(new MysteriousWizard());
        cityOne.add(new JobBoardWolf());
        cityOne.name = "City One";
        locationArray[0] = cityOne;
        cityOne.isTown = true;

        southWestPlains = new Location(0, 1);
        southWestPlains.add(new WolfAttack());
        southWestPlains.add(new BanditAttack());
        southWestPlains.add(new StaminaPotionMerchant());
        southWestPlains.name = "South-West Plains";
        locationArray[1] = southWestPlains;

        westernPlains = new Location(0, 2);
        westernPlains.add(new WolfAttack());
        westernPlains.add(new BanditAttack());
        westernPlains.name = "Western Plains";
        westernPlains.add(new StaminaPotionMerchant());
        locationArray[2] = westernPlains;

        rockyPlateau = new Location(0,3);
        rockyPlateau.add(new WolfAttack());
        rockyPlateau.add(new BanditAttack());
        rockyPlateau.add(new OrcAttack());
        rockyPlateau.name = "Rocky Plateau";
        rockyPlateau.add(new StaminaPotionMerchant());
        locationArray[9] = rockyPlateau;

        stormpeakMountainsSouth = new Location(0,4);
        stormpeakMountainsSouth.add(new WolfAttack());
        stormpeakMountainsSouth.add(new BanditAttack());
        stormpeakMountainsSouth.add(new OrcAttack());
        stormpeakMountainsSouth.add(new StaminaPotionMerchant());
        stormpeakMountainsSouth.name = "Stormpeak Mountains (South)";
        locationArray[10] = stormpeakMountainsSouth;

        stormpeakMountainsSummit = new Location(0,5);
        stormpeakMountainsSummit.add(new WolfAttack());
        stormpeakMountainsSummit.add(new BanditAttack());
        stormpeakMountainsSummit.add(new OrcAttack());
        stormpeakMountainsSummit.add(new StaminaPotionMerchant());
        stormpeakMountainsSummit.name = "Stormpeak Mountain Summit";
        locationArray[11] = stormpeakMountainsSummit;

        stormpeakMountainsNorth = new Location(0,6);
        stormpeakMountainsNorth.add(new WolfAttack());
        stormpeakMountainsNorth.add(new BanditAttack());
        stormpeakMountainsNorth.add(new OrcAttack());
        stormpeakMountainsNorth.add(new StaminaPotionMerchant());
        stormpeakMountainsNorth.name = "Stormpeak Mountains (North)";
        locationArray[12] = stormpeakMountainsNorth;




        bloodFlowerMeadows = new Location(1, 0);
        bloodFlowerMeadows.add(new WolfAttack());
        bloodFlowerMeadows.add(new BanditAttack());
        bloodFlowerMeadows.add(new StaminaPotionMerchant());
        bloodFlowerMeadows.name = "Bloodflower Meadows";
        locationArray[3] = bloodFlowerMeadows;

        greatneckReach = new Location(1,1);
        greatneckReach.add(new WolfAttack());
        greatneckReach.add(new BanditAttack());
        greatneckReach.add(new StaminaPotionMerchant());
        greatneckReach.name = "Greatneck Reach";
        locationArray[5] = greatneckReach;

        crabgrassHills = new Location(1,2);
        crabgrassHills.add(new WolfAttack());
        crabgrassHills.add(new BanditAttack());
        crabgrassHills.add(new StaminaPotionMerchant());
        crabgrassHills.name = "Crabgrass Hills";
        locationArray[6] = crabgrassHills;



        kingsRiver = new Location(2,0);
        kingsRiver.add(new WolfAttack());
        kingsRiver.add(new BanditAttack());
        kingsRiver.add(new StaminaPotionMerchant());
        kingsRiver.name = "King's River";
        locationArray[4] = kingsRiver;

        kingsRiverRapids = new Location(2,1);
        kingsRiverRapids.add(new WolfAttack());
        kingsRiverRapids.add(new BanditAttack());
        kingsRiverRapids.add(new StaminaPotionMerchant());
        kingsRiverRapids.name = "King's River Rapids";
        locationArray[7] = kingsRiverRapids;

        kingsBasin = new Location(2,2);
        kingsBasin.add(new WolfAttack());
        kingsBasin.add(new BanditAttack());
        kingsBasin.add(new StaminaPotionMerchant());
        kingsBasin.name = "King's Basin";
        locationArray[8] = kingsBasin;


        greentreeWoods = new Location(3,0);
        greentreeWoods.add(new BanditAttack());
        greentreeWoods.add(new WolfAttack());
        greentreeWoods.add(new OrcAttack());
        greentreeWoods.add(new StaminaPotionMerchant());
        greentreeWoods.name = "Greentree Woods";
        locationArray[13] = greentreeWoods;

        whisperingGrove = new Location(3,1);
        whisperingGrove.add(new BanditAttack());
        whisperingGrove.add(new WolfAttack());
        whisperingGrove.add(new OrcAttack());
        whisperingGrove.add(new StaminaPotionMerchant());
        whisperingGrove.name = "Whispering Grove";
        locationArray[22] = whisperingGrove;

        brutesWetlands = new Location(3,2);
        brutesWetlands.add(new BanditAttack());
        brutesWetlands.add(new WolfAttack());
        brutesWetlands.add(new OrcAttack());
        brutesWetlands.add(new StaminaPotionMerchant());
        brutesWetlands.name = "Brute's Wetlands";
        locationArray[23] = brutesWetlands;






        greentreeForest = new Location(4,0);
        greentreeForest.add(new BanditAttack());
        greentreeForest.add(new WolfAttack());
        greentreeForest.add(new OrcAttack());
        greentreeForest.add(new StaminaPotionMerchant());
        greentreeForest.name = "Greentree Forest";
        locationArray[17] = greentreeForest;


        templeOfLeaves = new Location(5,0);
        templeOfLeaves.add(new BanditAttack());
        templeOfLeaves.add(new WolfAttack());
        templeOfLeaves.add(new OrcAttack());
        templeOfLeaves.add(new StaminaPotionMerchant());
        templeOfLeaves.name = "Temple of Leaves";
        locationArray[14] = templeOfLeaves;


        woodsOfSilence = new Location(6,0);
        woodsOfSilence.add(new BanditAttack());
        woodsOfSilence.add(new WolfAttack());
        woodsOfSilence.add(new OrcAttack());
        woodsOfSilence.add(new StaminaPotionMerchant());
        woodsOfSilence.name = "Woods of Silence";
        locationArray[15] = woodsOfSilence;


        southShore = new Location(7,0);
        southShore.add(new BanditAttack());
        southShore.add(new WolfAttack());
        southShore.add(new OrcAttack());
        southShore.add(new StaminaPotionMerchant());
        southShore.name = "South Shore";
        locationArray[16] = southShore;


        bastardsBay = new Location(8,0);
        bastardsBay.add(new BanditAttack());
        bastardsBay.add(new WolfAttack());
        bastardsBay.add(new StaminaPotionMerchant());
        bastardsBay.name = "Bastard's Bay";
        locationArray[18] = bastardsBay;




        lutewardPort = new Location(9,0);
        lutewardPort.add(new BanditAttack());
        lutewardPort.add(new WolfAttack());
        lutewardPort.add(new StaminaPotionMerchant());
        lutewardPort.name = "Luteward Port";
        locationArray[19] = lutewardPort;


        cityThree = new Location(10,0);
        cityThree.add(new CryingChild());
        cityThree.name = "City Three";
        cityThree.isTown = true;
        locationArray[20] = cityThree;

        sirensCove = new Location(10,1);
        sirensCove.add(new BanditAttack());
        sirensCove.add(new WolfAttack());
        sirensCove.add(new StaminaPotionMerchant());
        sirensCove.name = "Siren's Cove";
        locationArray[21] = sirensCove;









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