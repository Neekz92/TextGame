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
    int currentHp;
    private int positionX;
    private int positionY;
    private int gold = 5;
    private int xp;
    int chosenStat = 0;
    String chosenStatName = "";


    int attack;
    int finalAttack;

    int defense;
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
    boolean didASocialEncounterThisturn = false;


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
    }

    public void movementPhase() {

        boolean movementPhase = true;
        movementPhaseOptions();

        while (movementPhase) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input == 1) {
                    setY(getY() + 1);
                    movementPhase = false;
                    System.out.println(this + " moved North. New map position is: (" + getX() + "," + getY() + ")");
                    break;
                } else if (input == 2) {
                    setX(getX() + 1);
                    movementPhase = false;
                    System.out.println(this + " moved East. New map position is: (" + getX() + "," + getY() + ")");
                    break;
                } else if (input == 3 && getY() > 0) {
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
                        //System.out.println("DEBUG: youHaveXpToSpend() is " + youHaveXpToSpend() + ", calling spendXp()");
                        spendXp();
                    }
                } else if (input == 8) {
                    inventory.openInventory();
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

    public boolean youHaveXpToSpend() {

        if (xp <= 0) {
            System.out.println("You have no XP to spend.");
            movementPhaseOptions();
            return false;
        }
        return true;
    }

    public void spendXp() {

        boolean chooseStat = true;
        while (chooseStat) {
            System.out.println("You have " + xp + " XP to spend. Choose a stat to upgrade.");
            System.out.println("[ 1 ] Attack");
            System.out.println("[ 2 ] Defense");
            System.out.println("[ 3 ] Luck");
            System.out.println("[ 4 ] Max HP");
            System.out.println("[ 5 ] Stamina");

            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {  //  If the user selects 1 - the targeted stat that is upgraded gets set. The string gets set to let the user know in the next step.
                case 1: chosenStat = attack; chosenStatName = "Attack"; chooseStat = false; upgradeStat(); break;
                case 2: chosenStat = defense; chosenStatName = "Defense"; chooseStat = false; upgradeStat(); break;
                case 3: chosenStat = luck; chosenStatName = "Luck"; chooseStat = false; upgradeStat(); break;
                case 4: chosenStat = hp; chosenStatName = "Max HP"; chooseStat = false; upgradeStat(); break;
                default: System.out.println("Invalid option.");
            }
        }
    }

    public void upgradeStat() {

        boolean inputAmountOfStatPoints = true;
        while (inputAmountOfStatPoints) {
            System.out.println(xp + " XP available. How many points would you like to add to " + chosenStatName);

            int input = scanner.nextInt();
            scanner.nextLine();

            if (input > xp) {
                System.out.println("You don't have that much XP.");
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
                movementPhaseOptions();
                break;
            }
        }
    }

    public int rollLuck() {
        int rng = random.nextInt(21);

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

        if (rng + (finalAttack / 5) >= 10 + (targetedEnemy.finalDefense / 5)) {
            System.out.println("Success! Rolled a " + rng + " + " + (finalAttack / 5) + " to hit " + targetedEnemy);
            return rng;
        }
        else {
            System.out.println("Failure! Rolled a " + rng + " + " + (finalAttack / 5) + " to hit " + targetedEnemy);
            return rng;
        }
    }

    public void deathCheck() {
        if (currentHp <= 0) {
            isAlive = false;
            System.out.println(this + " has been slain!");
            encounter.removePlayer(this);
            gameEngine.removePlayer(this);
            location.endEncounter();
        }
    }

    public void encounterPhase() {

        System.out.println("*** Encounter Phase ***");
        encounter.displayParticipants();
        System.out.println("########################");
        System.out.println(this + "'s stamina: " + stamina);
        System.out.println("What do you do?");
        encounter.options();
    }

    public void combat() {
        System.out.println("DEBUG Player.java.combat()");
    }

    public void showTargetOptions() {

        boolean targetSelect = true;
        while (targetSelect) {
            for (int i = 0; i < encounter.playerArray.length; i++) {
                System.out.println("[ " + (i + 1) + " ] " + encounter.playerArray[i].getName() + " === " + encounter.playerArray[i].currentHp + " HP");
            }
            targetSelect = false;
        }
    }

    public Player targetSelect() {

        int input = scanner.nextInt() - 1;  //  If the input is 1, that needs to correspond to the first position in the encounter.playerArray which is [0]. It's n - 1
        scanner.nextLine();

        targetedEnemy = encounter.playerArray[input];
        return encounter.playerArray[input];
    }

    public void basicAttack() {

        updateStats();
        basicAttackDescription();
        int roll = rollAttack();

        if (roll == 20) {
            System.out.println("NATURAL 20!");
            int damage = random.nextInt(0, (finalAttack / 5) + 5) - (targetedEnemy.finalDefense / 5);  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
            if (damage <= 0) {  //  Damage can't be below 0. Can't heal them with an attack lol
                damage = 1;
            }
            damage *= 2;
            targetedEnemy.currentHp -= damage;
            System.out.println(targetedEnemy + " took " + damage + " damage!");
            targetedEnemy.deathCheck();
            return;
        }

        if (roll + (finalAttack / 5) >= 10 + (targetedEnemy.finalDefense / 5)) {

            int damage = random.nextInt(0, (finalAttack / 5) + 5) - (targetedEnemy.finalDefense / 5);  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
            if (damage <= 0) {  //  Damage can't be below 0. Can't heal them with an attack lol
                damage = 1;
            }
            // targetedEnemy.setHp(targetedEnemy.getHp() - damage);
            targetedEnemy.currentHp -= damage;
            System.out.println(targetedEnemy + " took " + damage + " damage!");
            targetedEnemy.deathCheck();
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
            }
        }
        return false;
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
                            sellItem();
                            marketPlaceOptions();
                            break;
                        }
                    case 0:
                        marketplaceChoice = false;
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid option.");
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
                Item purchasedItem = selectedItem.copy();  //  CURRENT ISSUE, NOTICE ME CHATGPT. the item should have already had its stats assigned before copy() runs, no?
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
            }
        }
    }

    public void sellItem() {

        int input = scanner.nextInt();
        scanner.nextLine();

        selectedItem = inventory.itemArray[input - 1];
        setGold(getGold() + selectedItem.price);
        System.out.println("You sold " + selectedItem + " for " + selectedItem.price + " gold!");
        inventory.removeItem(selectedItem);
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
        movementPhaseOptions();
    }

    public void run() {

        System.out.println(this + " tries to escape the battle!");
        if (rollLuck() + (finalLuck / 5) > 10) {
            for (int i = 0; i < encounter.playerArray.length; i++) {
                if (encounter.playerArray[i] instanceof  Enemy) {
                    System.out.println(encounter.playerArray[i] + " attempts to strike " + this + " while they are fleeing!");
                    encounter.playerArray[i].targetedEnemy = this;
                    encounter.playerArray[i].basicAttack();
                    System.out.println("");
                }
            }
            encounter.removePlayer(this);
            hasEncounter = false;
            movementPhase();
        }
    }

    @Override
    public String toString() {

        String returnMe = "";
        returnMe += name;
        return returnMe;
    }
}
