import java.util.Random;
import java.util.Scanner;

public class Player {

    Item selectedItem;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    GameEngine gameEngine;
    Player targetedEnemy;  //  targetSelect() sets this variable to the enemy the player is targeting, and this variable is used in rollAttack()
    boolean isAlive = true;

    int amountOfItems;
    Inventory inventory;

    Armor defaultArmor = new Armor();
    Armor armor = defaultArmor;

    Item weapon = new Item();

    Item[] inventory2 = new Item[amountOfItems];

    protected String name;
    String originalName;
    String statusName;
    int currentHp;
    private int positionX;
    private int positionY;
    private int gold = 5;
    private int xp;
    int chosenStat = 0;
    String chosenStatName = "";


    int attack;
    boolean usedIgniteArrows;
    int attackSkillBuff;
    int finalAttack;

    int defense;
    boolean usedTaunt;
    int defenseSkillBuff;
    int finalDefense;

    int luck;
    int finalLuck;

    int hp;
    int finalHp;

    int stamina = 5;
    int maxStamina = 5;


    private Location location;
    Encounter encounter;
    boolean hasEncounter = false;
    boolean isStunned = false;
    int stunTimer = 0;
    int hasteTimer = 0;
    boolean didASocialEncounterThisturn = false;

    boolean parryStance = false;  //  This is responsible for the Warrior's perfectParry() logic

    String quest = "No Quest";
    int wolvesToKill;
    int banditsToKill;

    int orcsToKill;
    int goblinsToKill;

    int wyvernsToKill;

    int enemyTargetingIndex = 0;
    Player[] enemyAITargetArray = new Player[enemyTargetingIndex];

    int tauntDuplicates = 0;
    int amountOfTimesDisplayed;

    int igniteArrowsTurnsRemaining = 0;

    int allowedBossToSpawn = 0;


    public Player(GameEngine gameEngine, String name) {
        this.gameEngine = gameEngine;
        this.name = name;
        this.location = gameEngine.map.findLocation(getX(), getY());
        this.xp = 15;
        updateStats();
    }

    public Player(GameEngine gameEngine) {
        this(gameEngine, "Default");
    }

    public void updateStats() {

        finalAttack = attack + armor.attack + weapon.attack;
        finalDefense = defense + armor.defense + weapon.defense;
        finalLuck = luck + armor.luck + weapon.luck;
        finalHp = hp + armor.hp + weapon.hp;

        adjustHp();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int amount) {
        hp = amount;
    }

    public int getX() {
        return positionX;
    }

    public void setX(int x) {
        positionX = x;
    }

    public int getY() {
        return positionY;
    }

