import java.util.Random;
import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    GameEngine gameEngine;

    protected String name;
    private int hp;
    private int positionX;
    private int positionY;
    private int gold;

    int attack;
    int defense;
    int luck;

    private Location location;
    Encounter encounter;
    boolean hasEncounter = false;


    public Player(String name) {
        this.name = name;

        attack = 5;
        defense = 5;
        luck = 10;

        positionX = 0;
        positionY = 0;
        location = null;

        gold = 1;
    }

    public Player() {
        this("No name");

        attack = 5;
        defense = 5;
        luck = 10;

        positionX = 0;
        positionY = 0;
        location = null;

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
        System.out.println(location.x + ", " + location.y);
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
                    System.out.println(this + " moved North. New map position is: " + getX() + " ," + getY());
                    break;
                }

                if (input == 2) {
                    setX(getX() + 1);
                    movementPhase = false;
                    System.out.println(this + " moved East. New map position is: " + getX() + " ," + getY());
                    break;
                }

                if (input == 3 && getY() > 0) {
                    setY(getY() - 1);
                    movementPhase = false;
                    System.out.println(this + " moved South. New map position is: " + getX() + " ," + getY());
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

    public void encounterPhase() {

        System.out.println("*** Encounter Phase ***");
        encounter.displayParticipants();
        System.out.println("########################");
        System.out.println("What do you do?");
    }

    public void combat() {

    }

    @Override
    public String toString() {

        String returnMe = "";
        returnMe += name;
        return returnMe;
    }
}
