public abstract class Item {

    private int price;
    private String name;
    int ID;

    public Item() {

        name = "";
        price = 0;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void useItem() {

    }

    @Override
    public String toString() {
        String returnMe = "";
        returnMe += name + " = " + price + " gold" + " ***~~~*** Type [ " + ID + " ] to purchase";
        return returnMe;
    }
}
