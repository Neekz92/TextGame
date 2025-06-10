import java.util.Random;
import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    GameEngine gameEngine;
    Player targetedEnemy;  //  targetSelect() sets this variable to the enemy the player is targeting, and this variable is used in rollAttack()
    boolean isAlive = true;



    Armor defaultArmor = new Armor();
    Armor armor = defaultArmor;

    Item weapon = new Item();





    int amountOfItems;
    Item[] inventory = new Item[amountOfItems];

    protected String name;
    int currentHp;
    private int positionX;
    private int positionY;
    private int gold;
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


    private Location location;
    Encounter encounter;
    boolean hasEncounter = false;
    boolean isStunned = false;


    public Player(GameEngine gameEngine, String name) {
        this.gameEngine = gameEngine;
        this.name = name;
        this.location = gameEngine.map.findLocation(getX(), getY());
        this.xp = 15;
        updateStats();

    }

    public void updateStats() {

        finalAttack = attack + armor.attack + weapon.attack;
        finalDefense = defense + armor.defense + weapon.defense;
        finalLuck = luck + armor.luck + weapon.luck;
        finalHp = hp + weapon.luck;
    }

    public Player(GameEngine gameEngine) {
        this(gameEngine, "Default");
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

    public void addItem(Item item) {

        amountOfItems++;
        Item[] inventoryClone = new Item[amountOfItems];

        for (int i = 0; i < inventory.length; i++) {
            inventoryClone[i] = inventory[i];
        }
        inventoryClone[amountOfItems - 1] = item;
        inventory = inventoryClone;
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
                    System.out.println(this);
                    System.out.println("Attack: " + finalAttack);
                    System.out.println("Defense: " + finalDefense);
                    System.out.println("Luck: " + finalLuck);
                    System.out.println("Max HP: " + finalHp);
                    System.out.println("Current HP: " + currentHp);
                    System.out.println("Stamina: SoonTM");
                    System.out.println("Gold: " + getGold());
                    System.out.println("");
                    movementPhaseOptions();
                } else if (input == 7) {
                    if (youHaveXpToSpend()) {  //  Only allow player to enter the Upgrade Stat menu if they have XP
                        //System.out.println("DEBUG: youHaveXpToSpend() is " + youHaveXpToSpend() + ", calling spendXp()");
                        spendXp();
                    }
                } else if (input == 8) {

                    if (inventory.length == 0) {
                        System.out.println("Your Inventory is empty.");
                    } else {
                        System.out.println(this + "'s Inventory:");
                        for (int i = 0; i < inventory.length; i++) {
                            Item currentItem = inventory[i];
                            if (!(currentItem instanceof Potion)) {
                                System.out.println("[ " + (i + 1) + " ] " + currentItem + " === " + "Attack: " + currentItem.attack + " | Defense: " + currentItem.defense + " | " + "Luck: " + currentItem.luck);
                            } else {
                                System.out.println("[ " + (i + 1) + " ] " + currentItem);
                            }
                        }
                        System.out.println("[ 0 ] Exit");

                        int itemSelect = scanner.nextInt();
                        scanner.nextLine();

                        if (itemSelect == 0) {
                            movementPhaseOptions();
                        }

                        Item selectedItem = inventory[itemSelect - 1];

                        System.out.println("What would you like to do with " + selectedItem + "?");
                        System.out.println("[ 1 ] Use");
                        System.out.println("[ 2 ] Trade");
                        System.out.println("[ 3 ] Exit");

                        int itemInteraction = scanner.nextInt();
                        scanner.nextLine();

                        switch (itemInteraction) {
                            case 1:
                                if (selectedItem instanceof Armor) {
                                    if (armor == null) {
                                        armor = (Armor) selectedItem;
                                        updateStats();
                                        System.out.println("You equipped " + armor);
                                        // TODO: remove armor from inventory
                                        break;
                                    }
                                else {
                                    System.out.println("Do you want to swap these two armors?");
                                    System.out.println("[ 1 ] Yes");
                                    System.out.println("[ 2 ] No");
                                    int wantToSwapItem = scanner.nextInt();
                                    switch (wantToSwapItem) {
                                        case 1:
                                            Item tempItem = armor;
                                            armor = (Armor) selectedItem;
                                            updateStats();
                                            System.out.println("You equipped " + armor);
                                            inventory[itemSelect - 1] = tempItem;
                                            break;
                                    }
                                }
                            }
                            else if (selectedItem instanceof Sword) {
                                if (this instanceof Warrior) {
                                    if (weapon == null) {
                                        weapon = selectedItem;
                                        updateStats();
                                        System.out.println("You equipped " + weapon);
                                        // TODO: remove weapon from inventory
                                        break;
                                    }
                                    else {
                                        System.out.println("Do you want to swap these two weapons?");
                                        System.out.println("[ 1 ] Yes");
                                        System.out.println("[ 2 ] No");
                                        int wantToSwapItem = scanner.nextInt();
                                        switch (wantToSwapItem) {
                                            case 1:
                                                Item tempItem = weapon;
                                                weapon = selectedItem;
                                                updateStats();
                                                System.out.println("You equipped " + weapon);
                                                inventory[itemSelect - 1] = tempItem;
                                                break;
                                        }
                                    }
                                }
                                else {
                                    System.out.println("You are not proficient with this weapon.");
                                    break;
                                }
                            }
                            else if (selectedItem instanceof Staff) {
                                if (this instanceof Mage) {
                                    if (weapon == null) {
                                        weapon = selectedItem;
                                        updateStats();
                                        System.out.println("You equipped " + weapon);
                                        // TODO: remove weapon from inventory
                                        break;
                                    }
                                    else {
                                        System.out.println("Do you want to swap these two weapons?");
                                        System.out.println("[ 1 ] Yes");
                                        System.out.println("[ 2 ] No");
                                        int wantToSwapItem = scanner.nextInt();
                                        switch (wantToSwapItem) {
                                            case 1:
                                                Item tempItem = weapon;
                                                weapon = selectedItem;
                                                updateStats();
                                                System.out.println("You equipped " + weapon);
                                                inventory[itemSelect - 1] = tempItem;
                                                break;
                                        }
                                    }
                                }
                                else {
                                    System.out.println("You are not proficient with this weapon.");
                                }
                            }
                            else if (selectedItem instanceof Bow) {
                                if (this instanceof Archer) {
                                    if (weapon == null) {
                                        weapon = selectedItem;
                                        updateStats();
                                        System.out.println("You equipped " + weapon);
                                        // TODO: remove weapon from inventory
                                        break;
                                    }
                                    else {
                                        System.out.println("Do you want to swap these two weapons?");
                                        System.out.println("[ 1 ] Yes");
                                        System.out.println("[ 2 ] No");
                                        int wantToSwapItem = scanner.nextInt();
                                        switch (wantToSwapItem) {
                                            case 1:
                                                Item tempItem = weapon;
                                                weapon = selectedItem;
                                                updateStats();
                                                System.out.println("You equipped " + weapon);
                                                inventory[itemSelect - 1] = tempItem;
                                                break;
                                            case 2:
                                                movementPhaseOptions();
                                                break;
                                        }
                                    }
                                }
                                else {
                                    System.out.println("You are not proficient with this weapon.");
                                    break;
                                }
                            }
                            case 2:
                                System.out.println("Trade is not yet implemented."); break;
                            case 3:
                                break;
                        }
                    }
                    System.out.println("########################");
                    movementPhaseOptions();
                }
                else {
                    System.out.println("Invalid option.");
                }
            }
            catch (Exception e) {
                System.out.println("Invalid option");
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

    public void itemUpdateStats() {

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

        if (rng + (attack / 5) >= 10 + (targetedEnemy.defense / 5)) {
            System.out.println("Success! Rolled a " + rng + " + " + (attack / 5) + " to hit " + targetedEnemy);
            return rng;
        }
        else {
            System.out.println("Failure! Rolled a " + rng + " + " + (attack / 5) + " to hit " + targetedEnemy);
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
            int damage = random.nextInt(0, (finalAttack + 1)) + (finalAttack / 5) - (targetedEnemy.finalDefense / 5);  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
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

            int damage = random.nextInt(0, (finalAttack + 1)) + (finalAttack / 5) - (targetedEnemy.finalDefense / 5);  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
            if (damage <= 0) {  //  Damage can't be below 0. Can't heal them with an attack lol
                damage = 1;
            }
            // targetedEnemy.setHp(targetedEnemy.getHp() - damage);
            targetedEnemy.currentHp -= damage;
            System.out.println(targetedEnemy + " took " + damage + " damage!");
            targetedEnemy.deathCheck();
        }
    }



    public void cityOptions() {

        System.out.println("[ 1 ] Visit the marketplace");
        System.out.println("[ 2 ] Rest at the inn");
        System.out.println("[ 3 ] Proceed to Movement Phase");

        boolean inputSelection = true;
        while (inputSelection) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1: System.out.println("Do stuff,"); inputSelection = false; break;
                    case 2: currentHp = finalHp; System.out.println("You wounds have healed, and you are fully rested."); inputSelection = false; break;
                    default: System.out.println("Do other stuff," ); inputSelection = false; break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid option.");
            }
        }
    }

    public void marketplace() {

        System.out.println("[ 1 ] Buy");
        System.out.println("[ 2 ] Sell");
        System.out.println("[ 0 ] Exit");
    }

    public void basicAttackDescription() {}

    @Override
    public String toString() {

        String returnMe = "";
        returnMe += name;
        return returnMe;
    }
}
