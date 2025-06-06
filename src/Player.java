import java.util.Random;
import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    GameEngine gameEngine;
    Player targetedEnemy;  //  targetSelct() sets this variable to the enemy the player is targeting, and this variable is used in rollAttack()
    boolean isAlive = true;

    protected String name;
    private int hp;
    private int positionX;
    private int positionY;
    private int gold;
    private int xp;

    int attack;
    int defense;
    int luck;

    private Location location;
    Encounter encounter;
    boolean hasEncounter = false;
    boolean isStunned = false;


    public Player(GameEngine gameEngine, String name) {
        this.gameEngine = gameEngine;
        this.name = name;
        this.location = gameEngine.map.findLocation(getX(), getY());

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

    public Location getLocation() {
        return location;
    }

    public Encounter getEncounter() {return encounter;}

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setEncounter(Encounter encounter) {this.encounter = encounter;}

    public void movementPhase() {



        boolean movementPhase = true;
        System.out.println("(" +location.x + "," + location.y + ")");
        System.out.println("*** Movement Phase ***");
        System.out.println("What do you do?");
        System.out.println("[1] Travel North");
        System.out.println("[2] Travel East");
        System.out.println("[3] Travel South");
        System.out.println("[4] Travel West");
        System.out.println("[5] Stay here");

        while (movementPhase) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input == 1) {
                    setY(getY() + 1);
                    movementPhase = false;
                    System.out.println(this + " moved North. New map position is: (" + getX() + "," + getY() + ")");
                    break;
                }

                if (input == 2) {
                    setX(getX() + 1);
                    movementPhase = false;
                    System.out.println(this + " moved East. New map position is: (" + getX() + "," + getY() + ")");
                    break;
                }

                if (input == 3 && getY() > 0) {
                    setY(getY() - 1);
                    movementPhase = false;
                    System.out.println(this + " moved South. New map position is: (" + getX() + "," + getY() + ")");
                    break;
                } else if (input == 3 && getY() <= 0) {
                    System.out.println("You can't go any further south.");
                }

                if (input == 4 && getX() > 0) {
                    setX(getX() - 1);
                    movementPhase = false;
                    System.out.println(this + " moved West. New map position is: (" + getX() + "," + getY() + ")");
                    break;
                } else if (input == 4 && getX() <= 0) {
                    System.out.println("You can't go any further West.");
                }

                if (input == 5) {
                    movementPhase = false;
                    System.out.println("I must not yet leave. My business is left unfinished");
                    break;
                } else {
                    System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Invalid option");
                scanner.nextLine();
            }
        }
    }

    public int rollLuck() {
        int rng = random.nextInt(21);
        System.out.println("You rolled " + rng + " + " + luck);
        return rng + luck;
    }

    public int rollAttack() {

        int rng = random.nextInt(1,21);

        if (rng + attack >= 10 + targetedEnemy.defense) {
            System.out.println("Success! Rolled a " + rng + " + " + attack + " to hit " + targetedEnemy);
            return rng;
        }
        else {
            System.out.println("Failure! Rolled a " + rng + " + " + defense + " to hit " + targetedEnemy);
            return rng;
        }
    }


    public void deathCheck() {
        if (hp <= 0) {
            isAlive = false;
            System.out.println(this + " has been slain!");
            //System.out.println("DEBUG Player.deathCheck(): Removing " + this + " from Encounter");
            encounter.removePlayer(this);
            //System.out.println("DEBUG Player.deathCheck(): Removing " + this + " from gameEngine");
            gameEngine.removePlayer(this);
            //System.out.println("DEBUG: BEFORE: " + gameEngine.toString());
            location.endEncounter();
            //System.out.println("DEBUG: AFTER: " + gameEngine.toString());
        }
    }

    public void encounterPhase() {

        System.out.println("*** Encounter Phase ***");
        encounter.displayParticipants();
        System.out.println("########################");
        System.out.println("What do you do?");
    }

    public void combat() {
        System.out.println("DEBUG Player.java.combat()");
    }

    public void showTargetOptions() {

        boolean targetSelect = true;
        while (targetSelect) {
            for (int i = 0; i < encounter.playerArray.length; i++) {
                System.out.println("[ " + (i + 1) + " ] " + encounter.playerArray[i].getName() + " === " + encounter.playerArray[i].getHp() + " HP");
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

        basicAttackDescription();
        int roll = rollAttack();

        if (roll == 20) {
            System.out.println("NATURAL 20!");
            int damage = (random.nextInt(1, attack) + (attack / 4) - (targetedEnemy.defense / 4)) * 2;  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
            if (damage <= 0) {  //  Damage can't be below 0. Can't heal them with an attack lol
                damage = 1;
            }
        }


        else if (roll > 10) {
            int damage = random.nextInt(1, attack) + (attack / 4) - (targetedEnemy.defense / 4);  // Damage works by rolling a random number from 1 to Attack stat, and adding it to Attack stat / 4. Then subtract (enemy defense / 4)
            if (damage <= 0) {  //  Damage can't be below 0. Can't heal them with an attack lol
                damage = 1;
            }
            targetedEnemy.setHp(targetedEnemy.getHp() - damage);
            System.out.println(targetedEnemy + " took " + damage + " damage!");
            targetedEnemy.deathCheck();
        }
    }

    public void basicAttackDescription() {}

    @Override
    public String toString() {

        String returnMe = "";
        returnMe += name;
        return returnMe;
    }
}
