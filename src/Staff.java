public class Staff extends Item {

    public Staff() {
        super();
        name = "Staff";
    }

    public Staff(String rarity) {
        super(rarity);
        name = "Staff";
    }

    @Override
    public Item copy() {
        Item staff = new Staff(this.rarity);
        staff.name = "Staff";
        return staff;
    }
}