    public void setY(int y) {
        positionY = y;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public Location getLocation() {
        return location;
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    public void movementPhaseOptions() {

        System.out.println("(" + location.x + "," + location.y + ")");
        System.out.println("*** Movement Phase ***");
        System.out.println("What do you do?");
        System.out.println("[ 1 ] Travel North");
        System.out.println("[ 2 ] Travel East");
        System.out.println("[ 3 ] Travel South");
        System.out.println("[ 4 ] Travel West");
        System.out.println("[ 5 ] Stay here");
        System.out.println("[ 6 ] Display Stats");
        System.out.println("[ 7 ] Spend XP");
        System.out.println("[ 8 ] Inventory");
        System.out.println("[ 9 ] Show Party Locations");
        System.out.println("[ 10 ] Show \"Map\" lol");
    }

    public void movementPhase() {

            if (Math.abs(gameEngine.dragonToken.x - positionX) <= 2 && Math.abs(gameEngine.dragonToken.y - positionY) <= 2) {
                System.out.println("You hear the flapping of large wings, and a ferocious roar in the distance. A terrible sense of fear overwhelms you for a moment.");
            }

        boolean movementPhase = true;

        while (movementPhase) {
            movementPhaseOptions();
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input == 1 && getY() < 10) {
                    setY(getY() + 1);
                    movementPhase = false;
                    System.out.println(this + " moved North. New map position is: (" + getX() + "," + getY() + ")");
                    break;
                }
                else if (input == 1 && getY() >= 10) {
                    System.out.println("You can't go any further North.");
                }
                else if (input == 2 && getX() < 10) {
                    setX(getX() + 1);
                    movementPhase = false;
                    System.out.println(this + " moved East. New map position is: (" + getX() + "," + getY() + ")");
                    break;
                }
                else if (input == 2 && getX() >= 10) {
                    System.out.println("You can't go any further East.");
                }
                else if (input == 3 && getY() > 0) {
                    setY(getY() - 1);
                    movementPhase = false;
                    System.out.println(this + " moved South. New map position is: (" + getX() + "," + getY() + ")");
                    break;
                } else if (input == 3 && getY() <= 0) {
                    System.out.println("You can't go any further south.");
                } else if (input == 4 && getX() > 0) {
                    setX(getX() - 1);
                    movementPhase = false;
                    System.out.println(this + " moved West. New map position is: (" + getX() + "," + getY() + ")");
                    break;
                } else if (input == 4 && getX() <= 0) {
                    System.out.println("You can't go any further West.");
                } else if (input == 5) {
                    movementPhase = false;
                    System.out.println("I must not yet leave. My business is left unfinished");
                    break;
                } else if (input == 6) {
                    updateStats();
                    displayStats();
                } else if (input == 7) {
                    if (youHaveXpToSpend()) {  //  Only allow player to enter the Upgrade Stat menu if they have XP
                        spendXp();
                    }
                } else if (input == 8) {
                    inventory.openInventory();
                }
                else if (input == 9) {
                    showPartyLocations();
                }
                else if (input == 10) {
                    map();
                }
                else {
                    System.out.println("Invalid option. DEBUG: player.movementPhase() input is an int, but not 1-8");
                }
            }
            catch (Exception e) {
                System.out.println("Invalid option. DEBUG: this is from the catch (Exception) block " + e);
                scanner.nextLine();
            }
        }
    }

    public void showPartyLocations() {

        for (int i = 0; i < gameEngine.playerArray.length; i++) {
            if (!(gameEngine.playerArray[i] instanceof Enemy)) {
                Player currentPlayer = gameEngine.playerArray[i];
                System.out.println(currentPlayer + " | Location: " + currentPlayer.getLocation() + " (" + currentPlayer.getX() + "," + currentPlayer.getY() + ")");
            }
        }
        System.out.println("");
    }

    public void map() {

        System.out.println("");
        for (int i = 0; i < gameEngine.amountOfCharacters; i++) {
            if (!(gameEngine.playerArray[i] instanceof Enemy)) {
                System.out.println("[ " + (i + 1) + " ] " + gameEngine.playerArray[i] + " | HP: " + gameEngine.playerArray[i].currentHp + " | Engaged in Battle: " + gameEngine.playerArray[i].hasEncounter);
            }
        }

        for (int i = 10; i >= 0; i--) {
            System.out.println("");
            for (int j = 0; j < 11; j++) {

                boolean hasPlayer = false;
                int poop = 0;
                for (int n = 0; n < gameEngine.amountOfCharacters; n++) {
                    poop = n;
                    if (gameEngine.playerArray[n].getX() == j && gameEngine.playerArray[n].getY() == i) {
                        hasPlayer = true;
                        break;
                    }
                }

                if (hasPlayer == false) {
                    if (gameEngine.map.findLocation(j, i).revealedScorch == true) {
                        System.out.print("X  ");
                    }
                    else {
                        System.out.print("■  ");
                    }
                }
                else {
                    System.out.print((poop + 1) + "  " );
                }
            }
        }
        System.out.println("");
        System.out.println("");
    }

    public boolean youHaveXpToSpend() {

        if (xp <= 0) {
            System.out.println("You have no XP to spend.");
            return false;
        }
        return true;
    }

