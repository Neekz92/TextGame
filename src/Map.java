public class Map {

    GameEngine gameEngine;


    Location cityOne;
    Location southWestPlains;
    Location westernPlains;
    Location rockyPlateau;
    Location stormpeakMountainsSouth;
    Location stormpeakMountainsSummit;
    Location stormpeakMountainsNorth;
    Location stormpeakTrail;
    Location frigidBirchwoods;
    Location frozenPath;
    Location cityTwo;
    Location bonechillWoods;
    Location thrashedCabin;
    Location tepidTundra;
    Location icyThreshold;
    Location veilOfFrost;
    Location icicleWay;
    Location frozenPlateau;
    Location frostwolfBreedingGrounds;
    Location everwintersMouth;
    Location northernHighlands;
    Location kelvinsCave;
    Location shiverpeakMountainsWest;
    Location frostbiteTrail;
    Location shiverpeakClimb;
    Location shiverpeakCliffs;
    Location shiverpeakMountains;
    Location wintersEdge;
    Location softsnowWoods;
    Location avalanchPath;
    Location shiverpeakMountainSummit;

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
    Location fishersPoint;
    Location ronkomasLakeEast;
    Location maidensGrave;
    Location rainyGrasslands;
    Location sinksoilMoor;
    Location hagBog;

    Location rollingRivermouth;
    Location cavernOfCadavers;
    Location frostleafBrush;

    Location duskmereHollow;
    Location fieldsOfClover;
    Location wildfishCrossing;
    Location ronkomasWhiteWaters;
    Location cavesOfTermina;
    Location smashstoneWastes;

    Location seaviewClearing;
    Location tidebranchFlow;
    Location slipperyStepstones;
    Location knicksTriangle;
    Location valensBurialGrounds;
    Location sunfireRidge;

    Location bastardsBridge;
    Location brinepassWaters;
    Location deerlingSanctuary;
    Location deadleafSticks;
    Location sandyHills;
    Location bonemanOutpost;

    Location drowngrassShore;
    Location spritesGathering;
    Location pixiesSticks;
    Location rockyWasteland;
    Location dunesOfSunsear;
    Location abandonedIronmine;

    Location veridianTreeline;
    Location sandleafBorder;
    Location barrenSandlands;
    Location sandwormFeedingGrounds;
    Location scorpionsPass;


    Location[] locationArray;

    public Map(GameEngine gameEngine) {
        locationArray = new Location[80];  //  79

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
        southWestPlains.add(new WoundedTraveler());
        southWestPlains.name = "South-West Plains";
        locationArray[1] = southWestPlains;

        westernPlains = new Location(0, 2);
        westernPlains.add(new WolfAttack());
        westernPlains.add(new BanditAttack());
        westernPlains.name = "Western Plains";
        westernPlains.add(new StaminaPotionMerchant());
        westernPlains.add(new WoundedTraveler());
        locationArray[2] = westernPlains;

        rockyPlateau = new Location(0,3);
        rockyPlateau.add(new WolfAttack());
        rockyPlateau.add(new BanditAttack());
        rockyPlateau.add(new OrcAttack());
        rockyPlateau.add(new GoblinAttack());
        rockyPlateau.name = "Rocky Plateau";
        rockyPlateau.add(new StaminaPotionMerchant());
        locationArray[9] = rockyPlateau;

        stormpeakMountainsSouth = new Location(0,4);
        stormpeakMountainsSouth.add(new WolfAttack());
        stormpeakMountainsSouth.add(new BanditAttack());
        stormpeakMountainsSouth.add(new OrcAttack());
        stormpeakMountainsSouth.add(new GoblinAttack());
        stormpeakMountainsSouth.add(new StaminaPotionMerchant());
        stormpeakMountainsSouth.name = "Stormpeak Mountains (South)";
        locationArray[10] = stormpeakMountainsSouth;

        stormpeakMountainsSummit = new Location(0,5);
        stormpeakMountainsSummit.add(new WolfAttack());
        stormpeakMountainsSummit.add(new BanditAttack());
        stormpeakMountainsSummit.add(new OrcAttack());
        stormpeakMountainsSummit.add(new GoblinAttack());
        stormpeakMountainsSummit.add(new StaminaPotionMerchant());
        stormpeakMountainsSummit.name = "Stormpeak Mountain Summit";
        locationArray[11] = stormpeakMountainsSummit;

        stormpeakMountainsNorth = new Location(0,6);
        stormpeakMountainsNorth.add(new WolfAttack());
        stormpeakMountainsNorth.add(new BanditAttack());
        stormpeakMountainsNorth.add(new OrcAttack());
        stormpeakMountainsNorth.add(new GoblinAttack());
        stormpeakMountainsNorth.add(new StaminaPotionMerchant());
        stormpeakMountainsNorth.name = "Stormpeak Mountains (North)";
        locationArray[12] = stormpeakMountainsNorth;

        stormpeakTrail = new Location(0,7);
        stormpeakTrail.add(new WolfAttack());
        stormpeakTrail.add(new BanditAttack());
        stormpeakTrail.add(new OrcAttack());
        stormpeakTrail.add(new GoblinAttack());
        stormpeakTrail.add(new StaminaPotionMerchant());
        stormpeakTrail.name = "Stormpeak Trail";
        locationArray[76] = stormpeakTrail;

        frigidBirchwoods = new Location(0,8);
        frigidBirchwoods.add(new WolfAttack());
        frigidBirchwoods.add(new BanditAttack());
        frigidBirchwoods.add(new WoundedTraveler());
        frigidBirchwoods.add(new StaminaPotionMerchant());
        frigidBirchwoods.name = "Frigid Birchwoods";
        locationArray[77] = frigidBirchwoods;

        frozenPath = new Location(0,9);
        frozenPath.add(new WolfAttack());
        frozenPath.add(new BanditAttack());
        frozenPath.add(new WoundedTraveler());
        frozenPath.add(new StaminaPotionMerchant());
        frozenPath.name = "Frozen Path";
        locationArray[78] = frozenPath;

        cityTwo = new Location(0,10);
        cityTwo.add(new CryingChild());
        cityTwo.add(new MysteriousWizard());
        cityTwo.add(new JobBoardWolf());
        cityTwo.add(new JobBoardBandit());
        cityTwo.name = "City Two";
        locationArray[79] = cityTwo;



        bloodFlowerMeadows = new Location(1, 0);
        bloodFlowerMeadows.add(new WolfAttack());
        bloodFlowerMeadows.add(new BanditAttack());
        bloodFlowerMeadows.add(new StaminaPotionMerchant());
        bloodFlowerMeadows.add(new WoundedTraveler());
        bloodFlowerMeadows.name = "Bloodflower Meadows";
        locationArray[3] = bloodFlowerMeadows;

        greatneckReach = new Location(1,1);
        greatneckReach.add(new WolfAttack());
        greatneckReach.add(new BanditAttack());
        greatneckReach.add(new StaminaPotionMerchant());
        greatneckReach.add(new WoundedTraveler());
        greatneckReach.name = "Greatneck Reach";
        locationArray[5] = greatneckReach;

        crabgrassHills = new Location(1,2);
        crabgrassHills.add(new WolfAttack());
        crabgrassHills.add(new BanditAttack());
        crabgrassHills.add(new StaminaPotionMerchant());
        crabgrassHills.add(new WoundedTraveler());
        crabgrassHills.name = "Crabgrass Hills";
        locationArray[6] = crabgrassHills;

        treesongStream = new Location(1,3);
        treesongStream.add(new WolfAttack());
        treesongStream.add(new BanditAttack());
        treesongStream.add(new OrcAttack());
        treesongStream.add(new GoblinAttack());
        treesongStream.add(new StaminaPotionMerchant());
        treesongStream.name = "Treesong Stream";
        locationArray[25] = treesongStream;

        stormpeakCliffs = new Location(1,4);
        stormpeakCliffs.add(new WolfAttack());
        stormpeakCliffs.add(new BanditAttack());
        stormpeakCliffs.add(new OrcAttack());
        stormpeakCliffs.add(new GoblinAttack());
        stormpeakCliffs.add(new StaminaPotionMerchant());
        stormpeakCliffs.name = "Stormpeak Cliffs";
        locationArray[26] = stormpeakCliffs;

        badlandsSteppe = new Location(1,5);
        badlandsSteppe.add(new WolfAttack());
        badlandsSteppe.add(new BanditAttack());
        badlandsSteppe.add(new OrcAttack());
        badlandsSteppe.add(new GoblinAttack());
        badlandsSteppe.add(new StaminaPotionMerchant());
        badlandsSteppe.name = "Badlands Steppe";
        locationArray[27] = badlandsSteppe;

        lakesideRest = new Location(1, 6);
        lakesideRest.add(new WolfAttack());
        lakesideRest.add(new BanditAttack());
        lakesideRest.add(new OrcAttack());
        lakesideRest.add(new GoblinAttack());
        lakesideRest.add(new StaminaPotionMerchant());
        lakesideRest.name = "Lakeside Rest";
        locationArray[28] = lakesideRest;

        bonechillWoods = new Location(1,7);
        bonechillWoods.add(new WolfAttack());
        bonechillWoods.add(new BanditAttack());
        bonechillWoods.add(new OrcAttack());
        bonechillWoods.add(new GoblinAttack());
        bonechillWoods.add(new StaminaPotionMerchant());
        bonechillWoods.name = "Bonechill Woods";
        locationArray[80] = bonechillWoods;

        thrashedCabin = new Location(1,8);
        thrashedCabin.add(new WolfAttack());
        thrashedCabin.add(new BanditAttack());
        thrashedCabin.add(new StaminaPotionMerchant());
        thrashedCabin.add(new WoundedTraveler());
        thrashedCabin.name = "Thrashed Cabin";
        locationArray[81] = thrashedCabin;

        tepidTundra = new Location(1,9);
        tepidTundra.add(new WolfAttack());
        tepidTundra.add(new BanditAttack());
        tepidTundra.add(new StaminaPotionMerchant());
        tepidTundra.add(new WoundedTraveler());
        tepidTundra.name = "Tepid Tundra";
        locationArray[82] = tepidTundra;

        icyThreshold = new Location(1,10);
        icyThreshold.add(new WolfAttack());
        icyThreshold.add(new BanditAttack());
        icyThreshold.add(new WoundedTraveler());
        icyThreshold.add(new StaminaPotionMerchant());
        icyThreshold.name = "Icy Threshold";
        locationArray[83] = icyThreshold;





        kingsRiver = new Location(2,0);
        kingsRiver.add(new WolfAttack());
        kingsRiver.add(new BanditAttack());
        kingsRiver.add(new StaminaPotionMerchant());
        kingsRiver.add(new WoundedTraveler());
        kingsRiver.name = "King's River";
        locationArray[4] = kingsRiver;

        kingsRiverRapids = new Location(2,1);
        kingsRiverRapids.add(new WolfAttack());
        kingsRiverRapids.add(new BanditAttack());
        kingsRiverRapids.add(new StaminaPotionMerchant());
        kingsRiverRapids.add(new WoundedTraveler());
        kingsRiverRapids.name = "King's River Rapids";
        locationArray[7] = kingsRiverRapids;

        kingsBasin = new Location(2,2);
        kingsBasin.add(new WolfAttack());
        kingsBasin.add(new BanditAttack());
        kingsBasin.add(new StaminaPotionMerchant());
        kingsBasin.add(new WoundedTraveler());
        kingsBasin.name = "King's Basin";
        locationArray[8] = kingsBasin;

        kingsFalls = new Location(2,3);
        kingsFalls.add(new WolfAttack());
        kingsFalls.add(new BanditAttack());
        kingsFalls.add(new OrcAttack());
        kingsFalls.add(new GoblinAttack());
        kingsFalls.name = "King's Falls";
        locationArray[29] = kingsFalls;

        ronkomasPull = new Location(2,4);
        ronkomasPull.add(new WolfAttack());
        ronkomasPull.add(new BanditAttack());
        ronkomasPull.add(new OrcAttack());
        ronkomasPull.add(new GoblinAttack());
        ronkomasPull.add(new StaminaPotionMerchant());
        ronkomasPull.name = "Ronkoma's Pull";
        locationArray[30] = ronkomasPull;

        ronkomasLakeWest = new Location(2,5);
        ronkomasLakeWest.add(new WolfAttack());
        ronkomasLakeWest.add(new BanditAttack());
        ronkomasLakeWest.add(new OrcAttack());
        ronkomasLakeWest.add(new GoblinAttack());
        ronkomasLakeWest.add(new StaminaPotionMerchant());
        ronkomasLakeWest.name = "Ronkoma's Lake (West)";
        locationArray[31] = ronkomasLakeWest;

        ronkomasThickBrush = new Location(2,6);
        ronkomasThickBrush.add(new WolfAttack());
        ronkomasThickBrush.add(new BanditAttack());
        ronkomasThickBrush.add(new OrcAttack());
        ronkomasThickBrush.add(new GoblinAttack());
        ronkomasThickBrush.add(new StaminaPotionMerchant());
        ronkomasThickBrush.name = "Ronkoma's Thickbrush";
        locationArray[32] = ronkomasThickBrush;

        veilOfFrost = new Location(2,7);
        veilOfFrost.add(new WolfAttack());
        veilOfFrost.add(new BanditAttack());
        veilOfFrost.add(new OrcAttack());
        veilOfFrost.add(new GoblinAttack());
        veilOfFrost.add(new StaminaPotionMerchant());
        veilOfFrost.name = "Veil of Frost";
        locationArray[84] = veilOfFrost;

        icicleWay = new Location(2,8);
        icicleWay.add(new WolfAttack());
        icicleWay.add(new BanditAttack());
        icicleWay.add(new WoundedTraveler());
        icicleWay.add(new StaminaPotionMerchant());
        icicleWay.name = "Icicle Way";
        locationArray[85] = icicleWay;

        frozenPlateau = new Location(2,9);
        frozenPlateau.add(new WolfAttack());
        frozenPlateau.add(new BanditAttack());
        frozenPlateau.add(new StaminaPotionMerchant());
        frozenPlateau.add(new WoundedTraveler());
        frozenPlateau.name = "Frozen Plateau";
        locationArray[86] = frozenPlateau;

        frostwolfBreedingGrounds = new Location(2,10);
        frostwolfBreedingGrounds.add(new WolfAttack());
        frostwolfBreedingGrounds.add(new BanditAttack());
        frostwolfBreedingGrounds.add(new StaminaPotionMerchant());
        frostwolfBreedingGrounds.add(new WoundedTraveler());
        frostwolfBreedingGrounds.name = "Frostwolf Breeding Grounds";
        locationArray[87] = frostwolfBreedingGrounds;






        greentreeWoods = new Location(3,0);
        greentreeWoods.add(new BanditAttack());
        greentreeWoods.add(new WolfAttack());
        greentreeWoods.add(new OrcAttack());
        greentreeWoods.add(new GoblinAttack());
        greentreeWoods.add(new StaminaPotionMerchant());
        greentreeWoods.name = "Greentree Woods";
        locationArray[13] = greentreeWoods;

        whisperingGrove = new Location(3,1);
        whisperingGrove.add(new BanditAttack());
        whisperingGrove.add(new WolfAttack());
        whisperingGrove.add(new OrcAttack());
        whisperingGrove.add(new GoblinAttack());
        whisperingGrove.add(new StaminaPotionMerchant());
        whisperingGrove.name = "Whispering Grove";
        locationArray[22] = whisperingGrove;

        brutesWetlands = new Location(3,2);
        brutesWetlands.add(new BanditAttack());
        brutesWetlands.add(new WolfAttack());
        brutesWetlands.add(new OrcAttack());
        brutesWetlands.add(new GoblinAttack());
        brutesWetlands.add(new StaminaPotionMerchant());
        brutesWetlands.name = "Brute's Wetlands";
        locationArray[23] = brutesWetlands;

        blackMarsh = new Location(3,3);
        blackMarsh.add(new BanditAttack());
        blackMarsh.add(new WolfAttack());
        blackMarsh.add(new OrcAttack());
        blackMarsh.add(new GoblinAttack());
        blackMarsh.add(new StaminaPotionMerchant());
        blackMarsh.name = "Black Marsh";
        locationArray[24] = blackMarsh;

        ronkomasLakeSouth = new Location(3,4);
        ronkomasLakeSouth.add(new WolfAttack());
        ronkomasLakeSouth.add(new BanditAttack());
        ronkomasLakeSouth.add(new OrcAttack());
        ronkomasLakeSouth.add(new GoblinAttack());
        ronkomasLakeSouth.add(new StaminaPotionMerchant());
        ronkomasLakeSouth.name = "Ronkoma's Lake (South)";
        locationArray[33] = ronkomasLakeSouth;

        ronkomasLake = new Location(3,5);
        ronkomasLake.add(new WolfAttack());
        ronkomasLake.add(new BanditAttack());
        ronkomasLake.add(new OrcAttack());
        ronkomasLake.add(new GoblinAttack());
        ronkomasLake.add(new StaminaPotionMerchant());
        ronkomasLake.name = "Ronkoma's Lake";
        locationArray[34] = ronkomasLake;

        ronkomasLakeNorth = new Location(3,6);
        ronkomasLakeNorth.add(new WolfAttack());
        ronkomasLakeNorth.add(new BanditAttack());
        ronkomasLakeNorth.add(new OrcAttack());
        ronkomasLakeNorth.add(new GoblinAttack());
        ronkomasLakeNorth.add(new StaminaPotionMerchant());
        ronkomasLakeNorth.name = "Ronkoma's Lake (North)";
        locationArray[35] = ronkomasLakeNorth;

        everwintersMouth = new Location(3,7);
        everwintersMouth.add(new WolfAttack());
        everwintersMouth.add(new BanditAttack());
        everwintersMouth.add(new OrcAttack());
        everwintersMouth.add(new GoblinAttack());
        everwintersMouth.add(new StaminaPotionMerchant());
        everwintersMouth.name = "Everwinter's Mouth";
        locationArray[88] = everwintersMouth;

        northernHighlands = new Location(3,8);
        northernHighlands.add(new WolfAttack());
        northernHighlands.add(new BanditAttack());
        northernHighlands.add(new StaminaPotionMerchant());
        northernHighlands.add(new OrcAttack());
        northernHighlands.add(new GoblinAttack());
        northernHighlands.name = "Northern Highlands";
        locationArray[89] = northernHighlands;

        kelvinsCave = new Location(3,9);
        kelvinsCave.add(new WolfAttack());
        kelvinsCave.add(new BanditAttack());
        kelvinsCave.add(new StaminaPotionMerchant());
        kelvinsCave.add(new OrcAttack());
        kelvinsCave.add(new GoblinAttack());
        kelvinsCave.name = "Kelvin's Cave";
        locationArray[90] = kelvinsCave;

        shiverpeakMountainsWest = new Location(3,10);
        shiverpeakMountainsWest.add(new WolfAttack());
        shiverpeakMountainsWest.add(new BanditAttack());
        shiverpeakMountainsWest.add(new OrcAttack());
        shiverpeakMountainsWest.add(new GoblinAttack());
        shiverpeakMountainsWest.add(new StaminaPotionMerchant());
        shiverpeakMountainsWest.name = "Shiverpeak Mountains (West)";
        locationArray[91] = shiverpeakMountainsWest;





        greentreeForest = new Location(4,0);
        greentreeForest.add(new BanditAttack());
        greentreeForest.add(new WolfAttack());
        greentreeForest.add(new OrcAttack());
        greentreeForest.add(new GoblinAttack());
        greentreeForest.add(new StaminaPotionMerchant());
        greentreeForest.name = "Greentree Forest";
        locationArray[17] = greentreeForest;

        abandonedOrchard = new Location(4,1);
        abandonedOrchard.add(new BanditAttack());
        abandonedOrchard.add(new WolfAttack());
        abandonedOrchard.add(new OrcAttack());
        abandonedOrchard.add(new GoblinAttack());
        abandonedOrchard.add(new StaminaPotionMerchant());
        abandonedOrchard.name = "Abandoned Orchard";
        locationArray[36] = abandonedOrchard;

        witchsHut = new Location(4,2);
        witchsHut.add(new BanditAttack());
        witchsHut.add(new WolfAttack());
        witchsHut.add(new OrcAttack());
        witchsHut.add(new GoblinAttack());
        witchsHut.add(new StaminaPotionMerchant());
        witchsHut.name = "Witch's Hut";
        locationArray[36] = witchsHut;

        slimewoodSwamp = new Location(4,3);
        slimewoodSwamp.add(new BanditAttack());
        slimewoodSwamp.add(new WolfAttack());
        slimewoodSwamp.add(new OrcAttack());
        slimewoodSwamp.add(new GoblinAttack());
        slimewoodSwamp.add(new StaminaPotionMerchant());
        slimewoodSwamp.name = "Slimewood Swamp";
        locationArray[37] = slimewoodSwamp;

        fishersPoint = new Location(4,4);
        fishersPoint.add(new BanditAttack());
        fishersPoint.add(new WolfAttack());
        fishersPoint.add(new OrcAttack());
        fishersPoint.add(new GoblinAttack());
        fishersPoint.add(new StaminaPotionMerchant());
        fishersPoint.name = "Fisher's Point";
        locationArray[41] = fishersPoint;

        ronkomasLakeEast = new Location(4,5);
        ronkomasLakeEast.add(new BanditAttack());
        ronkomasLakeEast.add(new WolfAttack());
        ronkomasLakeEast.add(new OrcAttack());
        ronkomasLakeEast.add(new GoblinAttack());
        ronkomasLakeEast.add(new StaminaPotionMerchant());
        ronkomasLakeEast.name = "Ronkoma's Lake (East)";
        locationArray[42] = ronkomasLakeEast;

        maidensGrave = new Location(4,6);
        maidensGrave.add(new BanditAttack());
        maidensGrave.add(new WolfAttack());
        maidensGrave.add(new OrcAttack());
        maidensGrave.add(new GoblinAttack());
        maidensGrave.add(new StaminaPotionMerchant());
        maidensGrave.name = "Maiden's Grave";
        locationArray[43] = maidensGrave;

        frostbiteTrail = new Location(4,7);
        frostbiteTrail.add(new BanditAttack());
        frostbiteTrail.add(new WolfAttack());
        frostbiteTrail.add(new OrcAttack());
        frostbiteTrail.add(new GoblinAttack());
        frostbiteTrail.add(new StaminaPotionMerchant());
        frostbiteTrail.name = "Frostbite Trail";
        locationArray[92] = frostbiteTrail;

        shiverpeakClimb = new Location(4,8);
        shiverpeakClimb.add(new WolfAttack());
        shiverpeakClimb.add(new BanditAttack());
        shiverpeakClimb.add(new OrcAttack());
        shiverpeakClimb.add(new GoblinAttack());
        shiverpeakClimb.add(new StaminaPotionMerchant());
        shiverpeakClimb.name = "Shiverpeak Climb";
        locationArray[93] = shiverpeakClimb;

        shiverpeakCliffs = new Location(4,9);
        shiverpeakCliffs.add(new WolfAttack());
        shiverpeakCliffs.add(new BanditAttack());
        shiverpeakCliffs.add(new OrcAttack());
        shiverpeakCliffs.add(new GoblinAttack());
        shiverpeakCliffs.add(new StaminaPotionMerchant());
        shiverpeakCliffs.name = "Shiverpeak Cliffs";
        locationArray[94] = shiverpeakCliffs;

        shiverpeakMountains = new Location(4,10);
        shiverpeakMountains.add(new WolfAttack());
        shiverpeakMountains.add(new BanditAttack());
        shiverpeakMountains.add(new OrcAttack());
        shiverpeakMountains.add(new GoblinAttack());
        shiverpeakMountains.add(new StaminaPotionMerchant());
        shiverpeakMountains.name = "Shiverpeak Mountains";
        locationArray[95] = shiverpeakMountains;






        templeOfLeaves = new Location(5,0);
        templeOfLeaves.add(new BanditAttack());
        templeOfLeaves.add(new WolfAttack());
        templeOfLeaves.add(new OrcAttack());
        templeOfLeaves.add(new GoblinAttack());
        templeOfLeaves.add(new StaminaPotionMerchant());
        templeOfLeaves.name = "Temple of Leaves";
        locationArray[14] = templeOfLeaves;

        rainyGrasslands = new Location(5,1);
        rainyGrasslands.add(new BanditAttack());
        rainyGrasslands.add(new WolfAttack());
        rainyGrasslands.add(new OrcAttack());
        rainyGrasslands.add(new GoblinAttack());
        rainyGrasslands.add(new StaminaPotionMerchant());
        rainyGrasslands.name = "Rainy Grasslands";
        locationArray[38] = rainyGrasslands;

        sinksoilMoor = new Location(5,2);
        sinksoilMoor.add(new WolfAttack());
        sinksoilMoor.add(new BanditAttack());
        sinksoilMoor.add(new OrcAttack());
        sinksoilMoor.add(new GoblinAttack());
        sinksoilMoor.add(new StaminaPotionMerchant());
        sinksoilMoor.name = "Sinksoil Moor";
        locationArray[39] = sinksoilMoor;

        hagBog = new Location(5,3);
        hagBog.add(new WolfAttack());
        hagBog.add(new BanditAttack());
        hagBog.add(new OrcAttack());
        hagBog.add(new GoblinAttack());
        hagBog.add(new StaminaPotionMerchant());
        hagBog.name = "Hag Bog";
        locationArray[40] = hagBog;

        rollingRivermouth = new Location(5,4);
        rollingRivermouth.add(new WolfAttack());
        rollingRivermouth.add(new BanditAttack());
        rollingRivermouth.add(new OrcAttack());
        rollingRivermouth.add(new GoblinAttack());
        rollingRivermouth.add(new StaminaPotionMerchant());
        rollingRivermouth.name = "Rolling Rivermouth";
        locationArray[44] = rollingRivermouth;

        cavernOfCadavers = new Location(5,5);
        cavernOfCadavers.add(new WolfAttack());
        cavernOfCadavers.add(new BanditAttack());
        cavernOfCadavers.add(new OrcAttack());
        cavernOfCadavers.add(new GoblinAttack());
        cavernOfCadavers.add(new StaminaPotionMerchant());
        cavernOfCadavers.name = "Cavern of Cadavers";
        locationArray[45] = cavernOfCadavers;

        frostleafBrush = new Location(5,6);
        frostleafBrush.add(new WolfAttack());
        frostleafBrush.add(new BanditAttack());
        frostleafBrush.add(new OrcAttack());
        frostleafBrush.add(new GoblinAttack());
        frostleafBrush.add(new StaminaPotionMerchant());
        frostleafBrush.name = "Frostleaf Brush";
        locationArray[46] = frostleafBrush;

        wintersEdge = new Location(5,7);
        wintersEdge.add(new WolfAttack());
        wintersEdge.add(new BanditAttack());
        wintersEdge.add(new OrcAttack());
        wintersEdge.add(new GoblinAttack());
        wintersEdge.add(new StaminaPotionMerchant());
        wintersEdge.name = "Winter's Edge";
        locationArray[96] = wintersEdge;

        softsnowWoods = new Location(5,8);
        softsnowWoods.add(new WolfAttack());
        softsnowWoods.add(new BanditAttack());
        softsnowWoods.add(new OrcAttack());
        softsnowWoods.add(new GoblinAttack());
        softsnowWoods.add(new StaminaPotionMerchant());
        softsnowWoods.name = "Softsnow Woods";
        locationArray[97] = softsnowWoods;

        avalanchPath = new Location(5,9);
        avalanchPath.add(new WolfAttack());
        avalanchPath.add(new BanditAttack());
        avalanchPath.add(new OrcAttack());
        avalanchPath.add(new GoblinAttack());
        avalanchPath.add(new StaminaPotionMerchant());
        avalanchPath.name = "Avalanche Path";
        locationArray[98] = avalanchPath;

        shiverpeakMountainSummit = new Location(5,10);
        shiverpeakMountainSummit.add(new WolfAttack());
        shiverpeakMountainSummit.add(new BanditAttack());
        shiverpeakMountainSummit.add(new OrcAttack());
        shiverpeakMountainSummit.add(new GoblinAttack());
        shiverpeakMountainSummit.add(new StaminaPotionMerchant());
        shiverpeakMountainSummit.name = "Shiverpeak Mountain Summit";
        locationArray[99] = shiverpeakMountainSummit;






        woodsOfSilence = new Location(6,0);
        woodsOfSilence.add(new BanditAttack());
        woodsOfSilence.add(new WolfAttack());
        woodsOfSilence.add(new OrcAttack());
        woodsOfSilence.add(new GoblinAttack());
        woodsOfSilence.add(new StaminaPotionMerchant());
        woodsOfSilence.name = "Woods of Silence";
        locationArray[15] = woodsOfSilence;

        duskmereHollow = new Location(6,1);
        duskmereHollow.add(new BanditAttack());
        duskmereHollow.add(new WolfAttack());
        duskmereHollow.add(new OrcAttack());
        duskmereHollow.add(new GoblinAttack());
        duskmereHollow.add(new StaminaPotionMerchant());
        duskmereHollow.name = "Duskmere Hollow";
        locationArray[47] = duskmereHollow;

        fieldsOfClover = new Location(6,2);
        fieldsOfClover.add(new BanditAttack());
        fieldsOfClover.add(new WolfAttack());
        fieldsOfClover.add(new OrcAttack());
        fieldsOfClover.add(new GoblinAttack());
        fieldsOfClover.add(new StaminaPotionMerchant());
        fieldsOfClover.name = "Fields of Clover";
        locationArray[48] = fieldsOfClover;

        wildfishCrossing = new Location(6,3);
        wildfishCrossing.add(new BanditAttack());
        wildfishCrossing.add(new WolfAttack());
        wildfishCrossing.add(new OrcAttack());
        wildfishCrossing.add(new GoblinAttack());
        wildfishCrossing.add(new StaminaPotionMerchant());
        wildfishCrossing.name = "Wildfish Crossing";
        locationArray[49] = wildfishCrossing;

        ronkomasWhiteWaters = new Location(6,4);
        ronkomasWhiteWaters.add(new BanditAttack());
        ronkomasWhiteWaters.add(new WolfAttack());
        ronkomasWhiteWaters.add(new OrcAttack());
        ronkomasWhiteWaters.add(new GoblinAttack());
        ronkomasWhiteWaters.add(new StaminaPotionMerchant());
        ronkomasWhiteWaters.name = "Ronkoma's White Waters";
        locationArray[50] = ronkomasWhiteWaters;

        cavesOfTermina = new Location(6,5);
        cavesOfTermina.add(new BanditAttack());
        cavesOfTermina.add(new WolfAttack());
        cavesOfTermina.add(new OrcAttack());
        cavesOfTermina.add(new GoblinAttack());
        cavesOfTermina.add(new StaminaPotionMerchant());
        cavesOfTermina.name = "Caves of Termina";
        locationArray[51] = cavesOfTermina;

        smashstoneWastes = new Location(6,6);
        smashstoneWastes.add(new BanditAttack());
        smashstoneWastes.add(new WolfAttack());
        smashstoneWastes.add(new OrcAttack());
        smashstoneWastes.add(new GoblinAttack());
        smashstoneWastes.add(new StaminaPotionMerchant());
        smashstoneWastes.name = "Smashstone Wastes";
        locationArray[52] = smashstoneWastes;



        southShore = new Location(7,0);
        southShore.add(new BanditAttack());
        southShore.add(new WolfAttack());
        southShore.add(new OrcAttack());
        southShore.add(new GoblinAttack());
        southShore.add(new StaminaPotionMerchant());
        southShore.name = "Southern Shore";
        locationArray[16] = southShore;

        seaviewClearing = new Location(7,1);
        seaviewClearing.add(new BanditAttack());
        seaviewClearing.add(new WolfAttack());
        seaviewClearing.add(new OrcAttack());
        seaviewClearing.add(new GoblinAttack());
        seaviewClearing.add(new StaminaPotionMerchant());
        seaviewClearing.name = "Seaview Clearing";
        locationArray[53] = seaviewClearing;

        tidebranchFlow = new Location(7,2);
        tidebranchFlow.add(new BanditAttack());
        tidebranchFlow.add(new WolfAttack());
        tidebranchFlow.add(new OrcAttack());
        tidebranchFlow.add(new GoblinAttack());
        tidebranchFlow.add(new StaminaPotionMerchant());
        tidebranchFlow.name = "Tidebranch Flow";
        locationArray[54] = tidebranchFlow;

        slipperyStepstones = new Location(7,3);
        slipperyStepstones.add(new BanditAttack());
        slipperyStepstones.add(new WolfAttack());
        slipperyStepstones.add(new OrcAttack());
        slipperyStepstones.add(new GoblinAttack());
        slipperyStepstones.add(new StaminaPotionMerchant());
        slipperyStepstones.name = "Slippery Stepstones";
        locationArray[55] = slipperyStepstones;

        knicksTriangle = new Location(7,4);
        knicksTriangle.add(new BanditAttack());
        knicksTriangle.add(new WolfAttack());
        knicksTriangle.add(new OrcAttack());
        knicksTriangle.add(new GoblinAttack());
        knicksTriangle.add(new StaminaPotionMerchant());
        knicksTriangle.name = "Knick's Triangle";
        locationArray[56] = knicksTriangle;

        valensBurialGrounds = new Location(7,5);
        valensBurialGrounds.add(new BanditAttack());
        valensBurialGrounds.add(new WolfAttack());
        valensBurialGrounds.add(new OrcAttack());
        valensBurialGrounds.add(new GoblinAttack());
        valensBurialGrounds.add(new StaminaPotionMerchant());
        valensBurialGrounds.name = "Valen's Burial Grounds";
        locationArray[57] = valensBurialGrounds;

        sunfireRidge = new Location(7,6);
        sunfireRidge.add(new BanditAttack());
        sunfireRidge.add(new WolfAttack());
        sunfireRidge.add(new OrcAttack());
        sunfireRidge.add(new GoblinAttack());
        sunfireRidge.add(new StaminaPotionMerchant());
        sunfireRidge.name = "Sunfire Ridge";
        locationArray[58] = sunfireRidge;




        bastardsBay = new Location(8,0);
        bastardsBay.add(new BanditAttack());
        bastardsBay.add(new WolfAttack());
        bastardsBay.add(new StaminaPotionMerchant());
        bastardsBay.add(new WoundedTraveler());
        bastardsBay.name = "Bastard's Bay";
        locationArray[18] = bastardsBay;

        bastardsBridge = new Location(8,1);
        bastardsBridge.add(new BanditAttack());
        bastardsBridge.add(new WolfAttack());
        bastardsBridge.add(new WoundedTraveler());
        bastardsBridge.add(new StaminaPotionMerchant());
        bastardsBridge.name = "Bastard's Bridge";
        locationArray[59] = bastardsBridge;

        brinepassWaters = new Location(8,2);
        brinepassWaters.add(new BanditAttack());
        brinepassWaters.add(new WolfAttack());
        brinepassWaters.add(new WoundedTraveler());
        brinepassWaters.add(new StaminaPotionMerchant());
        brinepassWaters.name = "Brinepass Waters";
        locationArray[60] = brinepassWaters;

        deerlingSanctuary = new Location(8,3);
        deerlingSanctuary.add(new BanditAttack());
        deerlingSanctuary.add(new WolfAttack());
        deerlingSanctuary.add(new OrcAttack());
        deerlingSanctuary.add(new GoblinAttack());
        deerlingSanctuary.add(new StaminaPotionMerchant());
        deerlingSanctuary.name = "Deerling Sanctuary";
        locationArray[61] = deerlingSanctuary;

        deadleafSticks = new Location(8,4);
        deadleafSticks.add(new BanditAttack());
        deadleafSticks.add(new WolfAttack());
        deadleafSticks.add(new OrcAttack());
        deadleafSticks.add(new GoblinAttack());
        deadleafSticks.add(new StaminaPotionMerchant());
        deadleafSticks.name = "Deadleaf Sticks";
        locationArray[62] = deadleafSticks;

        sandyHills = new Location(8,5);
        sandyHills.add(new BanditAttack());
        sandyHills.add(new WolfAttack());
        sandyHills.add(new OrcAttack());
        sandyHills.add(new GoblinAttack());
        sandyHills.add(new StaminaPotionMerchant());
        sandyHills.name = "Sandy Hills";
        locationArray[63] = sandyHills;

        bonemanOutpost = new Location(8,6);
        bonemanOutpost.add(new BanditAttack());
        bonemanOutpost.add(new WolfAttack());
        bonemanOutpost.add(new OrcAttack());
        bonemanOutpost.add(new GoblinAttack());
        bonemanOutpost.add(new StaminaPotionMerchant());
        bonemanOutpost.name = "Boneman's Outpost";
        locationArray[64] = bonemanOutpost;




        lutewardPort = new Location(9,0);
        lutewardPort.add(new BanditAttack());
        lutewardPort.add(new WolfAttack());
        lutewardPort.add(new StaminaPotionMerchant());
        lutewardPort.add(new WoundedTraveler());
        lutewardPort.name = "Luteward Port";
        locationArray[19] = lutewardPort;

        drowngrassShore = new Location(9,1);
        drowngrassShore.add(new BanditAttack());
        drowngrassShore.add(new WolfAttack());
        drowngrassShore.add(new WoundedTraveler());
        drowngrassShore.add(new StaminaPotionMerchant());
        drowngrassShore.name = "Drowngrass Shore";
        locationArray[65] = drowngrassShore;

        pixiesSticks = new Location(9,2);
        pixiesSticks.add(new BanditAttack());
        pixiesSticks.add(new WolfAttack());
        pixiesSticks.add(new StaminaPotionMerchant());
        pixiesSticks.add(new WoundedTraveler());
        pixiesSticks.name = "Pixie's Sticks";
        locationArray[66] = pixiesSticks;

        spritesGathering = new Location(9,3);
        spritesGathering.add(new BanditAttack());
        spritesGathering.add(new WolfAttack());
        spritesGathering.add(new OrcAttack());
        spritesGathering.add(new GoblinAttack());
        spritesGathering.add(new StaminaPotionMerchant());
        spritesGathering.name = "Sprite's Gathering";
        locationArray[67] = spritesGathering;

        rockyWasteland = new Location(9,4);
        rockyWasteland.add(new BanditAttack());
        rockyWasteland.add(new WolfAttack());
        rockyWasteland.add(new OrcAttack());
        rockyWasteland.add(new GoblinAttack());
        rockyWasteland.add(new StaminaPotionMerchant());
        rockyWasteland.name = "Rocky Wasteland";
        locationArray[68] = rockyWasteland;

        dunesOfSunsear = new Location(9,5);
        dunesOfSunsear.add(new BanditAttack());
        dunesOfSunsear.add(new WolfAttack());
        dunesOfSunsear.add(new OrcAttack());
        dunesOfSunsear.add(new GoblinAttack());
        dunesOfSunsear.add(new StaminaPotionMerchant());
        dunesOfSunsear.name = "Dunes of Sunsear";
        locationArray[69] = dunesOfSunsear;

        abandonedIronmine = new Location(9,6);
        abandonedIronmine.add(new BanditAttack());
        abandonedIronmine.add(new WolfAttack());
        abandonedIronmine.add(new OrcAttack());
        abandonedIronmine.add(new GoblinAttack());
        abandonedIronmine.add(new StaminaPotionMerchant());
        abandonedIronmine.name = "Abandoned Iron Mine";
        locationArray[70] = abandonedIronmine;




        cityThree = new Location(10,0);
        cityThree.add(new CryingChild());
        cityThree.name = "City Three";
        cityThree.isTown = true;
        locationArray[20] = cityThree;

        sirensCove = new Location(10,1);
        sirensCove.add(new BanditAttack());
        sirensCove.add(new WolfAttack());
        sirensCove.add(new StaminaPotionMerchant());
        sirensCove.add(new WoundedTraveler());
        sirensCove.name = "Siren's Cove";
        locationArray[21] = sirensCove;

        veridianTreeline = new Location(10,2);
        veridianTreeline.add(new BanditAttack());
        veridianTreeline.add(new WolfAttack());
        veridianTreeline.add(new WoundedTraveler());
        veridianTreeline.add(new StaminaPotionMerchant());
        veridianTreeline.name = "Veridian Treeline";
        locationArray[71] = veridianTreeline;

        sandleafBorder = new Location(10,3);
        sandleafBorder.add(new BanditAttack());
        sandleafBorder.add(new WolfAttack());
        sandleafBorder.add(new OrcAttack());
        sandleafBorder.add(new GoblinAttack());
        sandleafBorder.add(new StaminaPotionMerchant());
        sandleafBorder.name = "Sandleaf Border";
        locationArray[72] = sandleafBorder;

        barrenSandlands = new Location(10,4);
        barrenSandlands.add(new BanditAttack());
        barrenSandlands.add(new WolfAttack());
        barrenSandlands.add(new StaminaPotionMerchant());
        barrenSandlands.add(new OrcAttack());
        barrenSandlands.add(new GoblinAttack());
        barrenSandlands.name = "Barren Sandlands";
        locationArray[73] = barrenSandlands;

        sandwormFeedingGrounds = new Location(10,5);
        sandwormFeedingGrounds.add(new BanditAttack());
        sandwormFeedingGrounds.add(new WolfAttack());
        sandwormFeedingGrounds.add(new OrcAttack());
        sandwormFeedingGrounds.add(new GoblinAttack());
        sandwormFeedingGrounds.add(new StaminaPotionMerchant());
        sandwormFeedingGrounds.name = "Sandworm Feeding Grounds";
        locationArray[74] = sandwormFeedingGrounds;

        scorpionsPass = new Location(10,6);
        scorpionsPass.add(new BanditAttack());
        scorpionsPass.add(new WolfAttack());
        scorpionsPass.add(new OrcAttack());
        scorpionsPass.add(new GoblinAttack());
        scorpionsPass.add(new StaminaPotionMerchant());
        scorpionsPass.name = "Scorpion's Pass";
        locationArray[75] = scorpionsPass;









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