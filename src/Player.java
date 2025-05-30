import java.util.Scanner;

public class Player {

    protected String name;
    private int hp;
    private int positionX;
    private int positionY;
    private int gold;
    private Location location;
    Scanner scanner = new Scanner(System.in);

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
                }
                else if (input == 3 && getY() <= 0) {
                    System.out.println("You can't go any further south.");
                }

                if (input == 4 && getX() > 0) {
                    setX(getX() - 1);
                    movementPhase = false;
                    System.out.println("Moved West. New map position is: " + getX() + " ," + getY());
                    break;
                }
                else if (input == 4 && getX() <= 0) {
                    System.out.println("You can't go any further West.");
                }

                if (input == 5) {
                    movementPhase = false;
                    System.out.println("I must not yet leave. My business is left unfinished");
                    break;
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



    public void encounterPhase() {

    }


    @Override
    public String toString() {

        String returnMe = "";
        returnMe += name;
        return returnMe;
    }
}
