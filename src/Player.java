public class Player {

    protected String name;
    private int hp;
    private int positionX;
    private int positionY;
    private int gold;
    private Location location;

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


    @Override
    public String toString() {

        String returnMe = "";
        returnMe += name;
        return returnMe;
    }
}
