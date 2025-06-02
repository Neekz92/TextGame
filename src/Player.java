import java.util.Random;
import java.util.Scanner;

public class Player {

    protected String name;
    private int hp;
    private int positionX;
    private int positionY;
    private int gold;
    private Location location;
    private Encounter encounter;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    boolean isAnEnemy = false;
    boolean hasEncounter = false;
    int attack;
    int defense;
    int luck;

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

    public void setLocation(Location location) {
        this.location = location;
    }


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
                    System.out.println("Moved North. New map position is: " + getX() + " ," + getY());
                    break;
                }

                if (input == 2) {
                    setX(getX() + 1);
                    movementPhase = false;
                    System.out.println("Moved East. New map position is: " + getX() + " ," + getY());
                    break;
                }

                if (input == 3 && getY() > 0) {
                    setY(getY() - 1);
                    movementPhase = false;
                    System.out.println("Moved South. New map position is: " + getX() + " ," + getY());
                    break;
                } else if (input == 3 && getY() <= 0) {
                    System.out.println("You can't go any further south.");
                }

                if (input == 4 && getX() > 0) {
                    setX(getX() - 1);
                    movementPhase = false;
                    System.out.println("Moved West. New map position is: " + getX() + " ," + getY());
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


    public void rollAttack() {

    }

    public int rollLuck() {
        int rng = random.nextInt(21);
        System.out.println("You rolled " + rng + " + " + luck);
        return rng + luck;
    }


    public void encounterPhase() {

        boolean encounterPhase = true;
        while (encounterPhase) {                             //  This is a bit messy, but the while loop is here because if the player
            System.out.println("*** Encounter Phase ***");   //  enters an invalid option, it needs to repeat and ask the player for input again.
            System.out.println("Location object: " + location);
            System.out.println("hasEncounter: " + location.hasEncounter);

            if (!location.hasEncounter) {                    //  .rollEncounter() is randomly selecting an encounter to play, and then it sets the Location's encounter.
                System.out.println("The if blocks is executing.");
                location.rollEncounter();
                encounter = location.encounter;              //  This stores a reference to the current Encounter for the Player. Without it, the Player would have no idea what Encounter it is.
                encounter.player = this;                     //  This stores the Player in the Encounter object. Without it, the Encounter doesn't know how to interact with the Player.
                hasEncounter = true;
                encounter.add(this);
                location.encounter.showDescription();        //  Print out the basic description of the rolled Encounter.
                location.encounter.showOptions();            //  Print out the choices the player has for this Encounter.
                location.encounter.waitingDecision();      //  Enter the decision loop where the Player decides what action to take during the Encounter.
                encounterPhase = false;
            } else if (location.hasEncounter) {
                System.out.println("Debug: else block is executing.");
                encounter = location.encounter;
                encounter.player = this;
                if (hasEncounter == false) {
                    encounter.add(this);
                }
                location.encounter.showOngoingDescription();
                location.encounter.showParticipants();
                location.encounter.showOptions();
                location.encounter.waitingDecision();
                encounterPhase = false;
            }
        }
        encounterPhase = false;                          // When encounterPhase is false, the loop ends.
    }




    public Encounter getEncounter() {
        return encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }


    @Override
    public String toString() {

        String returnMe = "";
        returnMe += name;
        return returnMe;
    }
}