    public void spendXp() {

        boolean chooseStat = true;
        while (chooseStat) {

            if (!youHaveXpToSpend()) {
                return;
            }

            displayStats();

            System.out.println("You have " + xp + " XP to spend. Choose a stat to upgrade.");
            System.out.println("[ 1 ] Attack");
            System.out.println("[ 2 ] Defense");
            System.out.println("[ 3 ] Luck");
            System.out.println("[ 4 ] Max HP");
            System.out.println("[ 0 ] Exit");

            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {  //  If the user selects 1 - the targeted stat that is upgraded gets set. The string gets set to let the user know in the next step.
                case 1: chosenStat = attack; chosenStatName = "Attack"; chooseStat = false; upgradeStat(); break;
                case 2: chosenStat = defense; chosenStatName = "Defense"; chooseStat = false; upgradeStat(); break;
                case 3: chosenStat = luck; chosenStatName = "Luck"; chooseStat = false; upgradeStat(); break;
                case 4: chosenStat = hp; chosenStatName = "Max HP"; chooseStat = false; upgradeStat(); break;
                case 0: chooseStat = false; return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    public void upgradeStat() {

        boolean inputAmountOfStatPoints = true;
        while (inputAmountOfStatPoints) {
            System.out.println(xp + " XP available. How much XP are you putting into " + chosenStatName + "?");

            int input = scanner.nextInt();
            scanner.nextLine();

            if (input > xp) {
                System.out.println("You don't have that much XP.");
                inputAmountOfStatPoints = false;
                spendXp();
            }
            else {
                chosenStat += input;

                switch (chosenStatName) {
                    case "Attack": attack = chosenStat; break;
                    case "Defense": defense = chosenStat; break;
                    case "Luck": luck = chosenStat; break;
                    case "Max HP": hp = chosenStat; break;
                }
                updateStats();
                System.out.println("You upgraded your " + chosenStatName + " by " + input + " points! Your " + chosenStatName + " is now " + chosenStat);
                xp -= input;
                inputAmountOfStatPoints = false;
                spendXp();

            }
        }
    }

    public int rollLuck() {
        int rng = random.nextInt(1,21);

        if (rng + (finalLuck / 5) > 10) {
            System.out.println("Success! Rolled a " + rng + " + " + (finalLuck / 5));
            return rng;
        }
        else {
            System.out.println("Failure! Rolled a " + rng + " + " + (finalLuck / 5));
            return rng;
        }
    }

    public int rollAttack() {

        int rng = random.nextInt(1,21);

        return rng;
    }

    public void deathCheck() {

        Encounter cachedEncounter = encounter;

        if (currentHp <= 0) {
            isAlive = false;
            System.out.println(this + " has been slain!");

            if (this instanceof Wolf) {  // This is for the Wolf kill quest. I'm not really sure where else to place this logic, it makes sense to me to update it inside the method that controls an entity's death.
                for (int i = 0; i < encounter.playerArray.length; i++) {
                    encounter.playerArray[i].wolvesToKill --;
                    encounter.playerArray[i].questReward();
                }
            }

            if (this instanceof Bandit) {  // This is for the Wolf kill quest. I'm not really sure where else to place this logic, it makes sense to me to update it inside the method that controls an entity's death.
                for (int i = 0; i < encounter.playerArray.length; i++) {
                    encounter.playerArray[i].banditsToKill --;
                    encounter.playerArray[i].questReward();
                }
            }

            if (this instanceof Orc) {  // This is for the Wolf kill quest. I'm not really sure where else to place this logic, it makes sense to me to update it inside the method that controls an entity's death.
                for (int i = 0; i < encounter.playerArray.length; i++) {
                    encounter.playerArray[i].orcsToKill --;
                    encounter.playerArray[i].questReward();
                }
            }

            if (this instanceof Goblin) {  // This is for the Wolf kill quest. I'm not really sure where else to place this logic, it makes sense to me to update it inside the method that controls an entity's death.
                for (int i = 0; i < encounter.playerArray.length; i++) {
                    encounter.playerArray[i].goblinsToKill --;
                    encounter.playerArray[i].questReward();
                }
            }

            encounter.removePlayer(this);
            gameEngine.removePlayer(this);

            location.encounter = cachedEncounter;


            location.endEncounter();
            gameEngine.youWin();
            gameEngine.gameOver();
        }
    }

    public void questReward() {

        if (quest.equals("Wolf Quest") && wolvesToKill <= 0) {
            quest = "No Quest";

            int rewardRng = random.nextInt(1,3);
            switch (rewardRng) {
                case 1:
                    int xpReward = random.nextInt(5, 11);
                    System.out.println(this + " completed their quest and received " + xpReward + " XP!");
                    xp += xpReward;
                    break;
                case 2:
                    int goldReward = random.nextInt(10,15);
                    System.out.println(this + " completed their quest and received " + goldReward + " gold!");
                    setGold(getGold() + goldReward);
                    break;
            }
        }

        if (quest.equals("Bandit Quest") && banditsToKill <= 0) {
            quest = "No Quest";

            int rewardRng = random.nextInt(1,3);
            switch (rewardRng) {
                case 1:
                    int xpReward = random.nextInt(5, 11);
                    System.out.println(this + " completed their quest and received " + xpReward + " XP!");
                    xp += xpReward;
                    break;
                case 2:
                    int goldReward = random.nextInt(10,15);
                    System.out.println(this + " completed their quest and received " + goldReward + " gold!");
                    setGold(getGold() + goldReward);
                    break;
            }
        }

        if (quest.equals("Orc Quest") && orcsToKill <= 0) {
            quest = "No Quest";

            int rewardRng = random.nextInt(1,3);
            switch (rewardRng) {
                case 1:
                    int xpReward = random.nextInt(15, 31);
                    System.out.println(this + " completed their quest and received " + xpReward + " XP!");
                    xp += xpReward;
                    break;
                case 2:
                    int goldReward = random.nextInt(15,31);
                    System.out.println(this + " completed their quest and received " + goldReward + " gold!");
                    setGold(getGold() + goldReward);
                    break;
            }
        }

        if (quest.equals("Goblin Quest") && goblinsToKill <= 0) {
            quest = "No Quest";

            int rewardRng = random.nextInt(1,3);
            switch (rewardRng) {
                case 1:
                    int xpReward = random.nextInt(15, 31);
                    System.out.println(this + " completed their quest and received " + xpReward + " XP!");
                    xp += xpReward;
                    break;
                case 2:
                    int goldReward = random.nextInt(15,31);
                    System.out.println(this + " completed their quest and received " + goldReward + " gold!");
                    setGold(getGold() + goldReward);
                    break;
            }
        }

        if (quest.equals("Wyvern Quest") && wyvernsToKill <= 0) {
            quest = "No Quest";

            int rewardRng = random.nextInt(1,3);
            switch (rewardRng) {
                case 1:
                    int xpReward = random.nextInt(30, 51);
                    System.out.println(this + " completed their quest and received " + xpReward + " XP!");
                    xp += xpReward;
                    break;
                case 2:
                    int goldReward = random.nextInt(30,51);
                    System.out.println(this + " completed their quest and received " + goldReward + " gold!");
                    setGold(getGold() + goldReward);
                    break;
            }
        }




    }

    public void encounterPhase() {

        if (encounter == null && location.equals(gameEngine.dragonToken.location)) {
            encounter = gameEngine.dragonAttack;
            if (DragonAttack.amountOfDragons == 0) {
                encounter.setup();
                encounter.addPlayer(this);
                encounter = gameEngine.dragonAttack;
                gameEngine.dragon.encounter = encounter;
                gameEngine.dragon.hasEncounter = true;
                hasEncounter = true;
                gameEngine.dragonToken.hasEncounter = true;
            }
        }

        System.out.println("*** Encounter Phase ***");
        encounter.displayParticipants();
        System.out.println("########################");
        System.out.println(this + "'s stamina: " + stamina);

        if (hasteTimer > 0) {
            System.out.println("Hasted actions remaining: " + hasteTimer);
        }


        System.out.println("What do you do?");
        encounter.options();
    }

    public void adjustHp() {
        if (currentHp > finalHp) {
            currentHp = finalHp;
        }
    }

    public void combat() {
        System.out.println("DEBUG Player.java.combat()");
    }

    public void showTargetOptions() {

        for (int i = 0; i < encounter.playerArray.length; i++) {
            encounter.playerArray[i].amountOfTimesDisplayed = 0;
        }

        boolean targetSelect = true;
        while (targetSelect) {
            for (int i = 0; i < encounter.playerArray.length; i++) {
                if (encounter.playerArray[i].amountOfTimesDisplayed == 0) {
                    if (encounter.playerArray[i].isStunned) {
                        System.out.println("[ " + (i + 1) + " ] " + encounter.playerArray[i].getName() + " === " + encounter.playerArray[i].currentHp + " HP | *** STUNNED ***");
                    }
                    else {
                        System.out.println("[ " + (i + 1) + " ] " + encounter.playerArray[i].getName() + " === " + encounter.playerArray[i].currentHp + " HP");
                    }
                    encounter.playerArray[i].amountOfTimesDisplayed ++;
                }
            }
            targetSelect = false;
        }
    }

    public Player targetSelect() {

        boolean targetSelect = true;
        while (targetSelect) {
            try {
                int input = scanner.nextInt() - 1;  //  If the input is 1, that needs to correspond to the first position in the encounter.playerArray which is [0]. It's n - 1
                scanner.nextLine();

                targetedEnemy = encounter.playerArray[input];
                targetSelect = false;
                return encounter.playerArray[input];
            }
            catch (Exception e) {
                System.out.println("Nope. You gotta type a valid integer.");
                scanner.nextLine();
            }
        }
        return null;
    }

    public void basicAttack() {

        updateStats();
        basicAttackDescription();
        int roll = rollAttack();

        int parryDamage;

        if (roll == 20) {
            System.out.println("NATURAL 20!");
            int damage = random.nextInt(1, (finalAttack / 5) + 5);  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
            if (damage <= 0) {  //  Damage can't be below 0. Can't heal them with an attack lol
                damage = 1;
            }
            damage += attackSkillBuff;
            damage -= targetedEnemy.defenseSkillBuff;
            damage *= 2;

            if (targetedEnemy.parryStance == false) {
                targetedEnemy.currentHp -= damage;
                System.out.println(targetedEnemy + " took " + damage + " damage!");
                System.out.println("");
                targetedEnemy.deathCheck();
                return;
            } else {  //  This else block runs if the player warrior used Perfect-Parry
                parryDamage = random.nextInt(targetedEnemy.finalDefense / 5, 2 * (targetedEnemy.finalDefense / 5)+ 1);
                currentHp -= damage + parryDamage;
                System.out.println("DEFLECT!!!");
                System.out.println("In one motion, " + targetedEnemy + " blocks the strike and delivers a counter attack!");
                System.out.println(this + " takes " + damage + " + " + parryDamage +" damage!");
                System.out.println("");
                deathCheck();
                targetedEnemy.parryStance = false;
                return;
            }
        }

        if (roll + (finalAttack / 5) >= 10 + (targetedEnemy.finalDefense / 5)) {

            System.out.println("SUCCESS! Rolled a " + roll + " + " + (finalAttack / 5));
            int damage = random.nextInt(1, (finalAttack / 5) + 5);  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
            if (damage <= 0) {  //  Damage can't be below 0. Can't heal them with an attack lol
                damage = 1;
            }
            damage += attackSkillBuff;
            damage -= targetedEnemy.defenseSkillBuff;

            if (damage <= 0) {  //  Damage can't be below 0. Can't heal them with an attack lol
                damage = 1;
            }

            if (targetedEnemy.parryStance == false) {
                targetedEnemy.currentHp -= damage;
                System.out.println(targetedEnemy + " took " + damage + " damage!");
                System.out.println("");
                targetedEnemy.deathCheck();
            }
            else {
                parryDamage = random.nextInt(targetedEnemy.finalDefense / 5, 2 * (targetedEnemy.finalDefense / 5) + 1);
                currentHp -= damage + parryDamage;
                System.out.println("DEFLECT!!!");
                System.out.println("In one motion, " + targetedEnemy + " blocks the strike and delivers a counter attack!");
                System.out.println(this + " takes " + damage + " + " + parryDamage +" damage!");
                System.out.println("");
                deathCheck();
                targetedEnemy.parryStance = false;
            }
        }
        else {
            System.out.println("FAILURE! Rolled a " + roll + " + " + (finalAttack / 5));
            System.out.println("");
        }

    }

    public boolean cityOptions() {

        System.out.println("[ 1 ] Visit the marketplace");
        System.out.println("[ 2 ] Rest at the inn");

        boolean inputSelection = true;
        while (inputSelection) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1: inputSelection = false; marketplace(); return false;
                    case 2: currentHp = finalHp; stamina = maxStamina; System.out.println("You wounds have healed, and you are fully rested."); inputSelection = false; return true;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid option.");
                scanner.nextLine();
            }
        }
        return false;
    }

    public void rest() {

        int restoredHp = random.nextInt(1,(finalHp / 4) + 2);
        System.out.println(this + " restored " + restoredHp + " HP and 1 stamina!");
        currentHp += restoredHp;
        stamina ++;

        if (stamina > maxStamina) {
            stamina = maxStamina;
        }

        if (currentHp > finalHp) {
            currentHp = finalHp;
        }

    }

    public void marketPlaceOptions() {

        System.out.println("[ 1 ] Buy");
        System.out.println("[ 2 ] Sell");
        System.out.println("[ 0 ] Exit");
    }

    public void marketplace() {

        marketPlaceOptions();

        boolean marketplaceChoice = true;
        while (marketplaceChoice) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1:
                        System.out.println(this + "'s gold: " + gold);
                        for (int i = 0; i < location.shop.itemArray.length; i++) {
                            if (location.shop.itemArray[i] instanceof Potion) {
                                System.out.println("[ " + (i + 1) + " ] " + location.shop.itemArray[i] + " === " + location.shop.itemArray[i].price + " gold");
                            }
                            else if (location.shop.itemArray[i] instanceof Spell || location.shop.itemArray[i] instanceof Skill) {
                                System.out.println("[ " + (i + 1) + " ] " + location.shop.itemArray[i].displayItem());
                            }
                            else {
                                System.out.println("[ " + (i + 1) + " ] " + location.shop.itemArray[i] + " === Attack: " + location.shop.itemArray[i].attack + " | " + "Defense: " + location.shop.itemArray[i].defense + " | " + "Luck: " + location.shop.itemArray[i].luck + " | " + "HP: " + location.shop.itemArray[i].hp + " === " + location.shop.itemArray[i].price + " gold");
                            }
                        }
                        System.out.println("[ 0 ] Exit");
                        buyItem();
                        marketPlaceOptions();
                        continue;
                    case 2:

                        if (inventory.itemArray.length < 1) {
                            System.out.println("You have nothing to sell.");
                            continue;
                        }

                        else {
                            for (int i = 0; i < inventory.itemArray.length; i++) {
                                if (inventory.itemArray[i] instanceof Potion || inventory.itemArray[i] instanceof Spell || inventory.itemArray[i] instanceof Skill || inventory.itemArray[i] instanceof Stunt) {
                                    System.out.println("[ " + (i + 1) + " ] " + inventory.itemArray[i] + " === " + inventory.itemArray[i].price + " gold");
                                }
                                else {
                                    System.out.println("[ " + (i + 1) + " ] " + inventory.itemArray[i] + " === Attack: " + inventory.itemArray[i].attack + " | " + "Defense: " + inventory.itemArray[i].defense + " | " + "Luck: " + inventory.itemArray[i].luck + " | " + "HP: " + inventory.itemArray[i].hp + " === " + inventory.itemArray[i].price + " gold");
                                }
                            }
                            System.out.println("[ 0 ] Exit");
                            sellItem();
                            marketPlaceOptions();
                            continue;
                        }
                    case 0:
                        marketplaceChoice = false;
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid option." + e);
                scanner.nextLine();
            }
        }
    }

    public void buyItem() {

        boolean waitingForMarketplaceChoice = true;
        while (waitingForMarketplaceChoice) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                if (input == 0) {
                    waitingForMarketplaceChoice = false;
                    break;
                }

                selectedItem = location.shop.itemArray[input - 1];
                Item purchasedItem = selectedItem.copy();
                purchasedItem.attack = selectedItem.attack;
                purchasedItem.defense = selectedItem.defense;
                purchasedItem.luck = selectedItem.luck;
                purchasedItem.hp = selectedItem.hp;
                purchasedItem.price = selectedItem.price;
                purchasedItem.healAmount = selectedItem.healAmount;

                if (selectedItem.price > gold) {
                    System.out.println("You are too broke to afford this item.");
                    waitingForMarketplaceChoice = false;
                    return;
                }
                else {
                    System.out.println("You purchased " + selectedItem + " for " + selectedItem.price + " gold!");
                    gold -= selectedItem.price;
                    getLocation().shop.removeItem(selectedItem);
                    inventory.addItem(purchasedItem);
                    waitingForMarketplaceChoice = false;
                    return;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid option.");
                scanner.nextLine();
            }
        }
    }

    public void sellItem() {

        boolean sellItem = true;
        while (sellItem) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input == 0) {
                    return;
                }

                selectedItem = inventory.itemArray[input - 1];
                setGold(getGold() + selectedItem.price);
                System.out.println("You sold " + selectedItem + " for " + selectedItem.price + " gold!");
                inventory.removeItem(selectedItem);
                sellItem = false;
            } catch (Exception e) {
                System.out.println("Invalid option. You gotta type an integer.");
                scanner.nextLine();
            }
        }
    }

    public void basicAttackDescription() {}

    public void displayStats() {;

        updateStats();
        System.out.println(this);
        System.out.println("Attack: " + finalAttack);
        System.out.println("Defense: " + finalDefense);
        System.out.println("Luck: " + finalLuck);
        System.out.println("Max HP: " + finalHp);
        System.out.println("Current HP: " + currentHp);
        System.out.println("Stamina: " + stamina);
        System.out.println("Gold: " + getGold());
        System.out.println("");
    }

    public void run() {

        System.out.println(this + " tries to escape the battle!");

        int rollLuck = rollLuck();
        if (rollLuck + (finalLuck / 5) > 10) {


            if (tauntDuplicates > 0) {
                for (int i = tauntDuplicates - 1; i >= 0; i--) {
                    encounter.removePlayer(this);
                }
            }



            System.out.println("");
            hasteTimer = 0;

            for (int i = encounter.playerArray.length - 1; i >= 0; i--) {

                if (encounter.playerArray[i] instanceof Enemy) {
                    System.out.println(encounter.playerArray[i] + " attempts to strike " + this + " while they are fleeing!");
                    encounter.playerArray[i].targetedEnemy = this;
                    encounter.playerArray[i].basicAttack();
                    if (!isAlive) {
                        return;
                    }
                    System.out.println("");
                }
            }
            encounter.removePlayer(this);  //  this <- refers to the Player that is attempting to flee from battle.

                location.encounter = encounter;

                if (location.encounter.arePlayersInEncounter() == false) {

                    for (int i = encounter.playerArray.length - 1; i >= 0; i--) {

                        if (encounter.playerArray[i] instanceof Scorchwyrm) {
                            DragonAttack.amountOfDragons --;
                            gameEngine.dragonToken.hasEncounter = false;
                        }
                        gameEngine.removePlayer(encounter.playerArray[i]);
                        encounter.removePlayer(encounter.playerArray[i]);
                    }
                    location.encounter = null;
                    hasEncounter = false;
                    encounter = null;
                    System.out.println("");
                }

            System.out.println("(" + getX() + "," + getY() + ")");
            System.out.println("*** Run Away ***");
            System.out.println("[ 1 ] Travel North");
            System.out.println("[ 2 ] Travel East");
            System.out.println("[ 3 ] Travel South");
            System.out.println("[ 4 ] Travel West");

            boolean selectChoice = true;
            while (selectChoice) {
                try {
                    int input = scanner.nextInt();
                    scanner.nextLine();

                    if (input == 1 && getY() < 10) {
                        setY(getY() + 1);
                        selectChoice = false;
                        System.out.println(this + " moved North. New map position is: (" + getX() + "," + getY() + ")");
                        break;
                    } else if (input == 1 && getY() >= 10) {
                        System.out.println("You can't go any further North.");
                    } else if (input == 2 && getX() < 10) {
                        setX(getX() + 1);
                        selectChoice = false;
                        System.out.println(this + " moved East. New map position is: (" + getX() + "," + getY() + ")");
                        break;
                    } else if (input == 2 && getX() >= 10) {
                        System.out.println("You can't go any further East.");
                    } else if (input == 3 && getY() > 0) {
                        setY(getY() - 1);
                        selectChoice = false;
                        System.out.println(this + " moved South. New map position is: (" + getX() + "," + getY() + ")");
                        break;
                    } else if (input == 3 && getY() <= 0) {
                        System.out.println("You can't go any further south.");
                    } else if (input == 4 && getX() > 0) {
                        setX(getX() - 1);
                        selectChoice = false;
                        System.out.println(this + " moved West. New map position is: (" + getX() + "," + getY() + ")");
                        break;
                    } else if (input == 4 && getX() <= 0) {
                        System.out.println("You can't go any further West.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid.");
                }
            }
        }
    }
    @Override
    public String toString() {

        String returnMe = "";
        returnMe += name;
        return returnMe;
    }
}
