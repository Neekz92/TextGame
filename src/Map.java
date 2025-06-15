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
    Location kingsFalls;

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
    Location blackMarsh;
    Location treesongStream;
    Location stormpeakCliffs;
    Location badlandsSteppe;
    Location lakesideRest;
    Location ronkomasPull;
    Location ronkomasLakeWest;
    Location ronkomasThickBrush;
    Location ronkomasLakeSouth;
    Location ronkomasLake;
    Location ronkomasLakeNorth;

    Location abandonedOrchard;
    Location witchsHut;
    Location slimewoodSwamp;
    Location rainyGrasslands;
    Location sinksoilMoor;
    Location hagBog;

    Location[] locationArray;

    public Map(GameEngine gameEngine) {
        locationArray = new Location[41];  //  40

        cityOne = new Location(0, 0);
        cityOne.add(new CryingChild());
        cityOne.add(new MysteriousWizard());
        cityOne.add(new JobBoardWolf());
        cityOne.add(new JobBoardBandit());
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

        treesongStream = new Location(1,3);
        treesongStream.add(new WolfAttack());
        treesongStream.add(new BanditAttack());
        treesongStream.add(new OrcAttack());
        treesongStream.add(new StaminaPotionMerchant());
        treesongStream.name = "Treesong Stream";
        locationArray[25] = treesongStream;

        stormpeakCliffs = new Location(1,4);
        stormpeakCliffs.add(new WolfAttack());
        stormpeakCliffs.add(new BanditAttack());
        stormpeakCliffs.add(new OrcAttack());
        stormpeakCliffs.add(new StaminaPotionMerchant());
        stormpeakCliffs.name = "Stormpeak Cliffs";
        locationArray[26] = stormpeakCliffs;

        badlandsSteppe = new Location(1,5);
        badlandsSteppe.add(new WolfAttack());
        badlandsSteppe.add(new BanditAttack());
        badlandsSteppe.add(new OrcAttack());
        badlandsSteppe.add(new StaminaPotionMerchant());
        badlandsSteppe.name = "Badlands Steppe";
        locationArray[27] = badlandsSteppe;

        lakesideRest = new Location(1, 6);
        lakesideRest.add(new WolfAttack());
        lakesideRest.add(new BanditAttack());
        lakesideRest.add(new OrcAttack());
        lakesideRest.add(new StaminaPotionMerchant());
        lakesideRest.name = "Lakeside Rest";
        locationArray[28] = lakesideRest;







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

        kingsFalls = new Location(2,3);
        kingsFalls.add(new WolfAttack());
        kingsFalls.add(new BanditAttack());
        kingsFalls.add(new OrcAttack());
        kingsFalls.name = "King's Falls";
        locationArray[29] = kingsFalls;

        ronkomasPull = new Location(2,4);
        ronkomasPull.add(new WolfAttack());
        ronkomasPull.add(new BanditAttack());
        ronkomasPull.add(new OrcAttack());
        ronkomasPull.add(new StaminaPotionMerchant());
        ronkomasPull.name = "Ronkoma's Pull";
        locationArray[30] = ronkomasPull;

        ronkomasLakeWest = new Location(2,5);
        ronkomasLakeWest.add(new WolfAttack());
        ronkomasLakeWest.add(new BanditAttack());
        ronkomasLakeWest.add(new OrcAttack());
        ronkomasLakeWest.add(new StaminaPotionMerchant());
        ronkomasLakeWest.name = "Ronkoma's Lake (West)";
        locationArray[31] = ronkomasLakeWest;

        ronkomasThickBrush = new Location(2,6);
        ronkomasThickBrush.add(new WolfAttack());
        ronkomasThickBrush.add(new BanditAttack());
        ronkomasThickBrush.add(new OrcAttack());
        ronkomasThickBrush.add(new StaminaPotionMerchant());
        locationArray[32] = ronkomasThickBrush;




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

        blackMarsh = new Location(3,3);
        blackMarsh.add(new BanditAttack());
        blackMarsh.add(new WolfAttack());
        blackMarsh.add(new OrcAttack());
        blackMarsh.add(new StaminaPotionMerchant());
        blackMarsh.name = "Black Marsh";
        locationArray[24] = blackMarsh;

        ronkomasLakeSouth = new Location(3,4);
        ronkomasLakeSouth.add(new WolfAttack());
        ronkomasLakeSouth.add(new BanditAttack());
        ronkomasLakeSouth.add(new OrcAttack());
        ronkomasLakeSouth.add(new StaminaPotionMerchant());
        ronkomasLakeSouth.name = "Ronkoma's Lake (South)";
        locationArray[33] = ronkomasLakeSouth;

        ronkomasLake = new Location(3,5);
        ronkomasLake.add(new WolfAttack());
        ronkomasLake.add(new BanditAttack());
        ronkomasLake.add(new OrcAttack());
        ronkomasLake.add(new StaminaPotionMerchant());
        ronkomasLake.name = "Ronkoma's Lake";
        locationArray[34] = ronkomasLake;

        ronkomasLakeNorth = new Location(3,6);
        ronkomasLakeNorth.add(new WolfAttack());
        ronkomasLakeNorth.add(new BanditAttack());
        ronkomasLakeNorth.add(new OrcAttack());
        ronkomasLakeNorth.add(new StaminaPotionMerchant());
        ronkomasLakeNorth.name = "Ronkoma's Lake (North)";
        locationArray[35] = ronkomasLakeNorth;





        greentreeForest = new Location(4,0);
        greentreeForest.add(new BanditAttack());
        greentreeForest.add(new WolfAttack());
        greentreeForest.add(new OrcAttack());
        greentreeForest.add(new StaminaPotionMerchant());
        greentreeForest.name = "Greentree Forest";
        locationArray[17] = greentreeForest;

        abandonedOrchard = new Location(4,1);
        abandonedOrchard.add(new BanditAttack());
        abandonedOrchard.add(new WolfAttack());
        abandonedOrchard.add(new OrcAttack());
        abandonedOrchard.add(new StaminaPotionMerchant());
        abandonedOrchard.name = "Abandoned Orchard";
        locationArray[36] = abandonedOrchard;

        witchsHut = new Location(4,2);
        witchsHut.add(new BanditAttack());
        witchsHut.add(new WolfAttack());
        witchsHut.add(new OrcAttack());
        witchsHut.add(new StaminaPotionMerchant());
        witchsHut.name = "Witch's Hut";
        locationArray[36] = witchsHut;

        slimewoodSwamp = new Location(4,3);
        slimewoodSwamp.add(new BanditAttack());
        slimewoodSwamp.add(new WolfAttack());
        slimewoodSwamp.add(new OrcAttack());
        slimewoodSwamp.add(new StaminaPotionMerchant());
        slimewoodSwamp.name = "Slimewood Swamp";
        locationArray[37] = slimewoodSwamp;




        templeOfLeaves = new Location(5,0);
        templeOfLeaves.add(new BanditAttack());
        templeOfLeaves.add(new WolfAttack());
        templeOfLeaves.add(new OrcAttack());
        templeOfLeaves.add(new StaminaPotionMerchant());
        templeOfLeaves.name = "Temple of Leaves";
        locationArray[14] = templeOfLeaves;

        rainyGrasslands = new Location(5,1);
        rainyGrasslands.add(new BanditAttack());
        rainyGrasslands.add(new WolfAttack());
        rainyGrasslands.add(new OrcAttack());
        rainyGrasslands.add(new StaminaPotionMerchant());
        rainyGrasslands.name = "Rainy Grasslands";
        locationArray[38] = rainyGrasslands;

        sinksoilMoor = new Location(5,2);
        sinksoilMoor.add(new WolfAttack());
        sinksoilMoor.add(new BanditAttack());
        sinksoilMoor.add(new OrcAttack());
        sinksoilMoor.add(new StaminaPotionMerchant());
        sinksoilMoor.name = "Sinksoil Moor";
        locationArray[39] = sinksoilMoor;

        hagBog = new Location(5,3);
        hagBog.add(new WolfAttack());
        hagBog.add(new BanditAttack());
        hagBog.add(new OrcAttack());
        hagBog.add(new StaminaPotionMerchant());
        hagBog.name = "Hag Bog";
        locationArray[40] = hagBog;



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
        southShore.name = "Southern Shore";
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