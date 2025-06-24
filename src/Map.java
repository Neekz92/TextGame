public class Map {

    GameEngine gameEngine;

    DragonToken dragonToken;

    static int tilesRemaining = 0;

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
    Location cactusPassing;
    Location shiverpeakForestSouth;
    Location shiverpeakForest;
    Location shiverpeakMountainsEast;
    Location vulturesHaven;
    Location leviCanyon;
    Location darkwoodClearing;
    Location zerasPath;
    Location heatstrokeHills;
    Location mirageCrossing;
    Location slopesOfSorrow;
    Location glacierRidge;
    Location parchedDrylands;
    Location camalsWay;
    Location ancientRuins;
    Location dreadsWay;
    Location freshwaterOasis;
    Location driedRiver;
    Location buriedMausoleum;
    Location scorchwyrmsLair;

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

        this.gameEngine = gameEngine;
        dragonToken = gameEngine.dragonToken;

        locationArray = new Location[121];  //  120

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
        southWestPlains.add(new WoundedAdventurer());
        southWestPlains.name = "South-West Plains";
        locationArray[1] = southWestPlains;

        westernPlains = new Location(0, 2);
        westernPlains.add(new WolfAttack());
        westernPlains.add(new BanditAttack());
        westernPlains.name = "Western Plains";
        westernPlains.add(new StaminaPotionMerchant());
        westernPlains.add(new WoundedTraveler());
        westernPlains.add(new WoundedAdventurer());
        locationArray[2] = westernPlains;

        rockyPlateau = new Location(0,3);
        rockyPlateau.add(new WolfAttack());
        rockyPlateau.add(new BanditAttack());
        rockyPlateau.add(new OrcAttack());
        rockyPlateau.add(new GoblinAttack());
        rockyPlateau.name = "Rocky Plateau";
        rockyPlateau.add(new StaminaPotionMerchant());
        locationArray[3] = rockyPlateau;

        stormpeakMountainsSouth = new Location(0,4);
        stormpeakMountainsSouth.add(new WolfAttack());
        stormpeakMountainsSouth.add(new BanditAttack());
        stormpeakMountainsSouth.add(new OrcAttack());
        stormpeakMountainsSouth.add(new GoblinAttack());
        stormpeakMountainsSouth.add(new StaminaPotionMerchant());
        stormpeakMountainsSouth.name = "Stormpeak Mountains (South)";
        locationArray[4] = stormpeakMountainsSouth;

        stormpeakMountainsSummit = new Location(0,5);
        stormpeakMountainsSummit.add(new AncientGiantMinibossTrigger());
        stormpeakMountainsSummit.name = "Stormpeak Mountain Summit";
        locationArray[5] = stormpeakMountainsSummit;

        stormpeakMountainsNorth = new Location(0,6);
        stormpeakMountainsNorth.add(new WolfAttack());
        stormpeakMountainsNorth.add(new BanditAttack());
        stormpeakMountainsNorth.add(new OrcAttack());
        stormpeakMountainsNorth.add(new GoblinAttack());
        stormpeakMountainsNorth.add(new StaminaPotionMerchant());
        stormpeakMountainsNorth.name = "Stormpeak Mountains (North)";
        locationArray[6] = stormpeakMountainsNorth;

        stormpeakTrail = new Location(0,7);
        stormpeakTrail.add(new WolfAttack());
        stormpeakTrail.add(new BanditAttack());
        stormpeakTrail.add(new OrcAttack());
        stormpeakTrail.add(new GoblinAttack());
        stormpeakTrail.add(new StaminaPotionMerchant());
        stormpeakTrail.name = "Stormpeak Trail";
        locationArray[7] = stormpeakTrail;

        frigidBirchwoods = new Location(0,8);
        frigidBirchwoods.add(new WolfAttack());
        frigidBirchwoods.add(new BanditAttack());
        frigidBirchwoods.add(new WoundedTraveler());
        frigidBirchwoods.add(new WoundedAdventurer());
        frigidBirchwoods.add(new StaminaPotionMerchant());
        frigidBirchwoods.name = "Frigid Birchwoods";
        locationArray[8] = frigidBirchwoods;

        frozenPath = new Location(0,9);
        frozenPath.add(new WolfAttack());
        frozenPath.add(new BanditAttack());
        frozenPath.add(new WoundedTraveler());
        frozenPath.add(new WoundedAdventurer());
        frozenPath.add(new StaminaPotionMerchant());
        frozenPath.name = "Frozen Path";
        locationArray[9] = frozenPath;

        cityTwo = new Location(0,10);
        cityTwo.add(new CryingChild());
        cityTwo.add(new MysteriousWizard());
        cityTwo.add(new JobBoardWolf());
        cityTwo.add(new JobBoardBandit());
        cityTwo.name = "City Two";
        locationArray[10] = cityTwo;
        cityTwo.isTown = true;



        bloodFlowerMeadows = new Location(1, 0);
        bloodFlowerMeadows.add(new WolfAttack());
        bloodFlowerMeadows.add(new BanditAttack());
        bloodFlowerMeadows.add(new StaminaPotionMerchant());
        bloodFlowerMeadows.add(new WoundedTraveler());
        bloodFlowerMeadows.name = "Bloodflower Meadows";
        locationArray[11] = bloodFlowerMeadows;

        greatneckReach = new Location(1,1);
        greatneckReach.add(new WolfAttack());
        greatneckReach.add(new BanditAttack());
        greatneckReach.add(new StaminaPotionMerchant());
        greatneckReach.add(new WoundedTraveler());
        greatneckReach.add(new WoundedAdventurer());
        greatneckReach.name = "Greatneck Reach";
        locationArray[12] = greatneckReach;

        crabgrassHills = new Location(1,2);
        crabgrassHills.add(new WolfAttack());
        crabgrassHills.add(new BanditAttack());
        crabgrassHills.add(new StaminaPotionMerchant());
        crabgrassHills.add(new WoundedAdventurer());
        crabgrassHills.add(new WoundedTraveler());
        crabgrassHills.name = "Crabgrass Hills";
        locationArray[13] = crabgrassHills;

        treesongStream = new Location(1,3);
        treesongStream.add(new WolfAttack());
        treesongStream.add(new BanditAttack());
        treesongStream.add(new OrcAttack());
        treesongStream.add(new GoblinAttack());
        treesongStream.add(new StaminaPotionMerchant());
        treesongStream.name = "Treesong Stream";
        locationArray[14] = treesongStream;

        stormpeakCliffs = new Location(1,4);
        stormpeakCliffs.add(new WolfAttack());
        stormpeakCliffs.add(new BanditAttack());
        stormpeakCliffs.add(new OrcAttack());
        stormpeakCliffs.add(new GoblinAttack());
        stormpeakCliffs.add(new StaminaPotionMerchant());
        stormpeakCliffs.name = "Stormpeak Cliffs";
        locationArray[15] = stormpeakCliffs;

        badlandsSteppe = new Location(1,5);
        badlandsSteppe.add(new WolfAttack());
        badlandsSteppe.add(new BanditAttack());
        badlandsSteppe.add(new OrcAttack());
        badlandsSteppe.add(new GoblinAttack());
        badlandsSteppe.add(new WyvernAttack());
        badlandsSteppe.add(new StaminaPotionMerchant());
        badlandsSteppe.name = "Badlands Steppe";
        locationArray[16] = badlandsSteppe;

        lakesideRest = new Location(1, 6);
        lakesideRest.add(new WolfAttack());
        lakesideRest.add(new BanditAttack());
        lakesideRest.add(new OrcAttack());
        lakesideRest.add(new GoblinAttack());
        lakesideRest.add(new StaminaPotionMerchant());
        lakesideRest.name = "Lakeside Rest";
        locationArray[17] = lakesideRest;

        bonechillWoods = new Location(1,7);
        bonechillWoods.add(new WolfAttack());
        bonechillWoods.add(new BanditAttack());
        bonechillWoods.add(new OrcAttack());
        bonechillWoods.add(new GoblinAttack());
        bonechillWoods.add(new StaminaPotionMerchant());
        bonechillWoods.name = "Bonechill Woods";
        locationArray[18] = bonechillWoods;

        thrashedCabin = new Location(1,8);
        thrashedCabin.add(new WolfAttack());
        thrashedCabin.add(new BanditAttack());
        thrashedCabin.add(new StaminaPotionMerchant());
        thrashedCabin.add(new WoundedAdventurer());
        thrashedCabin.add(new WoundedTraveler());
        thrashedCabin.name = "Thrashed Cabin";
        locationArray[19] = thrashedCabin;

        tepidTundra = new Location(1,9);
        tepidTundra.add(new WolfAttack());
        tepidTundra.add(new BanditAttack());
        tepidTundra.add(new StaminaPotionMerchant());
        tepidTundra.add(new WoundedTraveler());
        tepidTundra.add(new WoundedAdventurer());
        tepidTundra.name = "Tepid Tundra";
        locationArray[20] = tepidTundra;

        icyThreshold = new Location(1,10);
        icyThreshold.add(new WolfAttack());
        icyThreshold.add(new BanditAttack());
        icyThreshold.add(new WoundedTraveler());
        icyThreshold.add(new WoundedAdventurer());
        icyThreshold.add(new StaminaPotionMerchant());
        icyThreshold.name = "Icy Threshold";
        locationArray[21] = icyThreshold;





        kingsRiver = new Location(2,0);
        kingsRiver.add(new WolfAttack());
        kingsRiver.add(new BanditAttack());
        kingsRiver.add(new StaminaPotionMerchant());
        kingsRiver.add(new WoundedTraveler());
        kingsRiver.add(new WoundedAdventurer());
        kingsRiver.name = "King's River";
        locationArray[22] = kingsRiver;

        kingsRiverRapids = new Location(2,1);
        kingsRiverRapids.add(new WolfAttack());
        kingsRiverRapids.add(new BanditAttack());
        kingsRiverRapids.add(new StaminaPotionMerchant());
        kingsRiverRapids.add(new WoundedTraveler());
        kingsRiverRapids.add(new WoundedAdventurer());
        kingsRiverRapids.name = "King's River Rapids";
        locationArray[23] = kingsRiverRapids;

        kingsBasin = new Location(2,2);
        kingsBasin.add(new WolfAttack());
        kingsBasin.add(new BanditAttack());
        kingsBasin.add(new StaminaPotionMerchant());
        kingsBasin.add(new WoundedTraveler());
        kingsBasin.add(new WoundedAdventurer());
        kingsBasin.name = "King's Basin";
        locationArray[24] = kingsBasin;

        kingsFalls = new Location(2,3);
        kingsFalls.add(new WolfAttack());
        kingsFalls.add(new BanditAttack());
        kingsFalls.add(new OrcAttack());
        kingsFalls.add(new GoblinAttack());
        kingsFalls.name = "King's Falls";
        locationArray[25] = kingsFalls;

        ronkomasPull = new Location(2,4);
        ronkomasPull.add(new WolfAttack());
        ronkomasPull.add(new BanditAttack());
        ronkomasPull.add(new OrcAttack());
        ronkomasPull.add(new GoblinAttack());
        ronkomasPull.add(new StaminaPotionMerchant());
        ronkomasPull.name = "Ronkoma's Pull";
        locationArray[26] = ronkomasPull;

        ronkomasLakeWest = new Location(2,5);
        ronkomasLakeWest.add(new WolfAttack());
        ronkomasLakeWest.add(new BanditAttack());
        ronkomasLakeWest.add(new OrcAttack());
        ronkomasLakeWest.add(new GoblinAttack());
        ronkomasLakeWest.add(new WyvernAttack());
        ronkomasLakeWest.add(new StaminaPotionMerchant());
        ronkomasLakeWest.name = "Ronkoma's Lake (West)";
        locationArray[27] = ronkomasLakeWest;

        ronkomasThickBrush = new Location(2,6);
        ronkomasThickBrush.add(new WolfAttack());
        ronkomasThickBrush.add(new BanditAttack());
        ronkomasThickBrush.add(new OrcAttack());
        ronkomasThickBrush.add(new GoblinAttack());
        ronkomasThickBrush.add(new StaminaPotionMerchant());
        ronkomasThickBrush.name = "Ronkoma's Thickbrush";
        locationArray[28] = ronkomasThickBrush;

        veilOfFrost = new Location(2,7);
        veilOfFrost.add(new WolfAttack());
        veilOfFrost.add(new BanditAttack());
        veilOfFrost.add(new OrcAttack());
        veilOfFrost.add(new GoblinAttack());
        veilOfFrost.add(new StaminaPotionMerchant());
        veilOfFrost.name = "Veil of Frost";
        locationArray[29] = veilOfFrost;

        icicleWay = new Location(2,8);
        icicleWay.add(new WolfAttack());
        icicleWay.add(new BanditAttack());
        icicleWay.add(new WoundedTraveler());
        icicleWay.add(new WoundedAdventurer());
        icicleWay.add(new StaminaPotionMerchant());
        icicleWay.name = "Icicle Way";
        locationArray[30] = icicleWay;

        frozenPlateau = new Location(2,9);
        frozenPlateau.add(new WolfAttack());
        frozenPlateau.add(new BanditAttack());
        frozenPlateau.add(new StaminaPotionMerchant());
        frozenPlateau.add(new WoundedTraveler());
        frozenPlateau.add(new WoundedAdventurer());
        frozenPlateau.name = "Frozen Plateau";
        locationArray[31] = frozenPlateau;

        frostwolfBreedingGrounds = new Location(2,10);
        frostwolfBreedingGrounds.add(new WolfAttack());
        frostwolfBreedingGrounds.add(new BanditAttack());
        frostwolfBreedingGrounds.add(new StaminaPotionMerchant());
        frostwolfBreedingGrounds.add(new WoundedAdventurer());
        frostwolfBreedingGrounds.add(new WoundedTraveler());
        frostwolfBreedingGrounds.name = "Frostwolf Breeding Grounds";
        locationArray[32] = frostwolfBreedingGrounds;






        greentreeWoods = new Location(3,0);
        greentreeWoods.add(new BanditAttack());
        greentreeWoods.add(new WolfAttack());
        greentreeWoods.add(new OrcAttack());
        greentreeWoods.add(new GoblinAttack());
        greentreeWoods.add(new StaminaPotionMerchant());
        greentreeWoods.name = "Greentree Woods";
        locationArray[33] = greentreeWoods;

        whisperingGrove = new Location(3,1);
        whisperingGrove.add(new BanditAttack());
        whisperingGrove.add(new WolfAttack());
        whisperingGrove.add(new OrcAttack());
        whisperingGrove.add(new GoblinAttack());
        whisperingGrove.add(new StaminaPotionMerchant());
        whisperingGrove.name = "Whispering Grove";
        locationArray[34] = whisperingGrove;

        brutesWetlands = new Location(3,2);
        brutesWetlands.add(new BanditAttack());
        brutesWetlands.add(new WolfAttack());
        brutesWetlands.add(new OrcAttack());
        brutesWetlands.add(new GoblinAttack());
        brutesWetlands.add(new StaminaPotionMerchant());
        brutesWetlands.name = "Brute's Wetlands";
        locationArray[35] = brutesWetlands;

        blackMarsh = new Location(3,3);
        blackMarsh.add(new BanditAttack());
        blackMarsh.add(new WolfAttack());
        blackMarsh.add(new OrcAttack());
        blackMarsh.add(new GoblinAttack());
        blackMarsh.add(new StaminaPotionMerchant());
        blackMarsh.name = "Black Marsh";
        locationArray[36] = blackMarsh;

        ronkomasLakeSouth = new Location(3,4);
        ronkomasLakeSouth.add(new WolfAttack());
        ronkomasLakeSouth.add(new BanditAttack());
        ronkomasLakeSouth.add(new OrcAttack());
        ronkomasLakeSouth.add(new GoblinAttack());
        ronkomasLakeSouth.add(new StaminaPotionMerchant());
        ronkomasLakeSouth.name = "Ronkoma's Lake (South)";
        locationArray[37] = ronkomasLakeSouth;

        ronkomasLake = new Location(3,5);
        ronkomasLake.add(new WolfAttack());
        ronkomasLake.add(new BanditAttack());
        ronkomasLake.add(new OrcAttack());
        ronkomasLake.add(new GoblinAttack());
        ronkomasLake.add(new WyvernAttack());
        ronkomasLake.add(new StaminaPotionMerchant());
        ronkomasLake.name = "Ronkoma's Lake";
        locationArray[38] = ronkomasLake;

        ronkomasLakeNorth = new Location(3,6);
        ronkomasLakeNorth.add(new WolfAttack());
        ronkomasLakeNorth.add(new BanditAttack());
        ronkomasLakeNorth.add(new OrcAttack());
        ronkomasLakeNorth.add(new GoblinAttack());
        ronkomasLakeNorth.add(new StaminaPotionMerchant());
        ronkomasLakeNorth.name = "Ronkoma's Lake (North)";
        locationArray[39] = ronkomasLakeNorth;

        everwintersMouth = new Location(3,7);
        everwintersMouth.add(new WolfAttack());
        everwintersMouth.add(new BanditAttack());
        everwintersMouth.add(new OrcAttack());
        everwintersMouth.add(new GoblinAttack());
        everwintersMouth.add(new StaminaPotionMerchant());
        everwintersMouth.name = "Everwinter's Mouth";
        locationArray[40] = everwintersMouth;

        northernHighlands = new Location(3,8);
        northernHighlands.add(new WolfAttack());
        northernHighlands.add(new BanditAttack());
        northernHighlands.add(new StaminaPotionMerchant());
        northernHighlands.add(new OrcAttack());
        northernHighlands.add(new GoblinAttack());
        northernHighlands.name = "Northern Highlands";
        locationArray[41] = northernHighlands;

        kelvinsCave = new Location(3,9);
        kelvinsCave.add(new WolfAttack());
        kelvinsCave.add(new BanditAttack());
        kelvinsCave.add(new StaminaPotionMerchant());
        kelvinsCave.add(new OrcAttack());
        kelvinsCave.add(new GoblinAttack());
        kelvinsCave.name = "Kelvin's Cave";
        locationArray[42] = kelvinsCave;

        shiverpeakMountainsWest = new Location(3,10);
        shiverpeakMountainsWest.add(new WolfAttack());
        shiverpeakMountainsWest.add(new BanditAttack());
        shiverpeakMountainsWest.add(new OrcAttack());
        shiverpeakMountainsWest.add(new GoblinAttack());
        shiverpeakMountainsWest.add(new StaminaPotionMerchant());
        shiverpeakMountainsWest.name = "Shiverpeak Mountains (West)";
        locationArray[43] = shiverpeakMountainsWest;





        greentreeForest = new Location(4,0);
        greentreeForest.add(new BanditAttack());
        greentreeForest.add(new WolfAttack());
        greentreeForest.add(new OrcAttack());
        greentreeForest.add(new GoblinAttack());
        greentreeForest.add(new StaminaPotionMerchant());
        greentreeForest.name = "Greentree Forest";
        locationArray[44] = greentreeForest;

        abandonedOrchard = new Location(4,1);
        abandonedOrchard.add(new BanditAttack());
        abandonedOrchard.add(new WolfAttack());
        abandonedOrchard.add(new OrcAttack());
        abandonedOrchard.add(new GoblinAttack());
        abandonedOrchard.add(new StaminaPotionMerchant());
        abandonedOrchard.name = "Abandoned Orchard";
        locationArray[45] = abandonedOrchard;

        witchsHut = new Location(4,2);
        witchsHut.add(new BanditAttack());
        witchsHut.add(new WolfAttack());
        witchsHut.add(new OrcAttack());
        witchsHut.add(new GoblinAttack());
        witchsHut.add(new StaminaPotionMerchant());
        witchsHut.name = "Witch's Hut";
        locationArray[46] = witchsHut;

        slimewoodSwamp = new Location(4,3);
        slimewoodSwamp.add(new BanditAttack());
        slimewoodSwamp.add(new WolfAttack());
        slimewoodSwamp.add(new OrcAttack());
        slimewoodSwamp.add(new GoblinAttack());
        slimewoodSwamp.add(new StaminaPotionMerchant());
        slimewoodSwamp.name = "Slimewood Swamp";
        locationArray[47] = slimewoodSwamp;

        fishersPoint = new Location(4,4);
        fishersPoint.add(new BanditAttack());
        fishersPoint.add(new WolfAttack());
        fishersPoint.add(new OrcAttack());
        fishersPoint.add(new GoblinAttack());
        fishersPoint.add(new StaminaPotionMerchant());
        fishersPoint.name = "Fisher's Point";
        locationArray[48] = fishersPoint;

        ronkomasLakeEast = new Location(4,5);
        ronkomasLakeEast.add(new BanditAttack());
        ronkomasLakeEast.add(new WolfAttack());
        ronkomasLakeEast.add(new OrcAttack());
        ronkomasLakeEast.add(new GoblinAttack());
        ronkomasLakeEast.add(new WyvernAttack());
        ronkomasLakeEast.add(new StaminaPotionMerchant());
        ronkomasLakeEast.name = "Ronkoma's Lake (East)";
        locationArray[49] = ronkomasLakeEast;

        maidensGrave = new Location(4,6);
        maidensGrave.add(new BanditAttack());
        maidensGrave.add(new WolfAttack());
        maidensGrave.add(new OrcAttack());
        maidensGrave.add(new GoblinAttack());
        maidensGrave.add(new StaminaPotionMerchant());
        maidensGrave.name = "Maiden's Grave";
        locationArray[50] = maidensGrave;

        frostbiteTrail = new Location(4,7);
        frostbiteTrail.add(new BanditAttack());
        frostbiteTrail.add(new WolfAttack());
        frostbiteTrail.add(new OrcAttack());
        frostbiteTrail.add(new GoblinAttack());
        frostbiteTrail.add(new StaminaPotionMerchant());
        frostbiteTrail.name = "Frostbite Trail";
        locationArray[51] = frostbiteTrail;

        shiverpeakClimb = new Location(4,8);
        shiverpeakClimb.add(new WolfAttack());
        shiverpeakClimb.add(new BanditAttack());
        shiverpeakClimb.add(new OrcAttack());
        shiverpeakClimb.add(new GoblinAttack());
        shiverpeakClimb.add(new StaminaPotionMerchant());
        shiverpeakClimb.name = "Shiverpeak Climb";
        locationArray[52] = shiverpeakClimb;

        shiverpeakCliffs = new Location(4,9);
        shiverpeakCliffs.add(new WolfAttack());
        shiverpeakCliffs.add(new BanditAttack());
        shiverpeakCliffs.add(new OrcAttack());
        shiverpeakCliffs.add(new GoblinAttack());
        shiverpeakCliffs.add(new StaminaPotionMerchant());
        shiverpeakCliffs.name = "Shiverpeak Cliffs";
        locationArray[53] = shiverpeakCliffs;

        shiverpeakMountains = new Location(4,10);
        shiverpeakMountains.add(new WolfAttack());
        shiverpeakMountains.add(new BanditAttack());
        shiverpeakMountains.add(new OrcAttack());
        shiverpeakMountains.add(new GoblinAttack());
        shiverpeakMountains.add(new StaminaPotionMerchant());
        shiverpeakMountains.name = "Shiverpeak Mountains";
        locationArray[54] = shiverpeakMountains;






        templeOfLeaves = new Location(5,0);
        templeOfLeaves.add(new AncientTreeEntMinibossTrigger());
        templeOfLeaves.name = "Temple of Leaves";
        locationArray[55] = templeOfLeaves;

        rainyGrasslands = new Location(5,1);
        rainyGrasslands.add(new BanditAttack());
        rainyGrasslands.add(new WolfAttack());
        rainyGrasslands.add(new OrcAttack());
        rainyGrasslands.add(new GoblinAttack());
        rainyGrasslands.add(new WyvernAttack());
        rainyGrasslands.add(new StaminaPotionMerchant());
        rainyGrasslands.name = "Rainy Grasslands";
        locationArray[56] = rainyGrasslands;

        sinksoilMoor = new Location(5,2);
        sinksoilMoor.add(new WolfAttack());
        sinksoilMoor.add(new BanditAttack());
        sinksoilMoor.add(new OrcAttack());
        sinksoilMoor.add(new GoblinAttack());
        sinksoilMoor.add(new WyvernAttack());
        sinksoilMoor.add(new StaminaPotionMerchant());
        sinksoilMoor.name = "Sinksoil Moor";
        locationArray[57] = sinksoilMoor;

        hagBog = new Location(5,3);
        hagBog.add(new WolfAttack());
        hagBog.add(new BanditAttack());
        hagBog.add(new OrcAttack());
        hagBog.add(new GoblinAttack());
        hagBog.add(new WyvernAttack());
        hagBog.add(new StaminaPotionMerchant());
        hagBog.name = "Hag Bog";
        locationArray[58] = hagBog;

        rollingRivermouth = new Location(5,4);
        rollingRivermouth.add(new WolfAttack());
        rollingRivermouth.add(new BanditAttack());
        rollingRivermouth.add(new OrcAttack());
        rollingRivermouth.add(new GoblinAttack());
        rollingRivermouth.add(new WyvernAttack());
        rollingRivermouth.add(new StaminaPotionMerchant());
        rollingRivermouth.name = "Rolling Rivermouth";
        locationArray[59] = rollingRivermouth;

        cavernOfCadavers = new Location(5,5);
        cavernOfCadavers.add(new AncientCavernMinibossTrigger());
        cavernOfCadavers.name = "Cavern of Cadavers";
        locationArray[60] = cavernOfCadavers;

        frostleafBrush = new Location(5,6);
        frostleafBrush.add(new OrcAttack());
        frostleafBrush.add(new GoblinAttack());
        frostleafBrush.add(new WyvernAttack());
        frostleafBrush.name = "Frostleaf Brush";
        locationArray[61] = frostleafBrush;

        wintersEdge = new Location(5,7);
        wintersEdge.add(new OrcAttack());
        wintersEdge.add(new GoblinAttack());
        wintersEdge.add(new WyvernAttack());
        wintersEdge.name = "Winter's Edge";
        locationArray[62] = wintersEdge;

        softsnowWoods = new Location(5,8);
        softsnowWoods.add(new OrcAttack());
        softsnowWoods.add(new GoblinAttack());
        softsnowWoods.add(new WyvernAttack());
        softsnowWoods.name = "Softsnow Woods";
        locationArray[63] = softsnowWoods;

        avalanchPath = new Location(5,9);
        avalanchPath.add(new OrcAttack());
        avalanchPath.add(new GoblinAttack());
        avalanchPath.add(new WyvernAttack());
        avalanchPath.name = "Avalanche Path";
        locationArray[64] = avalanchPath;

        shiverpeakMountainSummit = new Location(5,10);
        shiverpeakMountainSummit.add(new OrcAttack());
        shiverpeakMountainSummit.add(new GoblinAttack());
        shiverpeakMountainSummit.add(new WyvernAttack());
        shiverpeakMountainSummit.name = "Shiverpeak Mountain Summit";
        locationArray[65] = shiverpeakMountainSummit;






        woodsOfSilence = new Location(6,0);
        woodsOfSilence.add(new BanditAttack());
        woodsOfSilence.add(new WolfAttack());
        woodsOfSilence.add(new OrcAttack());
        woodsOfSilence.add(new GoblinAttack());
        woodsOfSilence.add(new StaminaPotionMerchant());
        woodsOfSilence.name = "Woods of Silence";
        locationArray[66] = woodsOfSilence;

        duskmereHollow = new Location(6,1);
        duskmereHollow.add(new BanditAttack());
        duskmereHollow.add(new WolfAttack());
        duskmereHollow.add(new OrcAttack());
        duskmereHollow.add(new GoblinAttack());
        duskmereHollow.add(new StaminaPotionMerchant());
        duskmereHollow.name = "Duskmere Hollow";
        locationArray[67] = duskmereHollow;

        fieldsOfClover = new Location(6,2);
        fieldsOfClover.add(new BanditAttack());
        fieldsOfClover.add(new WolfAttack());
        fieldsOfClover.add(new OrcAttack());
        fieldsOfClover.add(new GoblinAttack());
        fieldsOfClover.add(new StaminaPotionMerchant());
        fieldsOfClover.name = "Fields of Clover";
        locationArray[68] = fieldsOfClover;

        wildfishCrossing = new Location(6,3);
        wildfishCrossing.add(new BanditAttack());
        wildfishCrossing.add(new WolfAttack());
        wildfishCrossing.add(new OrcAttack());
        wildfishCrossing.add(new GoblinAttack());
        wildfishCrossing.add(new StaminaPotionMerchant());
        wildfishCrossing.name = "Wildfish Crossing";
        locationArray[69] = wildfishCrossing;

        ronkomasWhiteWaters = new Location(6,4);
        ronkomasWhiteWaters.add(new BanditAttack());
        ronkomasWhiteWaters.add(new WolfAttack());
        ronkomasWhiteWaters.add(new OrcAttack());
        ronkomasWhiteWaters.add(new GoblinAttack());
        ronkomasWhiteWaters.add(new StaminaPotionMerchant());
        ronkomasWhiteWaters.name = "Ronkoma's White Waters";
        locationArray[70] = ronkomasWhiteWaters;

        cavesOfTermina = new Location(6,5);
        cavesOfTermina.add(new OrcAttack());
        cavesOfTermina.add(new GoblinAttack());
        cavesOfTermina.add(new WyvernAttack());
        cavesOfTermina.name = "Caves of Termina";
        locationArray[71] = cavesOfTermina;

        smashstoneWastes = new Location(6,6);
        smashstoneWastes.add(new OrcAttack());
        smashstoneWastes.add(new GoblinAttack());
        smashstoneWastes.add(new WyvernAttack());
        smashstoneWastes.name = "Smashstone Wastes";
        locationArray[72] = smashstoneWastes;

        cactusPassing = new Location(6,7);
        cactusPassing.add(new OrcAttack());
        cactusPassing.add(new GoblinAttack());
        cactusPassing.add(new WyvernAttack());
        cactusPassing.name = "Cactus Passing";
        locationArray[73] = cactusPassing;

        shiverpeakForestSouth = new Location(6,8);
        shiverpeakForestSouth.add(new OrcAttack());
        shiverpeakForestSouth.add(new GoblinAttack());
        shiverpeakForestSouth.add(new WyvernAttack());
        shiverpeakForestSouth.name = "Shiverpeak Forest (South)";
        locationArray[74] = shiverpeakForestSouth;

        shiverpeakForest = new Location(6,9);
        shiverpeakForest.add(new OrcAttack());
        shiverpeakForest.add(new GoblinAttack());
        shiverpeakForest.add(new WyvernAttack());
        shiverpeakForest.name = "Shiverpeak Forest";
        locationArray[75] = shiverpeakForest;

        shiverpeakMountainsEast = new Location(6,10);
        shiverpeakMountainsEast.add(new OrcAttack());
        shiverpeakMountainsEast.add(new BanditAttack());
        shiverpeakMountainsEast.add(new WyvernAttack());
        shiverpeakMountainsEast.name = "Shiverpeak Mountains (East)";
        locationArray[76] = shiverpeakMountainsEast;



        southShore = new Location(7,0);
        southShore.add(new BanditAttack());
        southShore.add(new WolfAttack());
        southShore.add(new OrcAttack());
        southShore.add(new GoblinAttack());
        southShore.add(new StaminaPotionMerchant());
        southShore.name = "Southern Shore";
        locationArray[77] = southShore;

        seaviewClearing = new Location(7,1);
        seaviewClearing.add(new BanditAttack());
        seaviewClearing.add(new WolfAttack());
        seaviewClearing.add(new OrcAttack());
        seaviewClearing.add(new GoblinAttack());
        seaviewClearing.add(new StaminaPotionMerchant());
        seaviewClearing.name = "Seaview Clearing";
        locationArray[78] = seaviewClearing;

        tidebranchFlow = new Location(7,2);
        tidebranchFlow.add(new BanditAttack());
        tidebranchFlow.add(new WolfAttack());
        tidebranchFlow.add(new OrcAttack());
        tidebranchFlow.add(new GoblinAttack());
        tidebranchFlow.add(new StaminaPotionMerchant());
        tidebranchFlow.name = "Tidebranch Flow";
        locationArray[79] = tidebranchFlow;

        slipperyStepstones = new Location(7,3);
        slipperyStepstones.add(new BanditAttack());
        slipperyStepstones.add(new WolfAttack());
        slipperyStepstones.add(new OrcAttack());
        slipperyStepstones.add(new GoblinAttack());
        slipperyStepstones.add(new StaminaPotionMerchant());
        slipperyStepstones.name = "Slippery Stepstones";
        locationArray[80] = slipperyStepstones;

        knicksTriangle = new Location(7,4);
        knicksTriangle.add(new BanditAttack());
        knicksTriangle.add(new WolfAttack());
        knicksTriangle.add(new OrcAttack());
        knicksTriangle.add(new GoblinAttack());
        knicksTriangle.add(new StaminaPotionMerchant());
        knicksTriangle.name = "Knick's Triangle";
        locationArray[81] = knicksTriangle;

        valensBurialGrounds = new Location(7,5);
        valensBurialGrounds.add(new OrcAttack());
        valensBurialGrounds.add(new GoblinAttack());
        valensBurialGrounds.add(new WyvernAttack());
        valensBurialGrounds.name = "Valen's Burial Grounds";
        locationArray[82] = valensBurialGrounds;

        sunfireRidge = new Location(7,6);
        sunfireRidge.add(new OrcAttack());
        sunfireRidge.add(new GoblinAttack());
        sunfireRidge.add(new WyvernAttack());
        sunfireRidge.name = "Sunfire Ridge";
        locationArray[83] = sunfireRidge;

        vulturesHaven = new Location(7,7);
        vulturesHaven.add(new OrcAttack());
        vulturesHaven.add(new GoblinAttack());
        vulturesHaven.add(new WyvernAttack());
        vulturesHaven.name = "Vulture's Haven";
        locationArray[84] = vulturesHaven;

        leviCanyon = new Location(7,8);
        leviCanyon.add(new OrcAttack());
        leviCanyon.add(new GoblinAttack());
        leviCanyon.add(new WyvernAttack());
        leviCanyon.name = "Levi Canyon";
        locationArray[85] = leviCanyon;

        darkwoodClearing = new Location(7,9);
        darkwoodClearing.add(new OrcAttack());
        darkwoodClearing.add(new GoblinAttack());
        darkwoodClearing.add(new WyvernAttack());
        darkwoodClearing.name = "Darkwood Clearing";
        locationArray[86] = darkwoodClearing;

        zerasPath = new Location(7,10);
        zerasPath.add(new GoblinAttack());
        zerasPath.add(new OrcAttack());
        zerasPath.add(new WyvernAttack());
        zerasPath.name = "Zera's Path";
        locationArray[87] = zerasPath;




        bastardsBay = new Location(8,0);
        bastardsBay.add(new BanditAttack());
        bastardsBay.add(new WolfAttack());
        bastardsBay.add(new StaminaPotionMerchant());
        bastardsBay.add(new WoundedTraveler());
        bastardsBay.add(new WoundedAdventurer());
        bastardsBay.name = "Bastard's Bay";
        locationArray[88] = bastardsBay;

        bastardsBridge = new Location(8,1);
        bastardsBridge.add(new BanditAttack());
        bastardsBridge.add(new WolfAttack());
        bastardsBridge.add(new WoundedTraveler());
        bastardsBridge.add(new WoundedAdventurer());
        bastardsBridge.add(new StaminaPotionMerchant());
        bastardsBridge.name = "Bastard's Bridge";
        locationArray[89] = bastardsBridge;

        brinepassWaters = new Location(8,2);
        brinepassWaters.add(new BanditAttack());
        brinepassWaters.add(new WolfAttack());
        brinepassWaters.add(new WoundedTraveler());
        brinepassWaters.add(new WoundedAdventurer());
        brinepassWaters.add(new StaminaPotionMerchant());
        brinepassWaters.name = "Brinepass Waters";
        locationArray[90] = brinepassWaters;

        deerlingSanctuary = new Location(8,3);
        deerlingSanctuary.add(new BanditAttack());
        deerlingSanctuary.add(new WolfAttack());
        deerlingSanctuary.add(new OrcAttack());
        deerlingSanctuary.add(new GoblinAttack());
        deerlingSanctuary.add(new StaminaPotionMerchant());
        deerlingSanctuary.name = "Deerling Sanctuary";
        locationArray[91] = deerlingSanctuary;

        deadleafSticks = new Location(8,4);
        deadleafSticks.add(new BanditAttack());
        deadleafSticks.add(new WolfAttack());
        deadleafSticks.add(new OrcAttack());
        deadleafSticks.add(new GoblinAttack());
        deadleafSticks.add(new StaminaPotionMerchant());
        deadleafSticks.name = "Deadleaf Sticks";
        locationArray[92] = deadleafSticks;

        sandyHills = new Location(8,5);
        sandyHills.add(new OrcAttack());
        sandyHills.add(new GoblinAttack());
        sandyHills.add(new WyvernAttack());
        sandyHills.name = "Sandy Hills";
        locationArray[93] = sandyHills;

        bonemanOutpost = new Location(8,6);
        bonemanOutpost.add(new OrcAttack());
        bonemanOutpost.add(new GoblinAttack());
        bonemanOutpost.add(new WyvernAttack());
        bonemanOutpost.name = "Boneman's Outpost";
        locationArray[94] = bonemanOutpost;

        heatstrokeHills = new Location(8,7);
        heatstrokeHills.add(new OrcAttack());
        heatstrokeHills.add(new GoblinAttack());
        heatstrokeHills.add(new WyvernAttack());
        heatstrokeHills.name = "Heatstroke Hills";
        locationArray[95] = heatstrokeHills;

        mirageCrossing = new Location(8,8);
        mirageCrossing.add(new OrcAttack());
        mirageCrossing.add(new GoblinAttack());
        mirageCrossing.add(new WyvernAttack());
        mirageCrossing.name = "Mirage Crossing";
        locationArray[96] = mirageCrossing;

        slopesOfSorrow = new Location(8,9);
        slopesOfSorrow.add(new GoblinAttack());
        slopesOfSorrow.add(new OrcAttack());
        slopesOfSorrow.add(new WyvernAttack());
        slopesOfSorrow.name = "Slopes of Sorrow";
        locationArray[97] = slopesOfSorrow;

        glacierRidge = new Location(8,10);
        glacierRidge.add(new OrcAttack());
        glacierRidge.add(new GoblinAttack());
        glacierRidge.add(new WyvernAttack());
        glacierRidge.name = "Glacier Ridge";
        locationArray[98] = glacierRidge;




        lutewardPort = new Location(9,0);
        lutewardPort.add(new BanditAttack());
        lutewardPort.add(new WolfAttack());
        lutewardPort.add(new StaminaPotionMerchant());
        lutewardPort.add(new WoundedAdventurer());
        lutewardPort.add(new WoundedTraveler());
        lutewardPort.name = "Luteward Port";
        locationArray[99] = lutewardPort;

        drowngrassShore = new Location(9,1);
        drowngrassShore.add(new BanditAttack());
        drowngrassShore.add(new WolfAttack());
        drowngrassShore.add(new WoundedTraveler());
        drowngrassShore.add(new WoundedAdventurer());
        drowngrassShore.add(new StaminaPotionMerchant());
        drowngrassShore.name = "Drowngrass Shore";
        locationArray[100] = drowngrassShore;

        pixiesSticks = new Location(9,2);
        pixiesSticks.add(new BanditAttack());
        pixiesSticks.add(new WolfAttack());
        pixiesSticks.add(new StaminaPotionMerchant());
        pixiesSticks.add(new WoundedAdventurer());
        pixiesSticks.add(new WoundedTraveler());
        pixiesSticks.name = "Pixie's Sticks";
        locationArray[101] = pixiesSticks;

        spritesGathering = new Location(9,3);
        spritesGathering.add(new BanditAttack());
        spritesGathering.add(new WolfAttack());
        spritesGathering.add(new OrcAttack());
        spritesGathering.add(new GoblinAttack());
        spritesGathering.add(new StaminaPotionMerchant());
        spritesGathering.name = "Sprite's Gathering";
        locationArray[102] = spritesGathering;

        rockyWasteland = new Location(9,4);
        rockyWasteland.add(new BanditAttack());
        rockyWasteland.add(new WolfAttack());
        rockyWasteland.add(new OrcAttack());
        rockyWasteland.add(new GoblinAttack());
        rockyWasteland.add(new StaminaPotionMerchant());
        rockyWasteland.name = "Rocky Wasteland";
        locationArray[103] = rockyWasteland;

        dunesOfSunsear = new Location(9,5);
        dunesOfSunsear.add(new OrcAttack());
        dunesOfSunsear.add(new GoblinAttack());
        dunesOfSunsear.add(new WyvernAttack());
        dunesOfSunsear.name = "Dunes of Sunsear";
        locationArray[104] = dunesOfSunsear;

        abandonedIronmine = new Location(9,6);
        abandonedIronmine.add(new OrcAttack());
        abandonedIronmine.add(new GoblinAttack());
        abandonedIronmine.add(new WyvernAttack());
        abandonedIronmine.name = "Abandoned Iron Mine";
        locationArray[105] = abandonedIronmine;

        parchedDrylands = new Location(9,7);
        parchedDrylands.add(new OrcAttack());
        parchedDrylands.add(new GoblinAttack());
        parchedDrylands.add(new WyvernAttack());
        parchedDrylands.name = "Parched Drylands";
        locationArray[106] = parchedDrylands;

        camalsWay = new Location(9,8);
        camalsWay.add(new OrcAttack());
        camalsWay.add(new GoblinAttack());
        camalsWay.add(new WyvernAttack());
        camalsWay.name = "Camal's Way";
        locationArray[107] = camalsWay;

        ancientRuins = new Location(9,9);
        ancientRuins.add(new OrcAttack());
        ancientRuins.add(new GoblinAttack());
        ancientRuins.add(new WyvernAttack());
        ancientRuins.name = "Ancient Ruins";
        locationArray[108] = ancientRuins;

        dreadsWay = new Location(9,10);
        dreadsWay.add(new OrcAttack());
        dreadsWay.add(new GoblinAttack());
        dreadsWay.add(new WyvernAttack());
        dreadsWay.name = "Dread's Way";
        locationArray[109] = dreadsWay;



        cityThree = new Location(10,0);
        cityThree.add(new CryingChild());
        cityThree.name = "City Three";
        cityThree.isTown = true;
        locationArray[110] = cityThree;

        sirensCove = new Location(10,1);
        sirensCove.add(new BanditAttack());
        sirensCove.add(new WolfAttack());
        sirensCove.add(new StaminaPotionMerchant());
        sirensCove.add(new WoundedTraveler());
        sirensCove.add(new WoundedAdventurer());
        sirensCove.name = "Siren's Cove";
        locationArray[111] = sirensCove;

        veridianTreeline = new Location(10,2);
        veridianTreeline.add(new BanditAttack());
        veridianTreeline.add(new WolfAttack());
        veridianTreeline.add(new WoundedTraveler());
        veridianTreeline.add(new WoundedAdventurer());
        veridianTreeline.add(new StaminaPotionMerchant());
        veridianTreeline.name = "Veridian Treeline";
        locationArray[112] = veridianTreeline;

        sandleafBorder = new Location(10,3);
        sandleafBorder.add(new BanditAttack());
        sandleafBorder.add(new WolfAttack());
        sandleafBorder.add(new OrcAttack());
        sandleafBorder.add(new GoblinAttack());
        sandleafBorder.add(new StaminaPotionMerchant());
        sandleafBorder.name = "Sandleaf Border";
        locationArray[113] = sandleafBorder;

        barrenSandlands = new Location(10,4);
        barrenSandlands.add(new BanditAttack());
        barrenSandlands.add(new WolfAttack());
        barrenSandlands.add(new StaminaPotionMerchant());
        barrenSandlands.add(new OrcAttack());
        barrenSandlands.add(new GoblinAttack());
        barrenSandlands.name = "Barren Sandlands";
        locationArray[114] = barrenSandlands;

        sandwormFeedingGrounds = new Location(10,5);
        sandwormFeedingGrounds.add(new OrcAttack());
        sandwormFeedingGrounds.add(new GoblinAttack());
        sandwormFeedingGrounds.add(new WyvernAttack());
        sandwormFeedingGrounds.name = "Sandworm Feeding Grounds";
        locationArray[115] = sandwormFeedingGrounds;

        scorpionsPass = new Location(10,6);
        scorpionsPass.add(new OrcAttack());
        scorpionsPass.add(new GoblinAttack());
        scorpionsPass.add(new WyvernAttack());
        scorpionsPass.name = "Scorpion's Pass";
        locationArray[116] = scorpionsPass;

        freshwaterOasis = new Location(10,7);
        freshwaterOasis.add(new OrcAttack());
        freshwaterOasis.add(new GoblinAttack());
        freshwaterOasis.add(new WyvernAttack());
        freshwaterOasis.name = "Freshwater Oasis";
        locationArray[117] = freshwaterOasis;

        driedRiver = new Location(10,8);
        driedRiver.add(new OrcAttack());
        driedRiver.add(new GoblinAttack());
        driedRiver.add(new WyvernAttack());
        driedRiver.name = "Dried River";
        locationArray[118] = driedRiver;

        buriedMausoleum = new Location(10,9);
        buriedMausoleum.add(new OrcAttack());
        buriedMausoleum.add(new GoblinAttack());
        buriedMausoleum.add(new WyvernAttack());
        buriedMausoleum.name = "Buried Mausoleum";
        locationArray[119] = buriedMausoleum;

        scorchwyrmsLair = new Location(10,10);
        scorchwyrmsLair.add(new AncientBabyDragonMinibossTrigger());
        scorchwyrmsLair.name = "Scorchwyrm's Lair";
        locationArray[120] = scorchwyrmsLair;
    }

    public void scorchLocation() {

        for (int i = 0; i < locationArray.length; i++) {
            dragonToken.location = findLocation(dragonToken.x, dragonToken.y);
            if (dragonToken.x == locationArray[i].x && dragonToken.y == locationArray[i].y && (!dragonToken.location.isScorched)) {
                locationArray[i].scorchTile();
                Map.tilesRemaining ++;
            }
        }
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